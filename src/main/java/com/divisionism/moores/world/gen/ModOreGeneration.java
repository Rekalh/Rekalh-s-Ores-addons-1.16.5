package com.divisionism.moores.world.gen;

import java.util.Set;

import com.divisionism.moores.init.ModBiomes;
import com.divisionism.moores.init.ModBlocks;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
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

	private static Set<Block> whitelist = new ObjectArraySet<>();
	private static Set<BlockState> blacklist = new ObjectArraySet<>();

	public static void generateOres(final BiomeLoadingEvent event) {

		if (event.getName() == ModBiomes.AETHER_MOUNTAINS.get().getRegistryName()) {
			BiomeManager.addBiome(BiomeManager.BiomeType.COOL,
					new BiomeManager.BiomeEntry(ModBiomes.AETHER_MOUNTAINS_KEY, 1));
		}

		addOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
				ModBlocks.COPPER_ORE.get().getDefaultState(), 10, 10, 30, 3);
		addOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
				ModBlocks.TIN_ORE.get().getDefaultState(), 6, 5, 50, 4);
		addOre(event.getGeneration(), BLACKSTONE, ModBlocks.BLAZING_BLACKSTONE.get().getDefaultState(), 20, 0, 100, 10);
		/*
		 * if (event.getCategory().equals(Category.THEEND))
		 * addOreToSurface(event.getGeneration(), new
		 * SimpleBlockStateProvider(Blocks.DIAMOND_BLOCK.getDefaultState()), whitelist,
		 * blacklist, 1, new Vector3i(10, 10, 10));
		 */
		/*
		 * addOreToSurface(event.getGeneration(), new
		 * SimpleBlockStateProvider(Blocks.DIAMOND_BLOCK.getDefaultState()), whitelist,
		 * blacklist, 1, new Vector3i(10, 10, 10));
		 */
		addOreToSurface(event.getGeneration(), new SimpleBlockStateProvider(Blocks.DIAMOND_BLOCK.getDefaultState()),
				whitelist, blacklist, 1, new Vector3i(10, 10, 10));
	}

	private static void addOre(BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state,
			int veinSize, int minHeight, int maxHeight, int spawnRate) {
		settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE.withConfiguration(new OreFeatureConfig(fillerType, state, veinSize))
						.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
						.square().count(spawnRate));
	}

	private static void addOreToSurface(BiomeGenerationSettingsBuilder settings, BlockStateProvider provider,
			Set<Block> whitelist, Set<BlockState> blacklist, int count, Vector3i spread) {
		/*
		 * settings.withFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION,
		 * Feature.FLOWER .withConfiguration(new
		 * BlockClusterFeatureConfig.Builder(provider, new SimpleBlockPlacer())
		 * .whitelist(whitelist).blacklist(blacklist).xSpread(spread.getX()).ySpread(
		 * spread.getY()) .zSpread(spread.getZ()).tries(count).build()));
		 */
		settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.FLOWER.withConfiguration(
						new BlockClusterFeatureConfig.Builder(provider, new SimpleBlockPlacer()).tries(1)
								.xSpread(spread.getX()).ySpread(spread.getY()).zSpread(spread.getZ()).build()));
	}
}
