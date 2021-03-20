package com.divisionism.moores.enums.materials;

import com.divisionism.moores.OreAddons;
import com.divisionism.moores.init.ModItems;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public enum ModArmorMaterials implements IArmorMaterial {

	STEEL(OreAddons.MOD_ID + ":steel", 1000, new int[] { 2, 7, 6, 3 }, 0.0f, 0.005f, 15,
			Ingredient.fromItems(ModItems.STEEL_INGOT.get()), SoundEvents.ITEM_ARMOR_EQUIP_IRON),
	BRONZE(OreAddons.MOD_ID + ":bronze", 2500, new int[] { 3, 7, 7, 4 }, 0.0f, 0.01f, 15,
			Ingredient.fromItems(Items.IRON_INGOT), SoundEvents.ITEM_ARMOR_EQUIP_IRON);

	private String name;
	private int durability;
	private int[] damageReduction;
	private float toughness;
	private float knockbackResistance;
	private int enchantability;
	private Ingredient repairMaterial;
	private SoundEvent soundEvent;

	ModArmorMaterials(String name, int durability, int[] damageReduction, float toughness, float knockbackResistance,
			int enchantability, Ingredient repairMaterial, SoundEvent soundEvent) {
		this.durability = durability;
		this.damageReduction = damageReduction;
		this.soundEvent = soundEvent;
		this.repairMaterial = repairMaterial;
		this.name = name;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
	}

	@Override
	public int getDurability(EquipmentSlotType slotIn) {
		return this.durability;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		return this.damageReduction[slotIn.getIndex()];
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public SoundEvent getSoundEvent() {
		return this.soundEvent;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return this.repairMaterial;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
}
