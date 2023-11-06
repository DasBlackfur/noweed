package me.blackfur.noweed.mixin;

import ic2.core.block.crops.CropTileEntity;
import me.blackfur.noweed.Config;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CropTileEntity.class)
public class CropTrampleMixin {

    @Inject(
            method = "onEntityCollided",
            at = @At("HEAD"),
            remap = false,
            cancellable = true
    )
    public void returnBeforeTrample(Entity entity, CallbackInfo ci) {
        if (!Config.CROP_TRAMPLE.get()) {
            ci.cancel();
        }
    }
}
