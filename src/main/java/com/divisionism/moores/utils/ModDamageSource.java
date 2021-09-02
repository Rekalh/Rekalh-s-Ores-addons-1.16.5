package com.divisionism.moores.utils;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class ModDamageSource extends DamageSource {

	public ModDamageSource(String damageTypeIn) {
		super(damageTypeIn);
	}
	
	@Override
	public ITextComponent getLocalizedDeathMessage(LivingEntity p_151519_1_) {
		return new StringTextComponent("death_message.moores.baba_booey");
	}
}
