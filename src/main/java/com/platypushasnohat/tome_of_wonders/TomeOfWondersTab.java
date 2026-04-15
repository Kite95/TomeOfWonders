package com.platypushasnohat.tome_of_wonders;

import com.platypushasnohat.tome_of_wonders.registry.TomeBlocks;
import com.platypushasnohat.tome_of_wonders.registry.TomeEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.platypushasnohat.tome_of_wonders.registry.TomeItems.*;

public class TomeOfWondersTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TomeOfWonders.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TOME_OF_WONDERS_TAB = CREATIVE_TABS.register("tome_of_wonders",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(WHIRLICAP.get()))
                    .title(Component.translatable("itemGroup.tome_of_wonders"))
                    .displayItems((parameters, output) -> {

                        output.accept(SQUILL_SPAWN_EGG.get());
                        output.accept(SQUILL_TOOTH.get());
                        output.accept(TOOTHED_SNOWBALL.get());
                        output.accept(TomeEffects.createPotion(TomeEffects.LEVITATION_POTION.get()));
                        output.accept(TomeEffects.createSplashPotion(TomeEffects.LEVITATION_POTION.get()));
                        output.accept(TomeEffects.createLingeringPotion(TomeEffects.LEVITATION_POTION.get()));
                        output.accept(TomeEffects.createTippedArrow(TomeEffects.LEVITATION_POTION.get()));
                        output.accept(TomeBlocks.WHIRLIGIG.get());
                        output.accept(WHIRLICAP.get());
                        output.accept(TomeBlocks.WHIRLIBOX.get());
                        output.accept(LOLLIPOP.get());
                        output.accept(SQUILL_BUCKET.get());

                    }).build());
}