package com.platypushasnohat.tome_of_wonders.datagen;

import com.platypushasnohat.tome_of_wonders.TomeOfWonders;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

import static com.platypushasnohat.tome_of_wonders.registry.TomeItems.*;

public class TomeItemModelProvider extends ItemModelProvider {

    public TomeItemModelProvider(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(), TomeOfWonders.MOD_ID, event.getExistingFileHelper());
    }

    @Override
    protected void registerModels() {
        this.generatedItem(SQUILL_TOOTH);
        this.generatedItem(TOOTHED_SNOWBALL);
        this.generatedItem(SQUILL_BUCKET);
        this.generatedItem(WHIRLICAP);

        for (Item item : BuiltInRegistries.ITEM) {
            if (item instanceof DeferredSpawnEggItem && BuiltInRegistries.ITEM.getKey(item).getNamespace().equals(TomeOfWonders.MOD_ID)) {
                this.withExistingParent(name(item), "item/template_spawn_egg");
            }
        }
    }

    public static ResourceLocation key(ItemLike item) {
        return BuiltInRegistries.ITEM.getKey(item.asItem());
    }

    public static String name(ItemLike item) {
        return key(item).getPath();
    }

    public static ResourceLocation itemTexture(ItemLike item) {
        ResourceLocation name = key(item);
        return ResourceLocation.fromNamespaceAndPath(name.getNamespace(), ModelProvider.ITEM_FOLDER + "/" + name.getPath());
    }

    public ItemModelBuilder item(DeferredHolder<? extends ItemLike, ?> item, String type) {
        return this.withExistingParent(name(item.get()), "item/" + type).texture("layer0", itemTexture(item.get()));
    }

    public ItemModelBuilder item(DeferredHolder<? extends ItemLike, ?> item, String path, String type) {
        return this.withExistingParent(name(item.get()), "item/" + type).texture("layer0", ResourceLocation.fromNamespaceAndPath(this.modid, "item/" + path));
    }

    public ItemModelBuilder item(ResourceLocation location, String type) {
        return this.withExistingParent(location.getPath(), "item/" + type).texture("layer0", ResourceLocation.fromNamespaceAndPath(this.modid, "item/" + location.getPath()));
    }

//    public ItemModelBuilder blockItem(DeferredHolder<Block, ?> block) {
//        return this.getBuilder(TomeBlockstateProvider.name(block.get())).parent(new ModelFile.UncheckedModelFile(ResourceLocation.fromNamespaceAndPath(this.modid, "block/" + TomeBlockstateProvider.name(block.get()))));
//    }

    @SafeVarargs
    public final void generatedItem(DeferredHolder<? extends ItemLike, ?>... items) {
        for (DeferredHolder<? extends ItemLike, ?> item : items) {
            this.item(item, "generated");
        }
    }

    @SafeVarargs
    public final void handheldItem(DeferredHolder<? extends ItemLike, ?>... items) {
        for (DeferredHolder<? extends ItemLike, ?> item : items) {
            this.item(item, "handheld");
        }
    }

    @SafeVarargs
    public final void handheldRodItem(DeferredHolder<? extends ItemLike, ?>... items) {
        for (DeferredHolder<? extends ItemLike, ?> item : items) {
            this.item(item, "handheld_rod");
        }
    }

    @SafeVarargs
    public final void spawnEggItem(DeferredHolder<? extends ItemLike, ?>... items) {
        for (DeferredHolder<? extends ItemLike, ?> item : items) {
            this.withExistingParent(name(item.get()), "item/template_spawn_egg");
        }
    }
}
