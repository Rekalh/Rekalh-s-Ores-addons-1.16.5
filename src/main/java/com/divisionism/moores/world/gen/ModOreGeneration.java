package com.divisionism.moores.world.gen;

import com.divisionism.moores.init.ModBiomes;
import com.divisionism.moores.init.ModBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class ModOreGeneration {

	public static final RuleTest END_STONE = new BlockMatchRuleTest(Blocks.END_STONE);
	public static final RuleTest BLACKSTONE = new BlockMatchRuleTest(Blocks.BLACKSTONE);

	public static void generateOres(final BiomeLoadingEvent event) {

		if (event.getName().equals(ModBiomes.AETHER_MOUNTAINS.get().getRegistryName())) {
			BiomeManager.addBiome(BiomeManager.BiomeType.COOL,
					new BiomeManager.BiomeEntry(ModBiomes.AETHER_MOUNTAINS_KEY, 1));
		}

		addOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
				ModBlocks.COPPER_ORE.get().getDefaultState(), 10, 10, 30, 3);
		addOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
				ModBlocks.TIN_ORE.get().getDefaultState(), 6, 5, 50, 4);
		addOre(event.getGeneration(), BLACKSTONE, ModBlocks.BLAZING_BLACKSTONE.get().getDefaultState(), 20, 0, 100, 5);
		// addOre(event.getGeneration(), END_STONE,
		// Blocks.DIAMOND_BLOCK.getDefaultState(), 10, 0, 100, 10);
	}

	private static void addOre(BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state,
			int veinSize, int minHeight, int maxHeight, int spawnRate) {
		settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE.withConfiguration(new OreFeatureConfig(fillerType, state, veinSize))
						.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
						.square().count(spawnRate));
	}
}
