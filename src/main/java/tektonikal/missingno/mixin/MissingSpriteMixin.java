package tektonikal.missingno.mixin;

import net.minecraft.client.texture.MissingSprite;
import net.minecraft.client.texture.NativeImage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import tektonikal.missingno.Config;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

@Mixin(MissingSprite.class)
public abstract class MissingSpriteMixin {

    @Unique
    private static BufferedImage br;

    @Inject(method = "createImage(II)Lnet/minecraft/client/texture/NativeImage;", at = @At(value = "HEAD"), cancellable = true)
    private static void oughh(int width, int height, CallbackInfoReturnable<NativeImage> cir) {
        try {
            cir.setReturnValue(NativeImage.read(Files.newInputStream(Path.of(Config.texture))));
            br = ImageIO.read(new File(Config.texture));
            cir.cancel();
        } catch (Exception ignored) {
        }
    }

    @ModifyArgs(method = "createSpriteContents", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/texture/SpriteDimensions;<init>(II)V"))
    private static void oughhh(Args args) {
        if (br != null) {
            args.set(1, br.getHeight());
            args.set(0, br.getWidth());
        }
    }
}