package com.platypushasnohat.tome_of_wonders.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class TomeFoodValues {

    public static final FoodProperties LOLLIPOP = (new FoodProperties.Builder())
            .nutrition(3).saturationModifier(0.15F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 1), 1)
            .alwaysEdible()
            .build();

}
