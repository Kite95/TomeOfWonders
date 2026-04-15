package com.platypushasnohat.tome_of_wonders.registry;

import com.platypushasnohat.tome_of_wonders.TomeOfWonders;
import com.platypushasnohat.tome_of_wonders.effects.TOWBrewingRecipe;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TomeEffects {

    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(Registries.POTION, TomeOfWonders.MOD_ID);

    public static final DeferredHolder<Potion, Potion> LEVITATION_POTION = POTIONS.register("levitation", () -> new Potion(new MobEffectInstance(MobEffects.LEVITATION, 400)));

    public static void registerBrewingRecipes(net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent event) {
        var builder = event.getBuilder();
        builder.addRecipe(new TOWBrewingRecipe(Ingredient.of(createPotion(Potions.SLOW_FALLING)), Ingredient.of(TomeItems.SQUILL_TOOTH.get()), createPotion(LEVITATION_POTION)));

    }

    public static ItemStack createPotion(Holder<Potion> potion) {
        ItemStack stack = new ItemStack(Items.POTION);
        stack.set(DataComponents.POTION_CONTENTS, new PotionContents(potion));
        return stack;
    }

    public static ItemStack createPotion(DeferredHolder<Potion, Potion> potion) {
        return createPotion((Holder<Potion>) potion);
    }

    public static ItemStack createPotion(Potion potion) {
        ItemStack stack = new ItemStack(Items.POTION);
        stack.set(DataComponents.POTION_CONTENTS, new PotionContents(Holder.direct(potion)));
        return stack;
    }

    public static ItemStack createSplashPotion(Potion potion) {
        ItemStack stack = new ItemStack(Items.SPLASH_POTION);
        stack.set(DataComponents.POTION_CONTENTS, new PotionContents(Holder.direct(potion)));
        return stack;
    }

    public static ItemStack createLingeringPotion(Potion potion) {
        ItemStack stack = new ItemStack(Items.LINGERING_POTION);
        stack.set(DataComponents.POTION_CONTENTS, new PotionContents(Holder.direct(potion)));
        return stack;
    }

    public static ItemStack createTippedArrow(Potion potion) {
        ItemStack stack = new ItemStack(Items.TIPPED_ARROW);
        stack.set(DataComponents.POTION_CONTENTS, new PotionContents(Holder.direct(potion)));
        return stack;
    }
}
