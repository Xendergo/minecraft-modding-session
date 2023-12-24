package com.example.mixin;

import com.example.FireSucker;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {
    @Inject(at = @At("HEAD"), method = "isFireImmune()Z", cancellable = true)
    private void init(CallbackInfoReturnable<Boolean> info) {
        var self = (Entity) (Object) this;

        var standingOn = self.getEntityWorld().getBlockState(self.getBlockPos().down(1));

        if (standingOn.getBlock() instanceof FireSucker && standingOn.get(FireSucker.POWERED)) {
            info.setReturnValue(true);
        }
    }
}