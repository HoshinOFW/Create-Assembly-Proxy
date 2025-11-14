package com.github.hoshinofw.createbuildstonetoolkit.core;

import com.github.hoshinofw.createbuildstonetoolkit.registries.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Mod(CreateBuildstoneToolkit.MOD_ID)
public final class CreateBuildstoneToolkit {
    public static final String MOD_ID = "createbuildstonetoolkit";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public CreateBuildstoneToolkit(IEventBus modBus) {
        CBTBlocks.register(modBus);
        CBTBlockEntities.register(modBus);
        CBTItems.register(modBus);
        CBTCreativeTabs.register(modBus);
    }
}