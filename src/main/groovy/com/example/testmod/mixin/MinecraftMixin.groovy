package com.example.testmod.mixin

import com.mojang.blaze3d.platform.Window
import net.minecraft.client.Minecraft
import net.minecraft.client.MouseHandler
import net.minecraft.world.level.block.Blocks
import org.spongepowered.asm.mixin.Final
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.Mutable
import org.spongepowered.asm.mixin.Shadow
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

@Mixin(Minecraft.class)
abstract class MinecraftMixin {
    //
    // Groovy statements don't have to end with a semicolon (;).
    //

    @Shadow
    public Window window

    //
    // Shadow fields are declarations for fields from each type the mixin targets.
    // So, from the Minecraft class here.
    //

    @Shadow
    @Final
    @Mutable
    public MouseHandler mouseHandler

    //
    // @Final and the 'final' keyword should be used when the field is/was final;
    // However, the 'final' keyword has to be omitted if @Mutable is present.
    //
    // @Mutable removes the final modifier from a field.
    // You could also use the accesseditor, but this is faster.
    //

    @Shadow
    abstract String createTitle()

    //
    // @Shadow can also be used for methods.
    // Non-static shadow declarations have to be abstract.
    //

    int tuff = 33

    //
    // ^ This, the 'tuff' field, is a unique field.
    //   So it's just a normal field defined by the mixin.
    //
    //   In runtime, it gets renamed, so that your mixin element names
    //      don't conflict with other mixins.
    //

    //
    // ⇓ Here, a call to this 'abc' method is being prepended
    //   to the 'updateTitle' method on each of the mixin targets.
    //
    //   So, on the Minecraft class.
    //

    @Inject(at = @At("HEAD"), method = "updateTitle")
    void abc(CallbackInfo ci) {
        //
        // Groovy uses the 'as' keyword instead of parentheses for unsafe casting.
        //
        mouseHandler = new MouseHandler(this as Minecraft) {
            @Override
            void onScroll(long handle, double xoffset, double yoffset) {
            }
        }

        //
        // Groovy has global methods (called *default methods*) such as 'println'.
        // You also don't have to use parentheses in function calls.
        //
        println "%%!%% TUFF IS " + tuff
        println "%%!%% TITLE IS " + createTitle()
        println "%%!%% WINDOW IS " + window

        //
        // Here, Groovy's string interpolation shines out:
        //
        println ""
        println "Acacia Door ==> ${Blocks.ACACIA_DOOR}"
        println ""
    }
}
