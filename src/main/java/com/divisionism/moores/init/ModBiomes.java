package com.divisionism.moores.init;

import com.divisionism.moores.OreAddons;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomes {

	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES,
			OreAddons.MOD_ID);

	public static final RegistryObject<Biome> AETHER_MOUNTAINS = BIOMES.register("aether_mountains",
			BiomeMaker::makeVoidBiome);
	public static final RegistryKey<Biome> AETHER_MOUNTAINS_KEY = RegistryKey.getOrCreateKey(Registry.BIOME_KEY,
			new ResourceLocation(OreAddons.MOD_ID, "aether_mountains"));
}
