package com.platypushasnohat.tome_of_wonders.datagen;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.WritableRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static com.platypushasnohat.tome_of_wonders.registry.TomeBlocks.*;

public class TomeLootProvider extends LootTableProvider {

    public TomeLootProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, BuiltInLootTables.all(), ImmutableList.of(new LootTableProvider.SubProviderEntry(TomeBlockLootTableProvider::new, LootContextParamSets.BLOCK)), provider);
    }

    @Override
    protected void validate(@NotNull WritableRegistry<LootTable> registry, @NotNull ValidationContext context, ProblemReporter.@NotNull Collector collector) {
    }

    public static class TomeBlockLootTableProvider extends BlockLootSubProvider {

        private final Set<Block> knownBlocks = new HashSet<>();

        public TomeBlockLootTableProvider(HolderLookup.Provider provider) {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
        }

        @Override
        protected void add(@NotNull Block block, LootTable.@NotNull Builder builder) {
            super.add(block, builder);
            this.knownBlocks.add(block);
        }

        @Override
        protected void generate() {
            this.dropSelf(WHIRLIBOX.get());
            this.dropSelf(WHIRLIGIG.get());
        }

        @Override
        protected @NotNull Iterable<Block> getKnownBlocks() {
            return knownBlocks;
        }
    }
}
