package com.dibakarnandy.vividfx;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderEffect;
import net.minecraft.util.Identifier;

import java.io.IOException;

/** Lightweight screen-space effects. No colored-light engine is included. */
public final class VividFX {
    public static boolean ENABLED = true;
    private static ShaderEffect effect;
    private static int width = -1;
    private static int height = -1;
    private static boolean failed;

    private VividFX() {}

    public static void render(MinecraftClient client, float tickDelta) {
        if (!ENABLED || failed || client.world == null) return;

        try {
            if (effect == null) {
                effect = new ShaderEffect(
                    client.getTextureManager(),
                    client.getResourceManager(),
                    client.getFramebuffer(),
                    new Identifier("vividfx", "shaders/post/vividfx.json")
                );
                width = client.getWindow().getFramebufferWidth();
                height = client.getWindow().getFramebufferHeight();
            } else {
                int w = client.getWindow().getFramebufferWidth();
                int h = client.getWindow().getFramebufferHeight();
                if (w != width || h != height) {
                    effect.setupDimensions(w, h);
                    width = w;
                    height = h;
                }
            }

            effect.render(tickDelta);
        } catch (IOException | RuntimeException e) {
            failed = true;
            System.err.println("[VividFX] Disabled after shader initialization/render failure: " + e);
        }
    }

    public static void reset() {
        if (effect != null) {
            effect.close();
            effect = null;
        }
        failed = false;
        width = -1;
        height = -1;
    }
}
