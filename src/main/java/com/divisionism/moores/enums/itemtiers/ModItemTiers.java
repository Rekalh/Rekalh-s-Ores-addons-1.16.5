package com.divisionism.moores.enums.itemtiers;

import com.divisionism.moores.init.ModItems;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum ModItemTiers implements IItemTier {
	BRONZE(2000, 10, 2, 5, 15, Ingredient.fromItems(ModItems.COPPER_INGOT.get())),
	STEEL(1000, 7, 5, 4, 10, Ingredient.fromItems(ModItems.STEEL_INGOT.get()));

	private int durability;
	private int efficiency;
	private int damage;
	private int harvestLevel;
	private int enchantability;
	private Ingredient repairMaterial;
	
	ModItemTiers(int durability, int efficiency, int damage, int harvestLevel, int enchantability,
			Ingredient repairMaterial) {
		this.durability = durability;
		this.efficiency = efficiency;
		this.damage = damage;
		this.harvestLevel = harvestLevel;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
	}

	@Override
	public int getMaxUses() {
		return this.durability;
	}

	@Override
	public float getEfficiency() {
		return this.efficiency;
	}

	@Override
	public float getAttackDamage() {
		return this.damage;
	}

	@Override
	public int getHarvestLevel() {
		return this.harvestLevel;
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return this.repairMaterial;
	}
}
