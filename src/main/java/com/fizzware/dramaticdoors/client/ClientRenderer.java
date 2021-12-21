package com.fizzware.dramaticdoors.client;

import com.fizzware.dramaticdoors.blocks.DramaticDoorsBlocks;
import com.fizzware.dramaticdoors.blocks.TallDoorBlock;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ClientRenderer
{
	public static void setRenderers() {
        // Setup Render Types (mainly for transparent doors like Acacia and Jungle)
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.VANILLA_TALL)) {
            ItemBlockRenderTypes.setRenderLayer(doorBlock, RenderType.cutout());
        }
        //Conditionally add rendering on where mods are loaded.
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.BOP_TALL)) {
            ItemBlockRenderTypes.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.TWILIGHT_FOREST_TALL)) {
            ItemBlockRenderTypes.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.ATMOSPHERIC_TALL)) {
            ItemBlockRenderTypes.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.AUTUMNITY_TALL)) {
            ItemBlockRenderTypes.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.BAMBOO_TALL)) {
            ItemBlockRenderTypes.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.BUZZIER_TALL)) {
            ItemBlockRenderTypes.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.ENDERGETIC_TALL)) {
            ItemBlockRenderTypes.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.ENVIRONMENTAL_TALL)) {
            ItemBlockRenderTypes.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.UPGRADE_AQUATIC_TALL)) {
            ItemBlockRenderTypes.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.ABUNDANCE_TALL)) {
            ItemBlockRenderTypes.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.BAYOU_BLUES_TALL)) {
            ItemBlockRenderTypes.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.ENH_MUSHROOMS_TALL)) {
        	if (doorBlock.getRegistryName().getPath() == TallDoorBlock.NAME_GLOWSHROOM) {
        		ItemBlockRenderTypes.setRenderLayer(doorBlock, RenderType.translucent());
        	}
        	else {
        		ItemBlockRenderTypes.setRenderLayer(doorBlock, RenderType.cutout());
        	}
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.DARKER_DEPTHS_TALL)) {
            ItemBlockRenderTypes.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.DUSTRIAL_DECOR_TALL)) {
            ItemBlockRenderTypes.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.HABITAT_TALL)) {
            ItemBlockRenderTypes.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.OUTER_END_TALL)) {
            ItemBlockRenderTypes.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.SUPPLEMENTARIES_TALL)) {
            ItemBlockRenderTypes.setRenderLayer(doorBlock, RenderType.cutout());
        }
	}

}
