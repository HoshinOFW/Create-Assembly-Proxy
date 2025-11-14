package com.github.hoshinofw.createbuildstonetoolkit.registries;

import com.github.hoshinofw.createbuildstonetoolkit.core.CreateBuildstoneToolkit;
import com.github.hoshinofw.createbuildstonetoolkit.level.blocks.entities.AssemblyProxyBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CBTBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, CreateBuildstoneToolkit.MOD_ID);

    public static final Supplier<BlockEntityType<AssemblyProxyBlockEntity>> ASSEMBLY_PROXY = BLOCK_ENTITY_TYPES.register("assembly_proxy",
            () -> BlockEntityType.Builder.of(
                    AssemblyProxyBlockEntity::new,
                    CBTBlocks.ASSEMBLY_PROXY.get()
                    )
                    .build(null)
    );

    public static void register(IEventBus modbus) {
        BLOCK_ENTITY_TYPES.register(modbus);
    }

}
