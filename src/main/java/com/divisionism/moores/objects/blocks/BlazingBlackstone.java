package com.divisionism.moores.objects.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.divisionism.moores.init.ModTileEntities;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class BlazingBlackstone extends Block {

	private Random random = new Random();

	public BlazingBlackstone(Properties properties) {
		super(properties);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return ModTileEntities.BLAZING_BLACKSTONE.get().create();
	}
	
	@Override
	public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {

		if (!(placer instanceof PlayerEntity)) return;
		
		if (!worldIn.dimensionType().ultraWarm()) {
			for (int i = 0; i < 5; i++) {
				worldIn.addParticle(ParticleTypes.LARGE_SMOKE, pos.getX() + random.nextFloat(), pos.getY() + 1,
						pos.getZ() + random.nextFloat(), 0f, 0.1f, 0f);
			}
			worldIn.playSound((PlayerEntity) placer, pos, SoundEvents.FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1f,
					1f);
		}

		if (getSurroundingBlocks(worldIn, pos).contains(Fluids.WATER.defaultFluidState().createLegacyBlock().getBlock())
				|| getSurroundingBlocks(worldIn, pos)
						.contains(Fluids.FLOWING_WATER.defaultFluidState().createLegacyBlock().getBlock())) {
			worldIn.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, pos.getX() + random.nextFloat(), pos.getY() + 1,
					pos.getZ() + random.nextFloat(), 0f, 0.1f, 0f);
			worldIn.playSound((PlayerEntity) placer, pos, SoundEvents.FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1f,
					1f);
			worldIn.setBlock(pos, Blocks.BLACKSTONE.defaultBlockState(), 0);

		}
		super.setPlacedBy(worldIn, pos, state, placer, stack);
	}

	@Override
	public void appendHoverText(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip,
			ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("tooltip.moores.blazing_blackstone"));
	}
	
	@Override
	public void stepOn(World worldIn, BlockPos pos, Entity entityIn) {
		if (entityIn instanceof LivingEntity) {
			((LivingEntity) entityIn).setSecondsOnFire(60);;
		}
	}
	
	@Override
	public boolean addDestroyEffects(BlockState state, World world, BlockPos pos, ParticleManager manager) {
		for (int i = 0; i < 15; i++) {
			world.addParticle(ParticleTypes.SMOKE, pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f,
					random.nextFloat(), random.nextFloat(), random.nextFloat());
			world.addParticle(ParticleTypes.FLAME, pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f,
					random.nextFloat(), random.nextFloat(), random.nextFloat());
			world.addParticle(ParticleTypes.LARGE_SMOKE, pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f,
					random.nextFloat(), random.nextFloat(), random.nextFloat());
		}
		return true;
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return true;
	}

	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		if (getSurroundingBlocks(worldIn, pos).contains(Blocks.AIR)) {
			for (int i = 0; i < 50; i++) {
				worldIn.sendParticles(ParticleTypes.SMOKE, pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f,
						random.nextInt(5), 0.1f, 0, 0.1f, 0.1f);
				worldIn.sendParticles(ParticleTypes.FLAME, pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f,
						random.nextInt(5), 0.1f, 0, 0.1f, 0.1f);
				worldIn.sendParticles(ParticleTypes.LARGE_SMOKE, pos.getX() + 0.5f, pos.getY() + 0.5f,
						pos.getZ() + 0.5f, 1, 0.1f, 0, 0.1f, 0.1f);
			}
		}
	}
	
	private ArrayList<Block> getSurroundingBlocks(World world, BlockPos pos) {
		ArrayList<Block> surroundingBlocks = new ArrayList<>();
		for (int x = -1; x < 2; x++) {
			if (x == 0)
				continue;
			surroundingBlocks.add(world.getBlockState(new BlockPos(pos.getX() + x, pos.getY(), pos.getZ())).getBlock());
		}
		for (int z = -1; z < 2; z++) {
			if (z == 0)
				continue;
			surroundingBlocks.add(world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + z)).getBlock());
		}
		for (int y = -1; y < 2; y++) {
			if (y == 0)
				continue;
			surroundingBlocks.add(world.getBlockState(new BlockPos(pos.getX(), pos.getY() + y, pos.getZ())).getBlock());
		}
		return surroundingBlocks;
	}
}
