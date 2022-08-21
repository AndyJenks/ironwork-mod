package net.fabricmc.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class IronworkClientMod implements ClientModInitializer{

    @Override
    public void onInitializeClient() {
        ExampleMod.LOGGER.info("Initializing Ironwork client");
        BlockRenderLayerMap.INSTANCE.putBlock(ExampleMod.CROSS_TRUSS, RenderLayer.getCutout());
    }
}
