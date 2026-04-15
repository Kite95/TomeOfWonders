package com.platypushasnohat.tome_of_wonders.registry;

import com.platypushasnohat.tome_of_wonders.TomeOfWonders;
import com.platypushasnohat.tome_of_wonders.entities.Squill;
import com.platypushasnohat.tome_of_wonders.entities.projectile.ToothedSnowball;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TomeEntities {

    public static List<DeferredHolder<EntityType<?>, ? extends EntityType<?>>> ENTITY_TRANSLATIONS = new ArrayList<>();

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, TomeOfWonders.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<Squill>> SQUILL = registerEntity("squill", Squill::new, MobCategory.CREATURE, builder -> builder.sized(0.8F, 0.8F).eyeHeight(4.7F).clientTrackingRange(10));
    public static final DeferredHolder<EntityType<?>, EntityType<ToothedSnowball>> TOOTHED_SNOWBALL = registerEntity("toothed_snowball", ToothedSnowball::new, MobCategory.MISC, builder -> builder.sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10));

//    public static final RegistryObject<EntityType<Squill>> SQUILL = ENTITY_TYPES.register(
//            "squill", () ->
//            EntityType.Builder.of(Squill::new, MobCategory.CREATURE)
//                    .sized(0.8F, 0.8F)
//                    .clientTrackingRange(10)
//                    .build(modPrefix("squill").toString())
//    );
//
//    public static final RegistryObject<EntityType<ToothedSnowball>> TOOTHED_SNOWBALL = ENTITY_TYPES.register(
//            "toothed_snowball", () ->
//            EntityType.Builder.<ToothedSnowball>of(ToothedSnowball::new, MobCategory.MISC)
//                    .sized(0.25F, 0.25F)
//                    .clientTrackingRange(4)
//                    .updateInterval(10)
//                    .build(modPrefix("toothed_snowball").toString())
//    );

    public static <E extends Entity> DeferredHolder<EntityType<?>, EntityType<E>> registerEntity(String name, EntityType.EntityFactory<E> factory, MobCategory entityClassification, Consumer<EntityType.Builder<E>> builderConsumer) {
        DeferredHolder<EntityType<?>, EntityType<E>> entity = registerEntityNoLang(name, factory, entityClassification, builderConsumer);
        ENTITY_TRANSLATIONS.add(entity);
        return entity;
    }

    public static <E extends Entity> DeferredHolder<EntityType<?>, EntityType<E>> registerEntityNoLang(String name, EntityType.EntityFactory<E> factory, MobCategory entityClassification, Consumer<EntityType.Builder<E>> builderConsumer) {
        return ENTITY_TYPES.register(name, () -> {
            var builder = EntityType.Builder.of(factory, entityClassification);
            builderConsumer.accept(builder);
            return builder.build(TomeOfWonders.MOD_ID + ":" + name);
        });
    }
}
