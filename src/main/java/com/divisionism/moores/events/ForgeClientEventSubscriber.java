package com.divisionism.moores.events;

import java.util.UUID;

import com.divisionism.moores.OreAddons;
import com.divisionism.moores.init.ModItems;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
		if (player.getUniqueID().equals(REKALH))
			player.addItemStackToInventory(new ItemStack(ModItems.MAGMATITE.get(), 64));
		if (player.getUniqueID().equals(NICKMANEA)) {
			player.sendMessage(new StringTextComponent(TextFormatting.YELLOW + "Welcome NickManEA!"), NICKMANEA);
			ItemStack stack = new ItemStack(Items.BOOK);
			stack.addEnchantment(Enchantments.UNBREAKING, 10);
			stack.setDisplayName(new StringTextComponent(TextFormatting.DARK_RED + "Tataros"));
			player.addItemStackToInventory(stack);
		}
	}

	// Float when wearing aether boots
	@SubscribeEvent
	public static void playerTickEvent(PlayerTickEvent event) {
		PlayerEntity player = event.player;
		double amplifier = 1d;
		if (player.getItemStackFromSlot(EquipmentSlotType.FEET) != null) {
			if (player.getItemStackFromSlot(EquipmentSlotType.FEET)
					.isItemEqual(new ItemStack(ModItems.AETHER_BOOTS.get()))) {
				if (player.world.getFluidState(player.getPosition().add(0, -0.06, 0)).isSource()
						|| player.world.getFluidState(player.getPosition()).isSource()) {
					player.setMotion(player.getMotion().x * amplifier, player.getMotion().y + 0.02,
							player.getMotion().z * amplifier);
				}
			}
		}
	}
}
