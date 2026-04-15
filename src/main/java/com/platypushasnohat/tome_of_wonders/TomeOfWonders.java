package com.platypushasnohat.tome_of_wonders;

import com.platypushasnohat.tome_of_wonders.datagen.*;
import com.platypushasnohat.tome_of_wonders.registry.*;
import com.platypushasnohat.tome_of_wonders.utils.ClientProxy;
import com.platypushasnohat.tome_of_wonders.utils.CommonProxy;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Locale;
import java.util.concurrent.CompletableFuture;

@Mod(TomeOfWonders.MOD_ID)
public class TomeOfWonders {

    public static final String MOD_ID = "tome_of_wonders";
    public static CommonProxy PROXY = FMLEnvironment.dist.isClient() ? new ClientProxy() : new CommonProxy();

    public TomeOfWonders(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, TomeOfWondersConfig.COMMON_CONFIG, "tome-of-wonders-general.toml");
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::dataSetup);
        NeoForge.EVENT_BUS.addListener(TomeEffects::registerBrewingRecipes);

        TomeItems.ITEMS.register(modEventBus);
        TomeBlocks.BLOCKS.register(modEventBus);
        TomeBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        TomeEntities.ENTITY_TYPES.register(modEventBus);
        TomeEffects.POTIONS.register(modEventBus);
        TomeSoundEvents.SOUND_EVENTS.register(modEventBus);
        TomeParticles.PARTICLE_TYPES.register(modEventBus);
        TomePaintings.PAINTING_VARIANTS.register(modEventBus);
        TomeOfWondersTab.CREATIVE_TABS.register(modEventBus);
    }

    public void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> PROXY.clientInit());
    }

    private void dataSetup(GatherDataEvent data) {
        DataGenerator generator = data.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = data.getLookupProvider();
        ExistingFileHelper helper = data.getExistingFileHelper();

        boolean server = data.includeServer();

        TomeDatapackProvider datapackEntries = new TomeDatapackProvider(output, provider);
        generator.addProvider(server, datapackEntries);
        provider = datapackEntries.getRegistryProvider();

        TomeBlockTagProvider blockTags = new TomeBlockTagProvider(output, provider, helper);
        generator.addProvider(server, blockTags);
        generator.addProvider(server, new TomeEntityTagProvider(output, provider, helper));
        generator.addProvider(server, new TomeBiomeTagProvider(output, provider, helper));
        generator.addProvider(server, new TomeRecipeProvider(output));
        generator.addProvider(server, new TomePaintingTagProvider(output, provider, helper));
        generator.addProvider(server, new TomeLootProvider(output, provider));

        boolean client = data.includeClient();
        generator.addProvider(client, new TomeItemModelProvider(data));
        generator.addProvider(client, new TomeSoundDefinitionProvider(output, helper));
        generator.addProvider(client, new TomeLanguageProvider(data));
    }

    public static ResourceLocation modPrefix(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name.toLowerCase(Locale.ROOT));
    }
}

