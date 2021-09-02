package com.divisionism.moores.tileentities;

import java.util.Random;

import com.divisionism.moores.init.ModTileEntities;

import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

public class BlazingBlackstoneTE extends TileEntity implements ITickableTileEntity {

	private Random random = new Random();

	public BlazingBlackstoneTE() {
		this(ModTileEntities.BLAZING_BLACKSTONE.get());
	}

	public BlazingBlackstoneTE(TileEntityType<?> p_i48289_1_) {
		super(p_i48289_1_);
	}
	
	int ticks = 0;
	@Override
	public void tick() {
		ticks++;
		BlockPos pos = this.getBlockPos();

		if (ticks == 5) {
			this.level.addParticle(ParticleTypes.FLAME, pos.getX() + random.nextDouble(), pos.getY() + 1,
					pos.getZ() + random.nextDouble(), 0, 0.01, 0);
			this.level.addParticle(ParticleTypes.FLAME, pos.getX() + random.nextDouble(), pos.getY(),
					pos.getZ() + random.nextDouble(), 0, -0.01, 0);
			this.level.addParticle(ParticleTypes.FLAME, pos.getX() + random.nextDouble(), pos.getY() + random.nextDouble(),
					pos.getZ() + 1, 0, 0, 0.01);
			this.level.addParticle(ParticleTypes.FLAME, pos.getX() + random.nextDouble(), pos.getY() + random.nextDouble(),
					pos.getZ(), 0, 0, -0.01);
			this.level.addParticle(ParticleTypes.FLAME, pos.getX() + 1, pos.getY() + random.nextDouble(),
					pos.getZ() + random.nextDouble(), 0.01, 0, 0);
			this.level.addParticle(ParticleTypes.FLAME, pos.getX(), pos.getY() + random.nextDouble(),
					pos.getZ() + random.nextDouble(), -0.01, 0, 0);
			
			ticks = 0;
		}
	}
}
