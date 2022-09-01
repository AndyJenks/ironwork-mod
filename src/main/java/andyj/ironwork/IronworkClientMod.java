package andyj.ironwork;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class IronworkClientMod implements ClientModInitializer{

    @Override
    public void onInitializeClient() {
        IronworkMod.LOGGER.info("Initializing Ironwork client");
        BlockRenderLayerMap.INSTANCE.putBlock(IronworkMod.CROSS_TRUSS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(IronworkMod.CROSS_TRUSS_PAINTED, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(IronworkMod.WARREN_TRUSS, RenderType.cutout());
    }
}
