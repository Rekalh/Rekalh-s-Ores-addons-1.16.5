package com.divisionism.moores.init;

import com.divisionism.moores.OreAddons;
import com.divisionism.moores.objects.tileentities.ContainerBlockTE;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister
			.create(ForgeRegistries.TILE_ENTITIES, OreAddons.MOD_ID);

	public static final RegistryObject<TileEntityType<ContainerBlockTE>> ContainerBlockTE = TILE_ENTITIES.register(
			"container_block_te",
			() -> TileEntityType.Builder.create(ContainerBlockTE::new, ModBlocks.CONTAINER_BLOCK.get()).build(null));
}
