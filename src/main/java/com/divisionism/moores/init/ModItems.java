package com.divisionism.moores.init;

import com.divisionism.moores.OreAddons;
import com.divisionism.moores.creativetabs.ModCreativeTabs;
import com.divisionism.moores.enums.itemtiers.ModItemTiers;
import com.divisionism.moores.enums.materials.ModArmorMaterials;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OreAddons.MOD_ID);

	// Register items
	public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
			() -> new Item(new Item.Properties().group(ModCreativeTabs.INGOTS)));
	public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot",
			() -> new Item(new Item.Properties().group(ModCreativeTabs.INGOTS)));
	public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot",
			() -> new Item(new Item.Properties().group(ModCreativeTabs.INGOTS)));
	public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot",
			() -> new Item(new Item.Properties().group(ModCreativeTabs.INGOTS)));
	public static final RegistryObject<Item> IRON_POWDER = ITEMS.register("iron_powder",
			() -> new Item(new Item.Properties().group(ModCreativeTabs.INGOTS)));
	public static final RegistryObject<Item> COAL_POWDER = ITEMS.register("coal_powder",
			() -> new Item(new Item.Properties().group(ModCreativeTabs.INGOTS)));
	public static final RegistryObject<Item> STEEL_DUST = ITEMS.register("steel_dust",
			() -> new Item(new Item.Properties().group(ModCreativeTabs.INGOTS)));
	public static final RegistryObject<Item> STEEL_POWDER = ITEMS.register("steel_powder",
			() -> new Item(new Item.Properties().group(ModCreativeTabs.INGOTS)));
	public static final RegistryObject<Item> COPPER_POWDER = ITEMS.register("copper_powder",
			() -> new Item(new Item.Properties().group(ModCreativeTabs.INGOTS)));
	public static final RegistryObject<Item> TIN_POWDER = ITEMS.register("tin_powder",
			() -> new Item(new Item.Properties().group(ModCreativeTabs.INGOTS)));
	public static final RegistryObject<Item> BRONZE_DUST = ITEMS.register("bronze_dust",
			() -> new Item(new Item.Properties().group(ModCreativeTabs.INGOTS)));
	public static final RegistryObject<Item> BRONZE_POWDER = ITEMS.register("bronze_powder",
			() -> new Item(new Item.Properties().group(ModCreativeTabs.INGOTS)));

	// Tools
	public static final RegistryObject<PickaxeItem> STEEL_PICKAXE = ITEMS.register("steel_pickaxe",
			() -> new PickaxeItem(ModItemTiers.STEEL, 1, -2.8f, new Item.Properties().group(ModCreativeTabs.TOOLS)));
	public static final RegistryObject<SwordItem> STEEL_SWORD = ITEMS.register("steel_sword",
			() -> new SwordItem(ModItemTiers.STEEL, 8, -2.4f, new Item.Properties().group(ModCreativeTabs.TOOLS)));
	public static final RegistryObject<AxeItem> STEEL_AXE = ITEMS.register("steel_axe",
			() -> new AxeItem(ModItemTiers.STEEL, 10, -3f, new Item.Properties().group(ModCreativeTabs.TOOLS)));
	public static final RegistryObject<ShovelItem> STEEL_SHOVEL = ITEMS.register("steel_shovel",
			() -> new ShovelItem(ModItemTiers.STEEL, 4, -3f, new Item.Properties().group(ModCreativeTabs.TOOLS)));
	public static final RegistryObject<HoeItem> STEEL_HOE = ITEMS.register("steel_hoe",
			() -> new HoeItem(ModItemTiers.STEEL, 0, 0, new Item.Properties().group(ModCreativeTabs.TOOLS)));
	public static final RegistryObject<PickaxeItem> BRONZE_PICKAXE = ITEMS.register("bronze_pickaxe",
			() -> new PickaxeItem(ModItemTiers.BRONZE, 2, -2.8f, new Item.Properties().group(ModCreativeTabs.TOOLS)));
	public static final RegistryObject<SwordItem> BRONZE_SWORD = ITEMS.register("bronze_sword",
			() -> new SwordItem(ModItemTiers.BRONZE, 9, -2.4f, new Item.Properties().group(ModCreativeTabs.TOOLS)));
	public static final RegistryObject<AxeItem> BRONZE_AXE = ITEMS.register("bronze_axe",
			() -> new AxeItem(ModItemTiers.BRONZE, 12, -3f, new Item.Properties().group(ModCreativeTabs.TOOLS)));
	public static final RegistryObject<ShovelItem> BRONZE_SHOVEL = ITEMS.register("bronze_shovel",
			() -> new ShovelItem(ModItemTiers.BRONZE, 5, -3f, new Item.Properties().group(ModCreativeTabs.TOOLS)));
	public static final RegistryObject<HoeItem> BRONZE_HOE = ITEMS.register("bronze_hoe",
			() -> new HoeItem(ModItemTiers.BRONZE, 0, 0, new Item.Properties().group(ModCreativeTabs.TOOLS)));

	// Armor
	public static final RegistryObject<ArmorItem> STEEL_HELMET = ITEMS.register("steel_helmet",
			() -> new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlotType.HEAD,
					new Item.Properties().group(ModCreativeTabs.TOOLS)));
	public static final RegistryObject<ArmorItem> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate",
			() -> new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlotType.CHEST,
					new Item.Properties().group(ModCreativeTabs.TOOLS)));
	public static final RegistryObject<ArmorItem> STEEL_LEGGINGS = ITEMS.register("steel_leggings",
			() -> new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlotType.LEGS,
					new Item.Properties().group(ModCreativeTabs.TOOLS)));
	public static final RegistryObject<ArmorItem> STEEL_BOOTS = ITEMS.register("steel_boots",
			() -> new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlotType.FEET,
					new Item.Properties().group(ModCreativeTabs.TOOLS)));

	// Register block-items
	public static final RegistryObject<BlockItem> COPPER_ORE_ITEM = ITEMS.register("copper_ore",
			() -> new BlockItem(ModBlocks.COPPER_ORE.get(), new Item.Properties().group(ModCreativeTabs.ORES)));
	public static final RegistryObject<BlockItem> TIN_ORE_ITEM = ITEMS.register("tin_ore",
			() -> new BlockItem(ModBlocks.TIN_ORE.get(), new Item.Properties().group(ModCreativeTabs.ORES)));
	public static final RegistryObject<BlockItem> STEEL_BLOCK_ITEM = ITEMS.register("steel_block",
			() -> new BlockItem(ModBlocks.STEEL_BLOCK.get(), new Item.Properties().group(ModCreativeTabs.ORES)));
	public static final RegistryObject<BlockItem> COPPER_BLOCK_ITEM = ITEMS.register("copper_block",
			() -> new BlockItem(ModBlocks.COPPER_BLOCK.get(), new Item.Properties().group(ModCreativeTabs.ORES)));
	public static final RegistryObject<BlockItem> TIN_BLOCK_ITEM = ITEMS.register("tin_block",
			() -> new BlockItem(ModBlocks.TIN_BLOCK.get(), new Item.Properties().group(ModCreativeTabs.ORES)));
	public static final RegistryObject<BlockItem> BRONZE_BLOCK_ITEM = ITEMS.register("bronze_block",
			() -> new BlockItem(ModBlocks.BRONZE_BLOCK.get(), new Item.Properties().group(ModCreativeTabs.ORES)));
}
