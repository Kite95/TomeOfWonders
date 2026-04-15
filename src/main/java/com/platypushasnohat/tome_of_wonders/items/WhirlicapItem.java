package com.platypushasnohat.tome_of_wonders.items;

import com.platypushasnohat.tome_of_wonders.TomeOfWonders;
import com.platypushasnohat.tome_of_wonders.registry.TomeItems;
import com.platypushasnohat.tome_of_wonders.utils.TomeArmorMaterial;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class WhirlicapItem extends ArmorItem {

    private final TomeArmorMaterial armorMaterial;
    private int flightTime = 0;

    public WhirlicapItem(TomeArmorMaterial armorMaterial, Properties properties) {
        super(armorMaterial.getHolder(), Type.HELMET, properties);
        this.armorMaterial = armorMaterial;
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, @NotNull Level level, @NotNull Entity entity, int i, boolean held) {
        Vec3 motion = entity.getDeltaMovement();
        entity.resetFallDistance();

        if (stack.is(TomeItems.WHIRLICAP.get()) && entity instanceof Player player) {
            if (!onGround(player) && motion.y < 0.08 + 0.2 && !player.getCooldowns().isOnCooldown(stack.getItem())) {
                if (flightTime >= 60) {
                    player.getCooldowns().addCooldown(stack.getItem(), 180);
                } else if (player.jumping && !player.isCrouching()) {
                    this.flightTime++;
                    if (flightTime > 2) {
                        player.setDeltaMovement(motion.x, motion.y + 0.085F, motion.z);
                    }
                }
            }
            if (onGround(player) && flightTime > 0) flightTime--;
        }
    }

    private static boolean onGround(LivingEntity entity) {
        return entity.onGround() || entity.isInFluidType();
    }

    @SuppressWarnings("removal")
    @Override
    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
        consumer.accept((IClientItemExtensions) TomeOfWonders.PROXY.getArmorRenderProperties());
    }

    @Override
    @Nullable
    public ResourceLocation getArmorTexture(@NotNull ItemStack stack, @NotNull Entity entity, @NotNull EquipmentSlot slot, ArmorMaterial.@NotNull Layer layer, boolean innerModel) {
        return TomeOfWonders.modPrefix("textures/models/armor/whirlicap_layer_1.png");
    }
}
