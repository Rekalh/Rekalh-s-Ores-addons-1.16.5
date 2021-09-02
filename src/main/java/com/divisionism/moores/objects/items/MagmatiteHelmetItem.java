package com.divisionism.moores.objects.items;

import java.util.List;

import com.divisionism.moores.init.ModItems;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class MagmatiteHelmetItem extends ArmorItem {

	private int initialDamage;
	
	public MagmatiteHelmetItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
		super(materialIn, slot, builderIn);
	}
	
	@Override
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("tooltip.moores.magmatite_armor_1"));
		tooltip.add(new TranslationTextComponent("tooltip.moores.magmatite_armor_2"));
	}
	
	@Override
	public void onCraftedBy(ItemStack stack, World worldIn, PlayerEntity playerIn) {
		this.initialDamage = this.getDamage(stack);
	}
	
	/*
	 * <Shitty code ahead. Proceed with caution!>
	 */
	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (!(entityIn instanceof PlayerEntity))
			return;
		PlayerEntity player = (PlayerEntity) entityIn;
		if (this.getDamage(stack) == this.getMaxDamage(stack) - 1) {
			ItemStack helmet = new ItemStack(ModItems.STEEL_HELMET.get());
			helmet.setDamageValue(initialDamage);
			player.inventory.setItem(39, helmet);
			worldIn.playSound(player, player.blockPosition(), SoundEvents.ITEM_BREAK, SoundCategory.PLAYERS, 1.0f,
					1.0f);
			player.inventory.add(new ItemStack(ModItems.DEPLETED_MAGMATITE.get()));
		}
	}
}
