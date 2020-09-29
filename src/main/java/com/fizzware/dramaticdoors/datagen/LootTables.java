package com.fizzware.dramaticdoors.datagen;

import com.fizzware.dramaticdoors.compat.ModCompatModule;
import com.fizzware.dramaticdoors.init.DoorMaterial;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootParameterSet;
import net.minecraft.world.storage.loot.LootParameterSets;
import net.minecraft.world.storage.loot.LootTable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LootTables extends BaseLootTableProvider {

    List<Block> blockList = new ArrayList<>();

    public LootTables(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
        for (ModCompatModule mod : ModCompatModule.values()) {
            if (!mod.isDisabled()) {
                DoorMaterial[] materials = DoorMaterial.DoorGroup.getByModId(mod.getName()).getGroupMaterials();
                for (DoorMaterial material : materials) {
                    blockList.add(material.getBlock());
                }
            }
        }
    }

    @Override
    protected void addTables() {
        for (Block block : blockList) {
            lootTables.put(block, createStandardDoorTable(block.getRegistryName().getPath(), block));
        }
    }
}
