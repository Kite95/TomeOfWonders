package com.platypushasnohat.tome_of_wonders.registry;

import com.platypushasnohat.tome_of_wonders.TomeOfWonders;
import com.platypushasnohat.tome_of_wonders.blocks.WhirliboxBlock;
import com.platypushasnohat.tome_of_wonders.blocks.WhirligigBlock;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class TomeBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TomeOfWonders.MOD_ID);
    public static List<DeferredBlock<? extends Block>> BLOCK_TRANSLATIONS = new ArrayList<>();

    public static final DeferredBlock<Block> WHIRLIGIG = registerBlock("whirligig", () -> new WhirligigBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.HARP).forceSolidOn().noCollission().noOcclusion().strength(1.0F).sound(SoundType.BAMBOO)));
    public static final DeferredBlock<Block> WHIRLIBOX = registerBlock("whirlibox", () -> new WhirliboxBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.HARP).requiresCorrectToolForDrops().strength(3.5F)));

    private static <B extends Block> DeferredBlock<B> registerBlock(String name, Supplier<? extends B> supplier) {
        DeferredBlock<B> block = BLOCKS.register(name, supplier);
        TomeItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        BLOCK_TRANSLATIONS.add(block);
        return block;
    }

    private static <B extends Block> DeferredBlock<B> registerBlockNoLang(String name, Supplier<? extends B> supplier) {
        DeferredBlock<B> block = BLOCKS.register(name, supplier);
        TomeItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    private static <B extends Block> DeferredBlock<B> registerBlockWithoutItem(String name, Supplier<? extends B> supplier) {
        DeferredBlock<B> block = BLOCKS.register(name, supplier);
        BLOCK_TRANSLATIONS.add(block);
        return block;
    }

    private static <B extends Block> DeferredBlock<B> registerBlockWithoutItemNoLang(String name, Supplier<? extends B> supplier) {
        return BLOCKS.register(name, supplier);
    }

    private static BlockBehaviour.Properties registerFlowerPot(FeatureFlag... featureFlags) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY);
        if (featureFlags.length > 0) {
            properties = properties.requiredFeatures(featureFlags);
        }
        return properties;
    }

    private static ToIntFunction<BlockState> litBlockEmission(int lightLevel) {
        return (state) -> state.getValue(BlockStateProperties.LIT) ? lightLevel : 0;
    }
}
