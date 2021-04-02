package com.divisionism.moores.objects.containers;

import java.util.Objects;

import com.divisionism.moores.init.ModBlocks;
import com.divisionism.moores.init.ModContainers;
import com.divisionism.moores.objects.tileentities.ContainerBlockTE;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

public class ContainerBlockCN extends Container {

	private IWorldPosCallable worldPosCallable;

	public ContainerBlockCN(final int windowId, final PlayerInventory inv, final ContainerBlockTE te) {
		super(ModContainers.BLOCK_CONTAINER.get(), windowId);
		
		worldPosCallable = IWorldPosCallable.of(te.getWorld(), te.getPos());
		
		int startX = 8;
		int startY = 18;
		int slotSizePlus2 = 18;
		this.addSlot(new Slot(inv, 0, startX, startY));
		
		// Main Player Inventory
		int startPlayerInvY = startY * 5 + 12;
		for (int row = 0; row < 3; ++row) {
			for (int column = 0; column < 9; ++column) {
				this.addSlot(new Slot(inv, 9 + (row * 9) + column, startX + (column * slotSizePlus2),
						startPlayerInvY + (row * slotSizePlus2)));
			}
		}

		// Hotbar
		int hotbarY = startPlayerInvY + (startPlayerInvY / 2) + 7;
		for (int column = 0; column < 9; ++column) {
			this.addSlot(new Slot(inv, column, startX + (column * slotSizePlus2), hotbarY));
		}
	}
	
	public ContainerBlockCN(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
		this(windowId, playerInventory, getTileEntity(playerInventory, data));
	}
	
	private static ContainerBlockTE getTileEntity(PlayerInventory inv, PacketBuffer data) {
		Objects.requireNonNull(inv, "Inventory cannot be null");
		Objects.requireNonNull(data, "Data cannot be null");
		TileEntity tileAtPos = inv.player.world.getTileEntity(data.readBlockPos());
		if (tileAtPos instanceof ContainerBlockTE)
			return (ContainerBlockTE) tileAtPos;
		throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(worldPosCallable, playerIn, ModBlocks.CONTAINER_BLOCK.get());
	}
}
