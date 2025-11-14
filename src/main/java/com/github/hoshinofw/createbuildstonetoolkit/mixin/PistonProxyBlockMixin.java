package com.github.hoshinofw.createbuildstonetoolkit.mixin;

import com.github.hoshinofw.buildstonetoolkit.common.level.blocks.PistonProxy;
import com.simibubi.create.content.equipment.wrench.IWrenchable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PistonProxy.class)
public class PistonProxyBlockMixin implements IWrenchable {
}
