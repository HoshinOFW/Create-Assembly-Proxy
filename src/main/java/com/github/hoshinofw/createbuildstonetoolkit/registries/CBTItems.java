package com.github.hoshinofw.createbuildstonetoolkit.registries;

import com.github.hoshinofw.createbuildstonetoolkit.core.CreateBuildstoneToolkit;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CBTItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(CreateBuildstoneToolkit.MOD_ID);

    public static final DeferredHolder<Item, Item> ASSEMBLY_PROXY = ITEMS.register("assembly_proxy",
            () -> new BlockItem(CBTBlocks.ASSEMBLY_PROXY.get(), new Item.Properties()));

    public static void register(IEventBus modbus) {
        ITEMS.register(modbus);
    }
}
