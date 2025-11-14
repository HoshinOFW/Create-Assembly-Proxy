package com.github.hoshinofw.createbuildstonetoolkit.level.blocks.entities;

import com.github.hoshinofw.createbuildstonetoolkit.registries.CBTBlockEntities;
import com.github.hoshinofw.createbuildstonetoolkit.util.APUtil;
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
    public void loadAdditional(@NotNull CompoundTag tag, @NotNull HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        setTargetOffset(APUtil.getTargetOffsetFromNBT(tag));
    }

    @Override
    public void saveAdditional(@NotNull CompoundTag tag, @NotNull  HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putIntArray("targetOffset", APUtil.blockPosToArray(getTargetOffset()));
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(@NotNull HolderLookup.Provider provider) {
        CompoundTag tag = super.getUpdateTag(provider);
        if (this.targetOffset != null) {tag.putIntArray("targetOffset", APUtil.blockPosToArray(this.targetOffset));}
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
