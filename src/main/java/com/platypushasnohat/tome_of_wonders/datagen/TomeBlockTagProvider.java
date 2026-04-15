package com.platypushasnohat.tome_of_wonders.datagen;

import com.platypushasnohat.tome_of_wonders.TomeOfWonders;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static com.platypushasnohat.tome_of_wonders.registry.TomeBlocks.WHIRLIBOX;
import static com.platypushasnohat.tome_of_wonders.registry.TomeBlocks.WHIRLIGIG;

public class TomeBlockTagProvider extends BlockTagsProvider {

    public TomeBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
        super(output, provider, TomeOfWonders.MOD_ID, helper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                WHIRLIBOX.get()
        );

        this.tag(BlockTags.MINEABLE_WITH_AXE).add(
                WHIRLIGIG.get()
        );
    }
}