package net.johntdex.slimejuice.item.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class DrinkableItem extends Item {

    public DrinkableItem(Properties properties) {
        super(properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_DRINK; // or GENERIC_DRINK
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        ItemStack result = super.finishUsingItem(stack, level, entity);

        if (entity instanceof Player player && !player.getAbilities().instabuild) {
            ItemStack bottle = new ItemStack(Items.GLASS_BOTTLE);

            if (!player.getInventory().add(bottle)) {
                player.drop(bottle, false);
            }
        }

        return result;
    }
}
