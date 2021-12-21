package com.fizzware.dramaticdoors.client;

import com.fizzware.dramaticdoors.blocks.DramaticDoorsBlocks;
import com.fizzware.dramaticdoors.blocks.TallDoorBlock;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ClientRenderer
{
	public static void setRenderers() {
	    // Setup Render Types (mainly for transparent doors like Acacia and Jungle)
	    for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.VANILLA_TALL)) {
	        RenderTypeLookup.setRenderLayer(doorBlock, RenderType.cutout());
	    }
	    // Add rendering for addon doors.
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.BOP_TALL)) {
            RenderTypeLookup.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.TWILIGHT_FOREST_TALL)) {
            RenderTypeLookup.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.ATMOSPHERIC_TALL)) {
            RenderTypeLookup.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.AUTUMNITY_TALL)) {
            RenderTypeLookup.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.BAMBOO_TALL)) {
            RenderTypeLookup.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.BUZZIER_TALL)) {
            RenderTypeLookup.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.ENDERGETIC_TALL)) {
            RenderTypeLookup.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.ENVIRONMENTAL_TALL)) {
            RenderTypeLookup.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.UPGRADE_AQUATIC_TALL)) {
            RenderTypeLookup.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.ABUNDANCE_TALL)) {
            RenderTypeLookup.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.BAYOU_BLUES_TALL)) {
            RenderTypeLookup.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.ENH_MUSHROOMS_TALL)) {
        	if (doorBlock.getRegistryName().getPath() == TallDoorBlock.NAME_GLOWSHROOM) {
        		RenderTypeLookup.setRenderLayer(doorBlock, RenderType.translucent());
        	}
        	else {
        		RenderTypeLookup.setRenderLayer(doorBlock, RenderType.cutout());
        	}
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.DARKER_DEPTHS_TALL)) {
            RenderTypeLookup.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.DUSTRIAL_DECOR_TALL)) {
            RenderTypeLookup.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.HABITAT_TALL)) {
            RenderTypeLookup.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.OUTER_END_TALL)) {
            RenderTypeLookup.setRenderLayer(doorBlock, RenderType.cutout());
        }
        for (Block doorBlock : DramaticDoorsBlocks.getBlockList(DramaticDoorsBlocks.DoorSeries.SUPPLEMENTARIES_TALL)) {
            RenderTypeLookup.setRenderLayer(doorBlock, RenderType.cutout());
        }
	}
}
