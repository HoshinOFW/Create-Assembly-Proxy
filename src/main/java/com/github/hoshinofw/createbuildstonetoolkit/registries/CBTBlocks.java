package com.github.hoshinofw.createbuildstonetoolkit.registries;

import com.github.hoshinofw.createbuildstonetoolkit.core.CreateBuildstoneToolkit;
import com.github.hoshinofw.createbuildstonetoolkit.level.blocks.AssemblyProxyBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CBTBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.createBlocks(CreateBuildstoneToolkit.MOD_ID);

    public static final DeferredHolder<Block, Block> ASSEMBLY_PROXY = BLOCKS.register("assembly_proxy",
            () -> new AssemblyProxyBlock(BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .strength(2.0f, 6.0f)
                    .sound(SoundType.STONE)));

    public static void register(IEventBus modBus) {
        BLOCKS.register(modBus);
    }

}
