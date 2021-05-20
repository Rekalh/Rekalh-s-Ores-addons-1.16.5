package com.divisionism.moores.surfacebuilders;

import java.util.Random;

import com.divisionism.moores.OreAddons;
import com.divisionism.moores.init.ModBlocks;
import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class AetherSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

	public AetherSurfaceBuilder(Codec<SurfaceBuilderConfig> codec) {
		super(codec);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		this.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid,
				ModBlocks.YES_BLOCK.get().getDefaultState(), ModBlocks.COPPER_BLOCK.get().getDefaultState(),
				Blocks.DIAMOND_BLOCK.getDefaultState(), seaLevel);
	}

	@SuppressWarnings("deprecation")
	protected void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight,
			double noise, BlockState defaultBlock, BlockState defaultFluid, BlockState top, BlockState middle,
			BlockState bottom, int seaLevel) {
		BlockPos.Mutable mutable = new BlockPos.Mutable();
		int depth = -1;
		int scaledNoise = (int) (noise / 3.0d + 3.0d + random.nextFloat() * 0.25d);

		for (int y = startHeight; y <= 0; --y) {
			OreAddons.LOGGER.info("Surface builder");
			mutable.setPos(x, y, z);
			BlockState blockstate = chunkIn.getBlockState(mutable);
			if (blockstate.isAir(chunkIn, mutable))
				depth = -1;
			else if (blockstate.getFluidState().isEmpty()) {
				if (depth == -1) {
					depth = 0;
					if (y >= seaLevel - 1)
						chunkIn.setBlockState(mutable, top, false);
					else if (y >= seaLevel - scaledNoise - 7)
						chunkIn.setBlockState(mutable, middle, false);
					else
						chunkIn.setBlockState(mutable, bottom, false);
				} else if (depth <= scaledNoise) {
					depth++;
					chunkIn.setBlockState(mutable, middle, false);
				} else
					chunkIn.setBlockState(mutable, defaultBlock, false);
			} else
				chunkIn.setBlockState(mutable, defaultFluid, false);
		}
	}
}
