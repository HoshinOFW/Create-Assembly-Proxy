package com.github.hoshinofw.createbuildstonetoolkit.registries;

import com.github.hoshinofw.createbuildstonetoolkit.core.CreateBuildstoneToolkit;
import com.github.hoshinofw.createbuildstonetoolkit.level.blocks.AssemblyProxyBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class CBTBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CreateBuildstoneToolkit.MOD_ID);

    public static final Supplier<Block> ASSEMBLY_PROXY = BLOCKS.register("assembly_proxy",
            () -> new AssemblyProxyBlock(BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .strength(2.0f, 6.0f)
                    .sound(SoundType.STONE)));

    public static void register(IEventBus modBus) {
        BLOCKS.register(modBus);
    }

}
