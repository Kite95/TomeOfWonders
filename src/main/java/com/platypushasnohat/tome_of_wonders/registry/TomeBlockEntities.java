package com.platypushasnohat.tome_of_wonders.registry;

import com.platypushasnohat.tome_of_wonders.TomeOfWonders;
import com.platypushasnohat.tome_of_wonders.blocks.blockentity.WhirliboxBlockEntity;
import com.platypushasnohat.tome_of_wonders.blocks.blockentity.WhirligigBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TomeBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, TomeOfWonders.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WhirligigBlockEntity>> WHIRLIGIG_BLOCK_ENTITY = BLOCK_ENTITIES.register("whirligig", () -> BlockEntityType.Builder.of(WhirligigBlockEntity::new, TomeBlocks.WHIRLIGIG.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WhirliboxBlockEntity>> WHIRLIBOX_BLOCK_ENTITY = BLOCK_ENTITIES.register("whirlibox", () -> BlockEntityType.Builder.of(WhirliboxBlockEntity::new, TomeBlocks.WHIRLIBOX.get()).build(null));

}
