package com.github.hoshinofw.createbuildstonetoolkit.registries;

import com.github.hoshinofw.createbuildstonetoolkit.core.CreateBuildstoneToolkit;
import com.github.hoshinofw.createbuildstonetoolkit.level.blocks.entities.AssemblyProxyBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class CBTBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CreateBuildstoneToolkit.MOD_ID);

    public static final Supplier<BlockEntityType<AssemblyProxyBlockEntity>> ASSEMBLY_PROXY = BLOCK_ENTITY_TYPES.register("assembly_proxy",
            () -> BlockEntityType.Builder.of(
                    AssemblyProxyBlockEntity::new,
                    CBTBlocks.ASSEMBLY_PROXY.get())
                    .build(null)
    );

    public static void register(IEventBus modbus) {
        BLOCK_ENTITY_TYPES.register(modbus);
    }

}
