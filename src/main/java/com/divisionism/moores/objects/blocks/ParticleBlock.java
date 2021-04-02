package com.divisionism.moores.objects.blocks;

import java.util.Random;

import com.divisionism.moores.utils.ModDamageSource;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion.Mode;
import net.minecraft.world.ExplosionContext;
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
			worldIn.playSound((PlayerEntity) placer, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1f,
					1f);
		}

		for (int x = -1; x < 2; x++) {
			for (int z = -1; z < 2; z++) {
				for (int y = -1; y < 2; y++) {
					if (!worldIn.isRemote) {
						if (worldIn.getFluidState(new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z))
								.getFluid() == Fluids.WATER
								|| worldIn.getFluidState(new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z))
										.getFluid() == Fluids.FLOWING_WATER) {
							worldIn.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, pos.getX() + random.nextFloat(),
									pos.getY() + 1, pos.getZ() + random.nextFloat(), 0f, 0.1f, 0f);
							worldIn.playSound((PlayerEntity) placer, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH,
									SoundCategory.BLOCKS, 1f, 1f);
							worldIn.setBlockState(pos, Blocks.BLACKSTONE.getDefaultState());
							break;
						}
					}
				}
			}
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
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		if (!worldIn.isRemote) {
			worldIn.createExplosion(player, ModDamageSource.causeExplosionDamage(player), (ExplosionContext) null,
					pos.getX(), pos.getY(), pos.getZ(), 1f, false, Mode.DESTROY);
			super.onBlockHarvested(worldIn, pos, state, player);
		}
	}

	@Override
	public boolean ticksRandomly(BlockState state) {
		return true;
	}

	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		for (int i = 0; i < 15; i++) {
			worldIn.spawnParticle(ParticleTypes.SMOKE, pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f,
					random.nextInt(5), 0.1f, 0, 0.1f, 0.1f);
			worldIn.spawnParticle(ParticleTypes.FLAME, pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f,
					random.nextInt(5), 0.1f, 0, 0.1f, 0.1f);
			worldIn.spawnParticle(ParticleTypes.LARGE_SMOKE, pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f, 1,
					0.1f, 0, 0.1f, 0.1f);
		}
	}
}
