package com.platypushasnohat.tome_of_wonders.registry.tags;

import com.platypushasnohat.tome_of_wonders.TomeOfWonders;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class TOWBiomeTags {

    public static final TagKey<Biome> HAS_SQUILL = modBiomeTag("has_mob/squill");

    private static TagKey<Biome> modBiomeTag(String name) {
        return biomeTag(TomeOfWonders.MOD_ID, name);
    }

    public static TagKey<Biome> biomeTag(String modid, String name) {
        return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(modid, name));
    }
}
