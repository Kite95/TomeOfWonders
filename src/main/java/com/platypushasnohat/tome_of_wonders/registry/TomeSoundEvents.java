package com.platypushasnohat.tome_of_wonders.registry;

import com.platypushasnohat.tome_of_wonders.TomeOfWonders;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.platypushasnohat.tome_of_wonders.TomeOfWonders.modPrefix;

public class TomeSoundEvents {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Registries.SOUND_EVENT, TomeOfWonders.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> SQUILL_HURT = registerSoundEvent("squill_hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> SQUILL_DEATH = registerSoundEvent("squill_death");
    public static final DeferredHolder<SoundEvent, SoundEvent> SQUILL_SQUIRT = registerSoundEvent("squill_squirt");
    public static final DeferredHolder<SoundEvent, SoundEvent> SQUILL_CHATTER = registerSoundEvent("squill_chatter");

    private static DeferredHolder<SoundEvent, SoundEvent> registerSoundEvent(final String soundName) {
        return SOUND_EVENTS.register(soundName, () -> SoundEvent.createVariableRangeEvent(modPrefix(soundName)));
    }
}
