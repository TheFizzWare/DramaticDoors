package com.fizzware.dramaticdoors.crafting.conditions;

import com.fizzware.dramaticdoors.DramaticDoors;
import com.google.gson.JsonObject;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class HabitatModInstalledCondition implements ICondition
{
	private final ResourceLocation location;

	public HabitatModInstalledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return ModList.get().isLoaded("habitat");
	}

	public static class Serializer implements IConditionSerializer<HabitatModInstalledCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(DramaticDoors.MOD_ID, "habitat_mod_installed");
		}

		@Override
		public void write(JsonObject json, HabitatModInstalledCondition value) {
			// Nothing to write here...
		}

		@Override
		public HabitatModInstalledCondition read(JsonObject json) {
			return new HabitatModInstalledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}