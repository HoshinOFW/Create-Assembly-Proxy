package com.github.hoshinofw.createbuildstonetoolkit.level.blocks.entities;

import com.github.hoshinofw.createbuildstonetoolkit.registries.CBTBlockEntities;
import com.github.hoshinofw.createbuildstonetoolkit.util.CBTUtil;
import com.simibubi.create.foundation.blockEntity.SyncedBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class AssemblyProxyBlockEntity extends SyncedBlockEntity {

    private BlockPos targetOffset = BlockPos.ZERO;

    public AssemblyProxyBlockEntity(BlockPos arg2, BlockState arg3) {
        super(CBTBlockEntities.ASSEMBLY_PROXY.get(), arg2, arg3);
    }

    @Override
    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
        setTargetOffset(CBTUtil.getTargetOffsetFromNBT(tag));
    }

    @Override
    public void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putIntArray("targetOffset", CBTUtil.blockPosToArray(getTargetOffset()));
    }

    @Override
    public @NotNull CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        if (this.targetOffset != null) {tag.putIntArray("targetOffset", CBTUtil.blockPosToArray(this.targetOffset));}
        return tag;
    }

    public BlockPos getTargetOffset() {
        return targetOffset;
    }

    public void setTargetOffset(BlockPos newTargetOffset) {
        targetOffset = newTargetOffset;
    }

    public BlockPos getTargetBlockPos() {
        return this.worldPosition.offset(getTargetOffset());
    }

    public void setTargetBlockPos(BlockPos newTargetPos) {
        targetOffset = newTargetPos.subtract(this.worldPosition);
    }
}
