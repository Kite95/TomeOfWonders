package com.platypushasnohat.tome_of_wonders.registry;

import com.platypushasnohat.tome_of_wonders.TomeOfWonders;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;

public final class TomePaintings {

    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS = DeferredRegister.create(Registries.PAINTING_VARIANT, TomeOfWonders.MOD_ID);
    public static Map<String, String> PAINTING_TRANSLATIONS = new HashMap<>();

    // Paintings
    public static final DeferredHolder<PaintingVariant, PaintingVariant> SIGNATURE = painting("signature", "magmastrider", 16, 16, TomeOfWonders.modPrefix("signature"));

    public static DeferredHolder<PaintingVariant, PaintingVariant> painting(String name, String author, int width, int height, ResourceLocation assetId) {
        PAINTING_TRANSLATIONS.put(name, author);
        return PAINTING_VARIANTS.register(name, () -> new PaintingVariant(width, height, assetId));
    }
}