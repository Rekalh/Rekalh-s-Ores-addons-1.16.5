package com.divisionism.moores.events;

import com.divisionism.moores.OreAddons;
import com.divisionism.moores.init.ModItems;

import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = OreAddons.MOD_ID, value = Dist.CLIENT, bus = Bus.FORGE)
public class ForgeClientEventSubscriber {
	
	@SubscribeEvent
	public static void onItemBroken(PlayerDestroyItemEvent event) {
		OreAddons.LOGGER.info("Event fired!");
		if (event.getOriginal().isItemEqual(new ItemStack(ModItems.MAGMATITE_CHESTPLATE.get()))) {
			event.getPlayer().inventory.add(0, new ItemStack(ModItems.STEEL_CHESTPLATE.get()));
			event.getPlayer().inventory.addItemStackToInventory(new ItemStack(ModItems.MAGMATITE.get()));
		}
	}
}
