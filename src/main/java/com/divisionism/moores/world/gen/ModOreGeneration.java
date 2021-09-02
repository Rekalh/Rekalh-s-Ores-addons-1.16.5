package com.divisionism.moores.world.gen;

import com.divisionism.moores.init.ModBiomes;
import com.divisionism.moores.init.ModBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class ModOreGeneration {

	public static final RuleTest END_STONE = new BlockMatchRuleTest(Blocks.END_STONE);
	public static final RuleTest BLACKSTONE = new BlockMatchRuleTest(Blocks.BLACKSTONE);

	public static void generateOres(final BiomeLoadingEvent event) {

		addOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.NATURAL_STONE,
				ModBlocks.COPPER_ORE.get().defaultBlockState(), 10, 10, 30, 3);
		addOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.NATURAL_STONE,
				ModBlocks.TIN_ORE.get().defaultBlockState(), 6, 5, 50, 4);
		addOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.NATURAL_STONE,
				ModBlocks.AETHER_CRYSTAL_BLOCK.get().defaultBlockState(), 1, 0, 20, 5);
		addOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.NETHERRACK,
				ModBlocks.YTTRIUM_ORE.get().defaultBlockState(), 5, 35, 100, 6);
		addOre(event.getGeneration(), BLACKSTONE, ModBlocks.BLAZING_BLACKSTONE.get().defaultBlockState(), 20, 0, 100,
				10);
		addOre(event.getGeneration(), BLACKSTONE, ModBlocks.BLAZING_BLACKSTONE.get().defaultBlockState(), 20, 0, 100,
				5);

		if (isGeneratingBiome(event, ModBiomes.AETHER_MOUNTAINS.get())) {
			addOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.NATURAL_STONE,
					ModBlocks.AETHER_CRYSTAL_BLOCK.get().defaultBlockState(), 1, 0, 254, 15);
		}
	}

	private static void addOre(BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state,
			int veinSize, int minHeight, int maxHeight, int spawnRate) {
		settings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE.configured(new OreFeatureConfig(fillerType, state, veinSize))
						.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
						.squared().count(spawnRate));
	}

	private static boolean isGeneratingBiome(final BiomeLoadingEvent event, Biome biome) {
		return event.getCategory().equals(biome.getBiomeCategory())
				&& event.getDepth() == biome.getDepth()
				&& event.getScale() == biome.getScale();
	}
	
	/*
	 * private static void addOreInCaves(BiomeGenerationSettingsBuilder settings,
	 * BlockStateProvider provider, Set<Block> whitelist, Set<BlockState> blacklist,
	 * int count, Vector3i spread) {
	 * settings.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
	 * Feature.NO_BONEMEAL_FLOWER .configured(new
	 * BlockClusterFeatureConfig.Builder(provider, new SimpleBlockPlacer())
	 * .whitelist(whitelist).blacklist(blacklist).xspread(spread.getX()).yspread(
	 * spread.getY()) .zspread(spread.getZ()).tries(count).build())); }
	 */
}
