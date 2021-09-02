package com.divisionism.moores.objects.items;

import java.util.List;

import com.divisionism.moores.OreAddons;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class YttriumPickaxe extends PickaxeItem {
	
	public YttriumPickaxe(IItemTier p_i48478_1_, int p_i48478_2_, float p_i48478_3_, Properties p_i48478_4_) {
		super(p_i48478_1_, p_i48478_2_, p_i48478_3_, p_i48478_4_);
	}
	
	@Override
	public void appendHoverText(ItemStack stack, World world, List<ITextComponent> tooltip,
			ITooltipFlag p_77624_4_) {
		tooltip.add(new TranslationTextComponent("tooltip.moores.yttrium_pickaxe"));
	}
	
	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		
		ItemStack stack = player.getItemInHand(hand);
		
		OreAddons.LOGGER.info(stack.serializeNBT().contains("radiusEnabled"));
		
		CompoundNBT nbt = stack.serializeNBT();
		
		if (!world.isClientSide) {
			if (!nbt.contains("radiusEnabled")) {
				nbt.putBoolean("radiusEnabled", false);
				stack.save(nbt);
			}
			else {
				nbt.putBoolean("radiusEnabled", !stack.serializeNBT().getBoolean("radiusEnabled"));
				stack.save(nbt);
			}
			
			player.sendMessage(new StringTextComponent(TextFormatting.YELLOW + "AoE: " + nbt.getBoolean("radiusEnabled")), player.getUUID());
		}
			
		return ActionResult.success(player.getItemInHand(hand));
	}
	
	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, PlayerEntity player) {
		
		World world = player.level;
		Direction playerDir = player.getDirection();
		
		if (!((PickaxeItem)(itemstack.getItem())).isCorrectToolForDrops(world.getBlockState(pos)))
			return false;
			
		if (itemstack.serializeNBT().contains("radiusEnabled")) {
			if (itemstack.serializeNBT().getBoolean("radiusEnabled")) {
				world.destroyBlock(pos.relative(playerDir.getClockWise()), true);
				world.destroyBlock(pos.relative(playerDir.getCounterClockWise()), true);
				world.destroyBlock(pos.offset(0, 1, 0), true);
				world.destroyBlock(pos.offset(0, 1, 0).relative(playerDir.getClockWise()), true);
				world.destroyBlock(pos.offset(0, 1, 0).relative(playerDir.getCounterClockWise()), true);
				world.destroyBlock(pos.offset(0, -1, 0), true);
				world.destroyBlock(pos.offset(0, -1, 0).relative(playerDir.getClockWise()), true);
				world.destroyBlock(pos.offset(0, -1, 0).relative(playerDir.getCounterClockWise()), true);
				
				itemstack.hurtAndBreak(9, player, (plr) -> {
					plr.awardStat(Stats.ITEM_BROKEN.get(itemstack.getItem()));
				});
			}
		}
		
		return false;
	}
}
