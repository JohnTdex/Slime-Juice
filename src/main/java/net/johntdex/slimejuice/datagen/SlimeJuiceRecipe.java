package net.johntdex.slimejuice.datagen;

import net.johntdex.slimejuice.SlimeJuice;
import net.johntdex.slimejuice.item.SlimeJuiceItems;
import net.johntdex.slimejuice.util.SlimeJuiceTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class SlimeJuiceRecipe extends RecipeProvider implements IConditionBuilder {
    public SlimeJuiceRecipe(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries);
    }

    private static final TagKey<Item> MILK_BOTTLES = ItemTags.create(
            ResourceLocation.fromNamespaceAndPath("c", "drinks/milk"));

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        //Shaped Recipe

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, SlimeJuiceItems.SLIMEJUICE.get(), 1)
                .pattern("CCM")
                .pattern("CCG")
                .pattern("SSS")
                .define('S', Ingredient.of(Items.SUGAR))
                .define('C', SlimeJuiceItems.SLIMECUBE.get())
                .define('M', SlimeJuiceTags.Items.MILK_BOTTLE)
                .define('G', SlimeJuiceItems.GLASS_CUP.get())
                .unlockedBy("has_slime_cube", has(SlimeJuiceItems.SLIMECUBE.get()))
                .save(recipeOutput, prefix("slime_juice"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, SlimeJuiceItems.SLIMECUBE.get(), 2)
                .pattern("CCS")
                .pattern("CCS")
                .pattern("SSS")
                .define('S', Ingredient.of(Items.SUGAR))
                .define('C', Ingredient.of(Items.SLIME_BALL))
                .unlockedBy("has_sugar", has(Items.SUGAR))
                .unlockedBy("has_slimeball", has(Items.SLIME_BALL))
                .save(recipeOutput, prefix("slime_cube"));


        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, SlimeJuiceItems.MILK_BOTTLE.get(), 3)
                .pattern("MB")
                .pattern("BB")
                .define('M', Ingredient.of(Items.MILK_BUCKET))
                .define('B', Ingredient.of(Items.GLASS_BOTTLE))
                .unlockedBy("has_milk_bucket", has(Items.MILK_BUCKET))
                .save(recipeOutput, prefix("milk_bottle"));

        //Shapeless Recipe

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SlimeJuiceItems.GLASS_CUP.get(), 1)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_glass_bottle", has(Items.GLASS_BOTTLE))
                .save(recipeOutput, prefix("glass_cup"));

    }

    private static ResourceLocation prefix(String path) {
        return ResourceLocation.fromNamespaceAndPath(SlimeJuice.MODID, path);
    }
}
