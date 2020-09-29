package com.fizzware.dramaticdoors.datagen;

import com.fizzware.dramaticdoors.compat.ModCompatModule;
import com.fizzware.dramaticdoors.init.DoorMaterial;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.advancements.criterion.PlacedBlockTrigger;
import net.minecraft.block.Block;
import net.minecraft.data.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Recipes extends RecipeProvider {

    HashMap<ResourceLocation, Block> recipeList = new HashMap<>();

    public Recipes(DataGenerator generatorIn) {
        super(generatorIn);
        for (ModCompatModule mod : ModCompatModule.values()) {
            if (!mod.isDisabled()) {
                DoorMaterial[] materials = DoorMaterial.DoorGroup.getByModId(mod.getName()).getGroupMaterials();
                for (DoorMaterial material : materials) {
                    recipeList.put(material.getIngredient(), material.getBlock());
                }
            }
        }
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        for (ResourceLocation ingredient_resource_location : recipeList.keySet()) {
            Ingredient ingredient = new Ingredient(Stream.empty()) {

                @Override
                public JsonElement serialize() {
                    JsonObject jsonobject = new JsonObject();
                    jsonobject.addProperty("item", ingredient_resource_location.toString());
                    return jsonobject;
                }
            };
            Block result = recipeList.get(ingredient_resource_location);
            ShapedRecipeBuilder recipeBuilder = ShapedRecipeBuilder.shapedRecipe(result, 2);
            recipeBuilder.patternLine("D")
                    .patternLine("D")
                    .patternLine("D")
                    .setGroup("tall_door")
                    .key('D', ingredient);
            for (Block criterionBlock : DoorMaterial.DoorGroup.VANILLA.getGroupBlocks()) {
                recipeBuilder.addCriterion("placed_block_" + criterionBlock.getRegistryName().getPath(), PlacedBlockTrigger.Instance.placedBlock(criterionBlock));
            }
            recipeBuilder.build(consumer);
        }
    }
}
