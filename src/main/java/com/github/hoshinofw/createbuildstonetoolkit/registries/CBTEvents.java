package com.github.hoshinofw.createbuildstonetoolkit.registries;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterClientTooltipComponentFactoriesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;




@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class CBTEvents {

    @SubscribeEvent
    public static void onTooltipRegistration(RegisterClientTooltipComponentFactoriesEvent event) {
        CBTTooltips.register();
    }

}
