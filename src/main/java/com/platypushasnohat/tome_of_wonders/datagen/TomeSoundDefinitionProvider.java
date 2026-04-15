package com.platypushasnohat.tome_of_wonders.datagen;

import com.platypushasnohat.tome_of_wonders.TomeOfWonders;
import com.platypushasnohat.tome_of_wonders.registry.TomeSoundEvents;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

import java.util.function.Supplier;

import static com.platypushasnohat.tome_of_wonders.TomeOfWonders.modPrefix;

@SuppressWarnings("SameParameterValue")
public class TomeSoundDefinitionProvider extends SoundDefinitionsProvider {

    public TomeSoundDefinitionProvider(PackOutput packOutput, ExistingFileHelper helper) {
        super(packOutput, TomeOfWonders.MOD_ID, helper);
    }

    @Override
    public void registerSounds() {
        this.sound(TomeSoundEvents.SQUILL_HURT,
                sound("entity/squid/hurt1").pitch(1.5F),
                sound("entity/squid/hurt2").pitch(1.5F),
                sound("entity/squid/hurt3").pitch(1.5F),
                sound("entity/squid/hurt4").pitch(1.5F)
        );
        this.sound(TomeSoundEvents.SQUILL_DEATH,
                sound("entity/squid/death1").pitch(1.5F),
                sound("entity/squid/death2").pitch(1.5F),
                sound("entity/squid/death3").pitch(1.5F)
        );
        this.sound(TomeSoundEvents.SQUILL_SQUIRT,
                sound("entity/squid/squirt1").pitch(1.5F),
                sound("entity/squid/squirt2").pitch(1.5F),
                sound("entity/squid/squirt3").pitch(1.5F)
        );
        this.sound(TomeSoundEvents.SQUILL_CHATTER,
                sound(modPrefix("entity/squill/chatter1")).volume(0.9F)
        );
    }

    private void soundDefinition(Supplier<SoundEvent> soundEvent, String subtitle, SoundDefinition.Sound... sounds) {
        this.add(soundEvent.get(), SoundDefinition.definition().subtitle("subtitles.tome_of_wonders." + subtitle).with(sounds));
    }

    private void sound(Supplier<SoundEvent> soundEvent, SoundDefinition.Sound... sounds){
        this.soundDefinition(soundEvent, soundEvent.get().getLocation().getPath(), sounds);
    }
}
