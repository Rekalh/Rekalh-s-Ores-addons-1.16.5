package com.divisionism.moores.init;

import com.divisionism.moores.OreAddons;
import com.divisionism.moores.tileentities.BlazingBlackstoneTE;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister
			.create(ForgeRegistries.TILE_ENTITIES, OreAddons.MOD_ID);

	public static final RegistryObject<TileEntityType<BlazingBlackstoneTE>> BLAZING_BLACKSTONE = TILE_ENTITIES.register(
			"blazing_blackstone_tile",
			() -> TileEntityType.Builder.of(BlazingBlackstoneTE::new, ModBlocks.BLAZING_BLACKSTONE.get()).build(null));

}
