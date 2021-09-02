package com.divisionism.moores.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class CrystalMef extends Block {

	private int state;
	private CompoundNBT nbt = new CompoundNBT();

	public CrystalMef(Properties properties) {
		super(properties);
		this.state = -1;
		if (this.nbt.isEmpty())
			this.write(this.nbt);
		else
			this.read(nbt);
	}

	public CrystalMef(Properties properties, int state) {
		super(properties);
		this.state = state;
		if (this.nbt.isEmpty())
			this.write(this.nbt);
		else
			this.read(nbt);
	}

	@Override
	public ActionResultType use(BlockState blockState, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {

		if (!worldIn.isClientSide()) {
				state++;
			switch (this.state) {
				case 0:
					player.sendMessage(new StringTextComponent(TextFormatting.YELLOW + "gato ton"), player.getUUID());
					break;
				case 1:
					player.sendMessage(new StringTextComponent(TextFormatting.YELLOW + "estas bien?"),
							player.getUUID());
					break;
				case 2:
					player.sendMessage(new StringTextComponent(TextFormatting.YELLOW + "colapso."), player.getUUID());
					break;
				case 3:
					player.sendMessage(new StringTextComponent(TextFormatting.YELLOW + "coronavirus"),
							player.getUUID());
					break;
				case 4:
					player.sendMessage(new StringTextComponent(TextFormatting.YELLOW + "abueno adios master"),
							player.getUUID());
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					worldIn.explode(null, pos.getX(), pos.getY() - 1, pos.getZ(), 15f, Explosion.Mode.DESTROY);
					worldIn.destroyBlock(pos, false);
					state = -1;
					break;
			}
			this.write(nbt);
		}
		return ActionResultType.SUCCESS;
	}

	public void write(CompoundNBT nbt) {
		nbt.putInt("state", this.state);
	}

	public void read(CompoundNBT nbt) {
		this.state = nbt.getInt("state");
	}
}
