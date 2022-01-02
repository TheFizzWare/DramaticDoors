package com.fizzware.dramaticdoors.crafting.conditions;

import com.fizzware.dramaticdoors.DramaticDoors;
import com.google.gson.JsonObject;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class DarkerDepthsModInstalledCondition implements ICondition
{
	private final ResourceLocation location;

	public DarkerDepthsModInstalledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return ModList.get().isLoaded("darkerdepths");
	}

	public static class Serializer implements IConditionSerializer<DarkerDepthsModInstalledCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(DramaticDoors.MOD_ID, "darker_depths_mod_installed");
		}

		@Override
		public void write(JsonObject json, DarkerDepthsModInstalledCondition value) {
			// Nothing to write here...
		}

		@Override
		public DarkerDepthsModInstalledCondition read(JsonObject json) {
			return new DarkerDepthsModInstalledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}