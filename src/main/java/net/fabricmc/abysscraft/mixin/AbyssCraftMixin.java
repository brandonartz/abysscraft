package net.fabricmc.abysscraft.mixin;

import net.fabricmc.abysscraft.AbyssCraftMod;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class AbyssCraftMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		AbyssCraftMod.LOGGER.info("This line is printed by an example mod mixin!");
	}
}
