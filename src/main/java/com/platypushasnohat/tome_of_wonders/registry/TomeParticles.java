package com.platypushasnohat.tome_of_wonders.registry;

import com.platypushasnohat.tome_of_wonders.TomeOfWonders;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TomeParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(Registries.PARTICLE_TYPE, TomeOfWonders.MOD_ID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> WHIRLIWIND = registerParticle("whirliwind", ()-> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> WHIRLIBUBBLE = registerParticle("whirlibubble", () -> new SimpleParticleType(false));

    private static <P extends ParticleType<?>> DeferredHolder<ParticleType<?>, P> registerParticle(String name, Supplier<P> particle ) {
        return PARTICLE_TYPES.register(name, particle);
    }
}
