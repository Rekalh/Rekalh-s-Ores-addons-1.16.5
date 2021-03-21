package com.divisionism.moores.objects.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CoalPowderItem extends Item {

	public CoalPowderItem(Properties properties) {
		super(properties);
	}

	@Override
	public int getBurnTime(ItemStack itemStack) {
		return 200;
	}
}
