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
import net.minecraft.world.item.crafting.Recipe;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.awt.*;
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

        //Shaped Recipe for Food Coloring
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SlimeJuiceItems.WHITE_FOOD_COLORING.get(), 1)
                .pattern("DS")
                .pattern("SS")
                .define('S', Ingredient.of(Items.SUGAR))
                .define('D', Ingredient.of(Items.WHITE_DYE))
                .unlockedBy("has_white_dye", has(Items.WHITE_DYE))
                .save(recipeOutput, prefix("white_food_coloring"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SlimeJuiceItems.LIGHT_GREY_FOOD_COLORING.get(), 1)
                .pattern("DS")
                .pattern("SS")
                .define('S', Ingredient.of(Items.SUGAR))
                .define('D', Ingredient.of(Items.LIGHT_GRAY_DYE))
                .unlockedBy("has_light_gray_dye", has(Items.LIGHT_GRAY_DYE))
                .save(recipeOutput, prefix("light_grey_food_coloring"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SlimeJuiceItems.GREY_FOOD_COLORING.get(), 1)
                .pattern("DS")
                .pattern("SS")
                .define('S', Ingredient.of(Items.SUGAR))
                .define('D', Ingredient.of(Items.GRAY_DYE))
                .unlockedBy("has_gray_dye", has(Items.GRAY_DYE))
                .save(recipeOutput, prefix("grey_food_coloring"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SlimeJuiceItems.DARK_FOOD_COLORING.get(), 1)
                .pattern("DS")
                .pattern("SS")
                .define('S', Ingredient.of(Items.SUGAR))
                .define('D', Ingredient.of(Items.BLACK_DYE))
                .unlockedBy("has_black_dye", has(Items.BLACK_DYE))
                .save(recipeOutput, prefix("dark_food_coloring"));

        //Recipe for Colored Slime Cubes

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, SlimeJuiceItems.WHITE_SLIMECUBE.get(), 4)
                .pattern("F  ")
                .pattern("SS ")
                .pattern("SS ")
                .define('S', Ingredient.of(SlimeJuiceItems.SLIMECUBE.get()))
                .define('F', Ingredient.of(SlimeJuiceItems.WHITE_FOOD_COLORING.get()))
                .unlockedBy("has_slime_cube", has(SlimeJuiceItems.WHITE_FOOD_COLORING.get()))
                .save(recipeOutput, prefix("white_slime_cube"));

    }

    private static ResourceLocation prefix(String path) {
        return ResourceLocation.fromNamespaceAndPath(SlimeJuice.MODID, path);
    }
}
