package com.platypushasnohat.tome_of_wonders.events;

import com.platypushasnohat.tome_of_wonders.TomeOfWonders;
import com.platypushasnohat.tome_of_wonders.entities.Squill;
import com.platypushasnohat.tome_of_wonders.registry.TomeEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

@EventBusSubscriber(modid = TomeOfWonders.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent event) {
        event.register(TomeEntities.SQUILL.get(), SpawnPlacementTypes.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING, Squill::canSpawn, RegisterSpawnPlacementsEvent.Operation.OR);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(TomeEntities.SQUILL.get(), Squill.createAttributes().build());
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onEntityJoinWorld(EntityJoinLevelEvent event) {
        Entity entity = event.getEntity();
        if (entity.level().isClientSide && entity instanceof Squill squill) {
            squill.updatePull(entity.position());
        }
    }
}
