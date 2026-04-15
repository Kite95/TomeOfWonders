package com.platypushasnohat.tome_of_wonders.datagen;

import com.platypushasnohat.tome_of_wonders.registry.TomeBlocks;
import com.platypushasnohat.tome_of_wonders.registry.TomeItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.function.Consumer;

import static net.minecraft.data.recipes.RecipeCategory.COMBAT;
import static net.minecraft.data.recipes.RecipeCategory.REDSTONE;
import static net.minecraft.data.recipes.ShapedRecipeBuilder.shaped;

public class TomeRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public TomeRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        shaped(COMBAT, TomeItems.WHIRLICAP.get()).define('#', Items.LEATHER_HELMET).define('X', TomeBlocks.WHIRLIGIG.get()).pattern(" X ").pattern(" # ").unlockedBy("has_whirligig", has(TomeBlocks.WHIRLIGIG.get())).save(consumer);
        shaped(COMBAT, TomeItems.TOOTHED_SNOWBALL.get(), 4).define('#', Items.SNOWBALL).define('X', TomeItems.SQUILL_TOOTH.get()).pattern(" # ").pattern("#X#").pattern(" # ").unlockedBy("has_squill_tooth", has(TomeItems.SQUILL_TOOTH.get())).save(consumer);
        shaped(REDSTONE, TomeBlocks.WHIRLIBOX.get()).define('#', ItemTags.STONE_TOOL_MATERIALS).define('X', TomeBlocks.WHIRLIGIG.get()).define('Y', Tags.Items.DUSTS_REDSTONE).pattern("###").pattern("#X#").pattern("#Y#").unlockedBy("has_whirligig", has(TomeBlocks.WHIRLIGIG.get())).save(consumer);
    }
}
