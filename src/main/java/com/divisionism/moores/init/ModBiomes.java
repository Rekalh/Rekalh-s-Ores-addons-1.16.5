package com.divisionism.moores.init;

import com.divisionism.moores.OreAddons;
import com.divisionism.moores.surfacebuilders.AetherSurfaceBuilder;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomes {

	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES,
			OreAddons.MOD_ID);
	public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister
			.create(ForgeRegistries.SURFACE_BUILDERS, OreAddons.MOD_ID);

	public static final RegistryKey<Biome> AETHER_MOUNTAINS_KEY = RegistryKey.getOrCreateKey(Registry.BIOME_KEY,
			new ResourceLocation(OreAddons.MOD_ID, "aether_mountains"));
	public static final RegistryObject<Biome> AETHER_MOUNTAINS = BIOMES.register("aether_mountains",
			BiomeMaker::makeVoidBiome);
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> AETHER_BUILDER = SURFACE_BUILDERS
			.register("aether_surface_builder", () -> new AetherSurfaceBuilder(SurfaceBuilderConfig.CODEC));
}
