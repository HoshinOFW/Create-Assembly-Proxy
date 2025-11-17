package com.github.hoshinofw.createbuildstonetoolkit.mixin;

import com.github.hoshinofw.buildstonetoolkit.common.level.blocks.GuidedProxy;
import com.simibubi.create.content.equipment.wrench.IWrenchable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;


@Mixin(value = GuidedProxy.class)
public abstract class GuidedProxyBlockMixin implements IWrenchable {

    @Final
    @Shadow
    public static DirectionProperty LINK_DIRECTION;

    @Override
    public BlockState getRotatedBlockState(BlockState originalState, Direction targetedFace) {
        if (!originalState.hasProperty(LINK_DIRECTION))
            return originalState;

        Direction current = originalState.getValue(LINK_DIRECTION);
        Direction rotated = current.getClockWise(targetedFace.getAxis());
        return originalState.setValue(LINK_DIRECTION, rotated);
    }

}
