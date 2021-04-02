package com.divisionism.moores.events;

import com.divisionism.moores.OreAddons;
import com.divisionism.moores.utils.ModDamageSource;

import net.minecraft.util.DamageSource;
import net.minecraft.world.GameType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerChangeGameModeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = OreAddons.MOD_ID, value = Dist.CLIENT, bus = Bus.FORGE)
public class ForgeClientEventSubscriber {

	private static DamageSource damageSource = new ModDamageSource("test");
	
	@SubscribeEvent
	public static void changeGamemodeEvent(PlayerChangeGameModeEvent event) {
		if (event.getNewGameMode().equals(GameType.SURVIVAL)) {
			OreAddons.LOGGER.info("event fired!");
			OreAddons.LOGGER.info(damageSource.toString());
		}
	}
}
