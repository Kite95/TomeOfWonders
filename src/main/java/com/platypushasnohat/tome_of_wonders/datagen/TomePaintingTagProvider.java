package com.platypushasnohat.tome_of_wonders.datagen;

import com.platypushasnohat.tome_of_wonders.TomeOfWonders;
import com.platypushasnohat.tome_of_wonders.registry.TomePaintings;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PaintingVariantTagsProvider;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class TomePaintingTagProvider extends PaintingVariantTagsProvider {

    public TomePaintingTagProvider(PackOutput packOutput, CompletableFuture<Provider> lookupProvider, ExistingFileHelper helper) {
        super(packOutput, lookupProvider, TomeOfWonders.MOD_ID, helper);
    }

    @Override
    protected void addTags(@NotNull Provider provider) {
        TagAppender<PaintingVariant> appender = this.tag(PaintingVariantTags.PLACEABLE);
        for (DeferredHolder<PaintingVariant, ? extends PaintingVariant> variant : TomePaintings.PAINTING_VARIANTS.getEntries()) {
            appender.add(variant.getKey());
        }
    }
}
