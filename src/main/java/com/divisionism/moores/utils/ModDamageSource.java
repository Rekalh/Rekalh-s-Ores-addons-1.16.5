package com.divisionism.moores.utils;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class ModDamageSource extends DamageSource {

	public ModDamageSource(String damageTypeIn) {
		super(damageTypeIn);
	}
	
	@Override
	public ITextComponent getDeathMessage(LivingEntity entityLivingBaseIn) {
		return new TranslationTextComponent("moores.death_message.baba_booey");
	}
	
	@Override
	public boolean isDamageAbsolute() {
		return true;
	}
	
	@Override
	public boolean isMagicDamage() {
		return true;
	}
	
	@Override
	public boolean isUnblockable() {
		return true;
	}
	
	@Override
	public DamageSource setMagicDamage() {
		return this;
	}
}
