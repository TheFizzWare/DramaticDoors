package com.fizzware.dramaticdoors.datagen;

import com.fizzware.dramaticdoors.content.Items;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ForgeRecipeProvider;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {

    public Recipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.shapedRecipe(Items.TALL_DRIFTWOOD_DOOR, 2)
                .patternLine("D")
                .patternLine("D")
                .patternLine("D")
                .setGroup("tall_door")
                .key('D', ForgeRegistries.ITEMS.getValue(new ResourceLocation("upgrade_aquatic:driftwood_door")))
                .build(consumer);
    }
}
