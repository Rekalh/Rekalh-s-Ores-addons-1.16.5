package com.divisionism.moores.objects.tileentities;

import com.divisionism.moores.OreAddons;
import com.divisionism.moores.init.ModContainers;
import com.divisionism.moores.init.ModTileEntities;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class ContainerBlockTE extends LockableLootTileEntity {

	private int inventorySize = 1;
	private NonNullList<ItemStack> items = NonNullList.<ItemStack>withSize(inventorySize, ItemStack.EMPTY);
	
	public ContainerBlockTE() {
		this(ModTileEntities.ContainerBlockTE.get());
	}
	
	public ContainerBlockTE(TileEntityType<?> typeIn) {
		super(typeIn);
	}

	@Override
	public int getSizeInventory() {
		return this.inventorySize;
	}

	@Override
	protected NonNullList<ItemStack> getItems() {
		return this.items;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> itemsIn) {
		this.items = itemsIn;
	}

	@Override
	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent("container." + OreAddons.MOD_ID + ".container_block");
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		return ModContainers.BLOCK_CONTAINER.get().create(id, player);
	}
}
