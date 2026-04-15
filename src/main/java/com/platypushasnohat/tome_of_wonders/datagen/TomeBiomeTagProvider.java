package com.platypushasnohat.tome_of_wonders.datagen;

import com.platypushasnohat.tome_of_wonders.TomeOfWonders;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static com.platypushasnohat.tome_of_wonders.registry.tags.TOWBiomeTags.*;

public class TomeBiomeTagProvider extends BiomeTagsProvider {

    public TomeBiomeTagProvider(PackOutput output, CompletableFuture<Provider> provider, @Nullable ExistingFileHelper helper) {
        super(output, provider, TomeOfWonders.MOD_ID, helper);
    }

    @Override
    public void addTags(@NotNull Provider provider) {
        this.tag(HAS_SQUILL).addTag(BiomeTags.IS_OVERWORLD);
    }
}
