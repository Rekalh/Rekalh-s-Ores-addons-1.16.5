package com.divisionism.moores;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.divisionism.moores.creativetabs.ModCreativeTabs;
import com.divisionism.moores.init.ModBlocks;
import com.divisionism.moores.init.ModItems;
import com.divisionism.moores.world.ModOreGeneration;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("moores")
public class OreAddons {
	
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "moores";

    public OreAddons() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        
        new ModCreativeTabs();
        
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, ModOreGeneration::generateOres);
    }

    private void setup(final FMLCommonSetupEvent event) {}

    private void doClientStuff(final FMLClientSetupEvent event) {}
}
