package net.johntdex.slimejuice.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties SLIMEJUICE = new FoodProperties.Builder().nutrition(3).saturationModifier(0.5f)
            .alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400), 0.5f )
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 400), 0.5f)
            .build();
    public static final FoodProperties SLIMECUBE = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f)
            .build();
}
