package com.github.hoshinofw.createbuildstonetoolkit.registries;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterClientTooltipComponentFactoriesEvent;

@EventBusSubscriber(value = Dist.CLIENT)
public class CBTEvents {

    @SubscribeEvent
    public static void onTooltipRegistration(RegisterClientTooltipComponentFactoriesEvent event) {
        CBTTooltips.register();
    }

}
