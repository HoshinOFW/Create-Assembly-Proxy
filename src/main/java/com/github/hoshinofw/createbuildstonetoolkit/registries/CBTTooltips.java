package com.github.hoshinofw.createbuildstonetoolkit.registries;

import com.github.hoshinofw.createbuildstonetoolkit.core.CreateBuildstoneToolkit;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.TooltipModifier;
import net.createmod.catnip.lang.FontHelper;

public class CBTTooltips {
    public static void register() {

        ItemDescription.useKey(
                CBTItems.ASSEMBLY_PROXY.get(),
                "item" + CreateBuildstoneToolkit.MOD_ID +  "assembly_proxy"
        );

          TooltipModifier.REGISTRY.register(
                  CBTItems.ASSEMBLY_PROXY.get(),
                  new ItemDescription.Modifier(CBTItems.ASSEMBLY_PROXY.get(),
                          FontHelper.Palette.STANDARD_CREATE)
                  );
    }
}
