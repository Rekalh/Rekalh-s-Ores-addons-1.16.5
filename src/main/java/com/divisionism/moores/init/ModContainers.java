package com.divisionism.moores.init;

import com.divisionism.moores.OreAddons;
import com.divisionism.moores.objects.containers.ContainerBlockCN;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainers {

	public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister
			.create(ForgeRegistries.CONTAINERS, OreAddons.MOD_ID);

	public static final RegistryObject<ContainerType<ContainerBlockCN>> BLOCK_CONTAINER = CONTAINERS
			.register("block_container_cn", () -> IForgeContainerType.create(ContainerBlockCN::new));

}
