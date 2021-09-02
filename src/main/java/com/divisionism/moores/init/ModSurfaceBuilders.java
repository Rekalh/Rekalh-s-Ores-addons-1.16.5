package com.divisionism.moores.init;

import com.divisionism.moores.OreAddons;
import com.divisionism.moores.world.surfacebuilders.AetherMountainSurfaceBuilder;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSurfaceBuilders {

	public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister
			.create(ForgeRegistries.SURFACE_BUILDERS, OreAddons.MOD_ID);

	public static final RegistryObject<AetherMountainSurfaceBuilder> AETHER_SURFACE_BUILDER = SURFACE_BUILDERS.register("aether_mountain_surface", 
			() -> new AetherMountainSurfaceBuilder(SurfaceBuilderConfig.CODEC));
}
