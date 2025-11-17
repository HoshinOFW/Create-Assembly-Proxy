package com.github.hoshinofw.createbuildstonetoolkit.registries;

import com.github.hoshinofw.createbuildstonetoolkit.core.CreateBuildstoneToolkit;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class CBTItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CreateBuildstoneToolkit.MOD_ID);

    public static final Supplier<Item> ASSEMBLY_PROXY = ITEMS.register("assembly_proxy",
            () -> new BlockItem(CBTBlocks.ASSEMBLY_PROXY.get(), new Item.Properties()));

    public static void register(IEventBus modbus) {
        ITEMS.register(modbus);
    }
}
