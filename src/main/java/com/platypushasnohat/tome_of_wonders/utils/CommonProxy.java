package com.platypushasnohat.tome_of_wonders.utils;

import com.platypushasnohat.tome_of_wonders.TomeOfWonders;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = TomeOfWonders.MOD_ID)
public class CommonProxy {
    public void init() {
    }

    public void clientInit() {
    }

    public Object getArmorRenderProperties() {
        return null;
    }
}
