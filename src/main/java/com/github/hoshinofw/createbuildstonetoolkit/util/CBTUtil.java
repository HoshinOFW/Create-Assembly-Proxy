package com.github.hoshinofw.createbuildstonetoolkit.util;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;

public class CBTUtil {

    public static BlockPos computeOffset(BlockPos origin, BlockPos targetPos) {
        return targetPos.subtract(origin);
    }


    public static CompoundTag createAPTag(BlockPos targetPos) {
        CompoundTag tag = new CompoundTag();
        tag.putIntArray("targetOffset", blockPosToArray(targetPos));
        return tag;
    }

    public static int[] blockPosToArray(BlockPos pos) {
        return new int[]{pos.getX(), pos.getY(), pos.getZ()};
    }

    public static BlockPos getTargetOffsetFromNBT(CompoundTag nbt) {
        int[] array = nbt.getIntArray("targetOffset");

        if (!nbt.contains("targetOffset", Tag.TAG_INT_ARRAY) || (array.length < 3)) {
            return BlockPos.ZERO;
        }

        return new BlockPos(array[0], array[1], array[2]);
    }

}
