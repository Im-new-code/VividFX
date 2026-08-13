package com.dibakarnandy.vividfx;

import net.fabricmc.api.ClientModInitializer;

public final class VividFXClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Rendering is injected into GameRenderer. Keeping initialization empty
        // also avoids creating GPU resources before the first render pass.
    }
}
