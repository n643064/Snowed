package n643064.snowed.mixin;

import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Biome.class)
public abstract class BiomeMixin {
    @Shadow public abstract Biome.Precipitation getPrecipitation();


    @Inject(method = "getPrecipitation", at = @At("HEAD"), cancellable = true)
    private void getPrecipitation(CallbackInfoReturnable<Biome.Precipitation> cir) {
        cir.setReturnValue(Biome.Precipitation.SNOW);
    }

    @Inject(method = "getTemperature()F", at = @At("HEAD"), cancellable = true)
    private void getTemperature(CallbackInfoReturnable<Float> cir) {
        cir.setReturnValue(0.1f);
    }

    @Inject(method = "getSkyColor", at = @At("HEAD"), cancellable = true)
    private void getSkyColor(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(0xE6EAFF);
    }

    @Inject(method = "getDefaultFoliageColor", at = @At("HEAD"), cancellable = true)
    private void getDefaultFoliageColor(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(0x00806A);
    }

    @Inject(method = "getDefaultGrassColor", at = @At("HEAD"), cancellable = true)
    private void getDefaultGrassColor(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(0x00806A);
    }

    // TODO Make this look better idk.
}
