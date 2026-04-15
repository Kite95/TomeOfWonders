package com.platypushasnohat.tome_of_wonders.registry;

import com.platypushasnohat.tome_of_wonders.TomeOfWonders;
import com.platypushasnohat.tome_of_wonders.items.*;
import com.platypushasnohat.tome_of_wonders.utils.TomeArmorMaterial;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class TomeItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TomeOfWonders.MOD_ID);
    public static List<DeferredItem<? extends Item>> ITEM_TRANSLATIONS = new ArrayList<>();

    public static final TomeArmorMaterial WHIRLICAP_ARMOR_MATERIAL = new TomeArmorMaterial("whirlicap", 12, new int[]{1, 1, 1, 1}, 10, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F);

    public static final DeferredItem<Item> SQUILL_SPAWN_EGG = registerSpawnEggItem("squill", TomeEntities.SQUILL, 0xe1f7fe, 0x95c0d7);
    public static final DeferredItem<Item> SQUILL_TOOTH = registerItem("squill_tooth", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TOOTHED_SNOWBALL = registerItem("toothed_snowball", () -> new ToothedSnowballItem(new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> WHIRLICAP = registerItem("whirlicap", () -> new WhirlicapItem(WHIRLICAP_ARMOR_MATERIAL, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> LOLLIPOP = registerItem("lollipop", () -> new LollipopItem(registerFoodValue(TomeFoodValues.LOLLIPOP).stacksTo(1)));
    public static final DeferredItem<Item> SQUILL_BUCKET = registerItemNoLang("squill_bucket", () -> new SquillBucketItem(new Item.Properties().stacksTo(1)));

    private static <I extends Item> DeferredItem<I> registerItem(String name, Supplier<? extends I> supplier) {
        DeferredItem<I> item = ITEMS.register(name, supplier);
        ITEM_TRANSLATIONS.add(item);
        return item;
    }

    private static <I extends Item> DeferredItem<I> registerItemNoLang(String name, Supplier<? extends I> supplier) {
        return ITEMS.register(name, supplier);
    }

    private static DeferredItem<Item> registerSpawnEggItem(String name, Supplier<? extends EntityType<? extends Mob>> type, int baseColor, int spotColor) {
        return registerItem(name + "_spawn_egg", () -> new DeferredSpawnEggItem(type, baseColor, spotColor, new Item.Properties()));
    }

    public static Item.Properties registerFoodValue(FoodProperties food) {
        return new Item.Properties().food(food);
    }
}
