package com.divisionism.moores.objects.items;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlazingBlackstoneBlockItem extends BlockItem {

	public BlazingBlackstoneBlockItem(Block blockIn, Properties builder) {
		super(blockIn, builder);
	}
	
	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (!(entityIn instanceof PlayerEntity))
			return;
		PlayerEntity player = (PlayerEntity)entityIn;
		if (!player.isCreative()) player.setSecondsOnFire(1);
	}
}
