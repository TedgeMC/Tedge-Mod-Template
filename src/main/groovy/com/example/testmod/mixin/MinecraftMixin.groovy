package com.example.testmod.mixin

import com.mojang.blaze3d.platform.Window
import net.minecraft.client.Minecraft
import net.minecraft.client.MouseHandler
import org.spongepowered.asm.mixin.Final
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.Mutable
import org.spongepowered.asm.mixin.Shadow
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

@Mixin(Minecraft.class)
abstract class MinecraftMixin {
    @Shadow
    public Window window

    @Shadow
    @Final
    @Mutable
    public MouseHandler mouseHandler

    @Shadow
    abstract String createTitle()

    int tuff = 33

    @Inject(at = @At("HEAD"), method = "updateTitle")
    void abc(CallbackInfo ci) {
        mouseHandler = new MouseHandler(this as Minecraft) {
            @Override
            void onScroll(long handle, double xoffset, double yoffset) {
            }
        }

        println "%%!%% TUFF IS " + tuff
        println "%%!%% TITLE IS " + createTitle()
        println "%%!%% WINDOW IS " + window
    }
}
