package com.divisionism.moores.creativetabs;

import com.divisionism.moores.init.ModItems;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModCreativeTabs {

	public static final ItemGroup INGOTS = new ItemGroup("ingots") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModItems.STEEL_INGOT.get());
		}
	};
	
	public static final ItemGroup ORES = new ItemGroup("ores") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModItems.COPPER_ORE_ITEM.get());
		}
	};
	
	public static final ItemGroup TOOLS = new ItemGroup("tools") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModItems.STEEL_PICKAXE.get());
		}
	};
}
