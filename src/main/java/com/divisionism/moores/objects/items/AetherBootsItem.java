package com.divisionism.moores.objects.items;

import java.util.List;
import java.util.UUID;

import com.divisionism.moores.init.ModAttributes;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class AetherBootsItem extends ArmorItem {

	public AetherBootsItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
		super(materialIn, slot, builderIn);
	}

	@Override
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("tooltip.moores.aether_boots"));
	}

	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		player.addEffect(new EffectInstance(Effects.SLOW_FALLING, 1, 0, true, false));
		player.addEffect(new EffectInstance(Effects.JUMP, 1, 0, true, false));
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlotType equipmentSlot) {
		Builder<Attribute, AttributeModifier> attributes = ImmutableMultimap.builder();

		attributes.put(ModAttributes.FLOAT.get(), new AttributeModifier(
				UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150"), "Floats on water", 1, Operation.ADDITION));
		attributes.put(ModAttributes.JUMP_BOOST.get(), new AttributeModifier(
				UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150"), "Jump Boost", 1, Operation.ADDITION));
		attributes.put(ModAttributes.SLOW_FALLING.get(), new AttributeModifier(
				UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150"), "Slow Falling", 1, Operation.ADDITION));
		
		return this.slot == equipmentSlot ? attributes.build() : super.getDefaultAttributeModifiers(equipmentSlot);
	}
}
