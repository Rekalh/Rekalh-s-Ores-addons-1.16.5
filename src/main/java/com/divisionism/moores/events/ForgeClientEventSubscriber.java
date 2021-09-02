package com.divisionism.moores.events;

import java.util.UUID;

import com.divisionism.moores.OreAddons;
import com.divisionism.moores.init.ModItems;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.stats.Stats;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = OreAddons.MOD_ID, value = Dist.CLIENT, bus = Bus.FORGE)
public class ForgeClientEventSubscriber {

	public static final UUID REKALH = UUID.fromString("b0374e3b-88d6-4843-9906-ea49dc2a59b5");
	public static final UUID NICKMANEA = UUID.fromString("c4761e89-7416-47c5-aa69-59740f5e5eff");

	@SubscribeEvent
	public static void onPlayerJoin(PlayerLoggedInEvent event) {
		PlayerEntity player = event.getPlayer();
		if (player.getUUID().equals(REKALH))
			player.addItem(new ItemStack(ModItems.MAGMATITE.get(), 64));
		else if (player.getUUID().equals(NICKMANEA)) {
			player.sendMessage(new StringTextComponent(TextFormatting.YELLOW + "Welcome NickManEA!"), NICKMANEA);
			ItemStack stack = new ItemStack(Items.BOOK);
			stack.enchant(Enchantments.UNBREAKING, 10);
			stack.setHoverName(new StringTextComponent(TextFormatting.DARK_RED + "Tataros"));
			player.addItem(stack);
		}
	}

	// Float when wearing aether boots
	static double damage = 0;
	@SubscribeEvent
	public static void playerTickEvent(PlayerTickEvent event) {
		PlayerEntity player = event.player;
		double amplifier = 1d;
		
		damage += 0.001;
		
		if (player.getItemBySlot(EquipmentSlotType.FEET) != null) {
			if (player.getItemBySlot(EquipmentSlotType.FEET).sameItem(new ItemStack(ModItems.AETHER_BOOTS.get()))) {
				ItemStack item = player.getItemBySlot(EquipmentSlotType.FEET);
				
				if (player.level.getFluidState(player.blockPosition().offset(0, -0.06, 0)).isSource()
						|| player.level.getFluidState(player.blockPosition()).isSource()) {
					player.setDeltaMovement(player.getDeltaMovement().x * amplifier, player.getDeltaMovement().y + 0.02,
							player.getDeltaMovement().z * amplifier);

					if (!player.isCreative()) {
						item.hurtAndBreak((int)Math.floor(damage), player, (plr) -> {
							if (!plr.level.isClientSide())
								plr.level.playSound(null, plr.blockPosition(), SoundEvents.ITEM_BREAK, SoundCategory.NEUTRAL, 1, 1);
							plr.awardStat(Stats.ITEM_BROKEN.get(item.getItem()));
							item.shrink(1);
						});
					}
					
					if (damage >= 1.001) damage = 0;
				}
			}
		}
	}
}
