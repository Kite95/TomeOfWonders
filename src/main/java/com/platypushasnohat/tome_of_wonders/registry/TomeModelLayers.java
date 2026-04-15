package com.platypushasnohat.tome_of_wonders.registry;

import com.platypushasnohat.tome_of_wonders.TomeOfWonders;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TomeModelLayers {

    public static final ModelLayerLocation SQUILL = main("squill");

    public static final ModelLayerLocation WHIRLICAP = main("whirlicap");
    public static final ModelLayerLocation WHIRLIGIG = main("whirligig");

    private static ModelLayerLocation register(String id, String name) {
        return new ModelLayerLocation(TomeOfWonders.modPrefix(id), name);
    }

    private static ModelLayerLocation main(String id) {
        return register(id, "main");
    }
}
