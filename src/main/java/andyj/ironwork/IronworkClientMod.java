package andyj.ironwork;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class IronworkClientMod implements ClientModInitializer{

    @Override
    public void onInitializeClient() {
        IronworkMod.LOGGER.info("Initializing Ironwork client");
        BlockRenderLayerMap.INSTANCE.putBlock(IronworkMod.CROSS_TRUSS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(IronworkMod.CROSS_TRUSS_BLACK, RenderLayer.getCutout());

    }
}
