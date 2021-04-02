package com.divisionism.moores.init;

import com.divisionism.moores.OreAddons;
import com.divisionism.moores.objects.blocks.ContainerBlock;
import com.divisionism.moores.objects.blocks.ParticleBlock;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			OreAddons.MOD_ID);

	// Register blocks
	public static final RegistryObject<Block> CRYSTAL_MEF = BLOCKS.register("crystal_mef",
			() -> new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(100f, 100f)
					.harvestLevel(4).jumpFactor(1f).slipperiness(0.5f).variableOpacity()));
	public static final RegistryObject<Block> YES_BLOCK = BLOCKS.register("yes_block",
			() -> new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(100f, 100f)
					.harvestLevel(4).jumpFactor(1f).slipperiness(0.5f).variableOpacity()));
	public static final RegistryObject<Block> PARTICLE_BLOCK = BLOCKS.register("particle_block",
			() -> new ParticleBlock(AbstractBlock.Properties.create(Material.ORGANIC).harvestTool(ToolType.PICKAXE)
					.hardnessAndResistance(20f)));
	public static final RegistryObject<Block> CONTAINER_BLOCK = BLOCKS.register("container_block",
			() -> new ContainerBlock(AbstractBlock.Properties.from(Blocks.STONE)));

	public static final RegistryObject<Block> COPPER_ORE = BLOCKS.register("copper_ore",
			() -> new Block(AbstractBlock.Properties.from(Blocks.IRON_ORE)));
	public static final RegistryObject<Block> TIN_ORE = BLOCKS.register("tin_ore",
			() -> new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(4)));
	public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block",
			() -> new Block(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)));
	public static final RegistryObject<Block> COPPER_BLOCK = BLOCKS.register("copper_block",
			() -> new Block(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)));
	public static final RegistryObject<Block> TIN_BLOCK = BLOCKS.register("tin_block",
			() -> new Block(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)));
	public static final RegistryObject<Block> BRONZE_BLOCK = BLOCKS.register("bronze_block",
			() -> new Block(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)));
}
