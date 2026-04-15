package com.platypushasnohat.tome_of_wonders.datagen;

import com.platypushasnohat.tome_of_wonders.TomeOfWonders;
import com.platypushasnohat.tome_of_wonders.TomeOfWondersTab;
import com.platypushasnohat.tome_of_wonders.registry.*;
import com.platypushasnohat.tome_of_wonders.utils.TomeTextUtils;
import net.minecraft.Util;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Objects;
import java.util.function.Supplier;

public class TomeLanguageProvider extends LanguageProvider {

    public TomeLanguageProvider(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(), TomeOfWonders.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

        this.creativeTab(TomeOfWondersTab.TOME_OF_WONDERS_TAB.get(), "Tome of Wonders");

        TomeItems.ITEM_TRANSLATIONS.forEach(this::forItem);
        TomeBlocks.BLOCK_TRANSLATIONS.forEach(this::forBlock);
        TomePaintings.PAINTING_TRANSLATIONS.forEach(this::painting);

        this.addItem(TomeItems.SQUILL_BUCKET, "Bucket of Squill");

        this.forEntity(TomeEntities.SQUILL);

        this.sound(TomeSoundEvents.SQUILL_DEATH, "Squill dies");
        this.sound(TomeSoundEvents.SQUILL_HURT, "Squill hurts");
        this.sound(TomeSoundEvents.SQUILL_SQUIRT, "Squill squirts");
        this.sound(TomeSoundEvents.SQUILL_CHATTER, "Squill chatters");

        this.potion(TomeEffects.LEVITATION_POTION, "Levitation", "levitation");
    }

    private void forBlock(Supplier<? extends Block> block) {
        this.addBlock(block, TomeTextUtils.createTranslation(Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(block.get())).getPath()));
    }

    private void forItem(Supplier<? extends Item> item) {
        this.addItem(item, TomeTextUtils.createTranslation(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item.get())).getPath()));
    }

    private void forEntity(Supplier<? extends EntityType<?>> entity) {
        this.addEntityType(entity, TomeTextUtils.createTranslation(Objects.requireNonNull(BuiltInRegistries.ENTITY_TYPE.getKey(entity.get())).getPath()));
    }

    protected void painting(String name, String author) {
        this.add("painting." + TomeOfWonders.MOD_ID + "." + name + ".title", TomeTextUtils.createTranslation(name));
        this.add("painting." + TomeOfWonders.MOD_ID + "." + name + ".author", author);
    }

    protected void musicDisc(Supplier<? extends Item> item, ResourceKey<JukeboxSong> song, String name) {
        String disc = item.get().getDescriptionId();
        this.add(disc, "Music Disc");
        String key = Util.makeDescriptionId("jukebox_song", song.location());
        this.add(key, name);
    }

    public void translateAdvancement(String key, String name, String desc) {
        this.add("advancements." + TomeOfWonders.MOD_ID + "." + key + ".title", name);
        this.add("advancements." + TomeOfWonders.MOD_ID + "." + key + ".description", desc);
    }

    private void translateEffect(DeferredHolder<? extends MobEffect, ?> effect, String desc) {
        this.add(effect.get(), TomeTextUtils.createTranslation(effect.get().toString()));
        this.add(effect.get().getDescriptionId() + ".description", desc);
    }

    private void addDescription(DeferredHolder<? extends ItemLike, ?> item, String desc) {
        this.add(item.get().asItem().getDescriptionId() + ".desc", desc);
    }

    public void creativeTab(CreativeModeTab key, String name){
        add(key.getDisplayName().getString(), name);
    }

    public void sound(Supplier<? extends SoundEvent> key, String subtitle){
        this.add("subtitles." + key.get().getLocation().getPath(), subtitle);
    }
}
