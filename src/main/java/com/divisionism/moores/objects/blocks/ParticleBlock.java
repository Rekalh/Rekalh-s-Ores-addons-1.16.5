package com.divisionism.moores.objects.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion.Mode;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class ParticleBlock extends Block {

	private Random random = new Random();

	public ParticleBlock(Properties properties) {
		super(properties);
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		if (!worldIn.getDimensionType().isUltrawarm()) {
			for (int i = 0; i < 5; i++) {
				worldIn.addParticle(ParticleTypes.LARGE_SMOKE, pos.getX() + random.nextFloat(), pos.getY() + 1,
						pos.getZ() + random.nextFloat(), 0f, 0.1f, 0f);
			}
			worldIn.playSound((PlayerEntity) placer, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, 
					SoundCategory.BLOCKS,1f, 1f);
		}
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
	}

	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		if (entityIn instanceof LivingEntity) {
			((LivingEntity) entityIn).setFire(60);
		}
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		if (!worldIn.isRemote) {
			worldIn.createExplosion(player, pos.getX(), pos.getY(), pos.getZ(), 1f, Mode.DESTROY);
			super.onBlockHarvested(worldIn, pos, state, player);
		}
	}

	int counter = 0;

	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		System.out.println("hello");
		counter++;
		if (counter == 60) {
			for (int i = 0; i < 5; i++) {
				worldIn.addParticle(ParticleTypes.LARGE_SMOKE, pos.getX() + random.nextFloat(), pos.getY() + 1,
						pos.getZ() + random.nextFloat(), 0f, 0.1f, 0f);
			}
			counter = 0;
		}
	}
}
