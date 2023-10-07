package me.blackfur.noweed.mixin;

import ic2.core.block.crops.CropTileEntity;
import me.blackfur.noweed.Config;
import net.minecraftforge.common.ForgeConfig;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Debug(export = true)
@Mixin(CropTileEntity.class)
public class WeedGrowMixin {
    @Inject(
            method = "update",
            at = @At(value = "INVOKE", target = "Lic2/core/block/crops/CropTileEntity;removeCrop()V", shift = At.Shift.BEFORE, ordinal = 0),
            remap = false,
            cancellable = true
    )
    public void returnBeforeGrowing(int tickrate, CallbackInfo ci) {
        if (!Config.WEED_GROW.get()) {
            ci.cancel();
        }
    }

    @Inject(
            method = "generateWeed",
            at = @At("HEAD"),
            remap = false,
            cancellable = true
    )
    public void returnBeforeGenerate(CallbackInfo ci) {
        if (!Config.WEED_SPREAD.get()) {
            ci.cancel();
        }
    }
}
