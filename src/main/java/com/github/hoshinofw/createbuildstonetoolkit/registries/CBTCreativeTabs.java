package com.github.hoshinofw.createbuildstonetoolkit.registries;

import com.github.hoshinofw.createbuildstonetoolkit.core.CreateBuildstoneToolkit;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class CBTCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateBuildstoneToolkit.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ASSEMBLY_PROXY =
            TABS.register("assembly_proxy", () ->
                    CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup." + CreateBuildstoneToolkit.MOD_ID + ".assembly_proxy"))
                            .icon(() -> new ItemStack(CBTItems.ASSEMBLY_PROXY.get()))
                            .displayItems((params, output) -> {
                                output.accept(CBTItems.ASSEMBLY_PROXY.get());
                            })
                            .build());

    public static void register(IEventBus modBus) {
        TABS.register(modBus);
    }
}
