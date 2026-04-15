package com.platypushasnohat.tome_of_wonders.events;

import com.platypushasnohat.tome_of_wonders.TomeOfWonders;
import com.platypushasnohat.tome_of_wonders.client.models.SquillModel;
import com.platypushasnohat.tome_of_wonders.client.models.armor.WhirlicapModel;
import com.platypushasnohat.tome_of_wonders.client.particles.WhirlibubbleParticle;
import com.platypushasnohat.tome_of_wonders.client.particles.WhirliwindParticle;
import com.platypushasnohat.tome_of_wonders.client.renderer.SquillRenderer;
import com.platypushasnohat.tome_of_wonders.client.renderer.blockentity.WhirligigRenderer;
import com.platypushasnohat.tome_of_wonders.registry.TomeBlockEntities;
import com.platypushasnohat.tome_of_wonders.registry.TomeEntities;
import com.platypushasnohat.tome_of_wonders.registry.TomeModelLayers;
import com.platypushasnohat.tome_of_wonders.registry.TomeParticles;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = TomeOfWonders.MOD_ID, value = Dist.CLIENT)
public final class ClientModEvents {

    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(TomeParticles.WHIRLIWIND.get(), WhirliwindParticle.Factory::new);
        event.registerSpriteSet(TomeParticles.WHIRLIBUBBLE.get(), WhirlibubbleParticle.Factory::new);
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(TomeEntities.SQUILL.get(), SquillRenderer::new);
        event.registerEntityRenderer(TomeEntities.TOOTHED_SNOWBALL.get(), ThrownItemRenderer::new);
    }

    @SubscribeEvent
    public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(TomeBlockEntities.WHIRLIGIG_BLOCK_ENTITY.get(), WhirligigRenderer::new);
    }

    @SubscribeEvent
    public static void registerEntityLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(TomeModelLayers.SQUILL, SquillModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerArmorLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(TomeModelLayers.WHIRLICAP, WhirlicapModel::createArmorLayer);
    }

    @SubscribeEvent
    public static void registerBlockEntityLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(TomeModelLayers.WHIRLIGIG, WhirligigRenderer::createMesh);
    }
}
