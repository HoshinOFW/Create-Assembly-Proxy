package com.github.hoshinofw.createbuildstonetoolkit.core;

import com.github.hoshinofw.createbuildstonetoolkit.registries.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

@Mod(CreateBuildstoneToolkit.MOD_ID)
public final class CreateBuildstoneToolkit {
    public static final String MOD_ID = "createbuildstonetoolkit";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public CreateBuildstoneToolkit() {
        IEventBus modBus = Objects.requireNonNull(FMLJavaModLoadingContext.get().getModEventBus());
        CBTBlocks.register(modBus);
        CBTBlockEntities.register(modBus);
        CBTItems.register(modBus);
        CBTCreativeTabs.register(modBus);
        LOGGER.info("Construct finished!");
    }
}