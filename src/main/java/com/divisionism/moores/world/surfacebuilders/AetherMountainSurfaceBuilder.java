package com.divisionism.moores.world.surfacebuilders;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class AetherMountainSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

	public static final BlockState SNOW = Blocks.SNOW_BLOCK.defaultBlockState();
	public static final BlockState STONE = Blocks.STONE.defaultBlockState();
	
	public static final SurfaceBuilderConfig AETHER_CONFIG = new SurfaceBuilderConfig(SNOW, STONE, STONE);
	
	public AetherMountainSurfaceBuilder(Codec<SurfaceBuilderConfig> codec) {
		super(codec);
	}

	@Override
	public void apply(Random random, IChunk chunk, Biome biome, int x, int y,
			int z, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel,
			long seed, SurfaceBuilderConfig config) {
		SurfaceBuilder.DEFAULT.apply(random, chunk, biome, x, y, z, noise, defaultBlock, defaultFluid, seaLevel, seed, AETHER_CONFIG);
	}
}
