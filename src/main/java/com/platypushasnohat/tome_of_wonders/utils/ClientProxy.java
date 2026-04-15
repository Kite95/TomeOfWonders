package com.platypushasnohat.tome_of_wonders.utils;

import com.platypushasnohat.tome_of_wonders.TomeOfWonders;
import com.platypushasnohat.tome_of_wonders.client.renderer.items.TOWArmorRenderProperties;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.common.EventBusSubscriber;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = TomeOfWonders.MOD_ID, value = Dist.CLIENT)
public class ClientProxy extends CommonProxy {

    public void init() {
    }

    public void clientInit() {
    }

    @Override
    public Object getArmorRenderProperties() {
        return new TOWArmorRenderProperties();
    }
}
