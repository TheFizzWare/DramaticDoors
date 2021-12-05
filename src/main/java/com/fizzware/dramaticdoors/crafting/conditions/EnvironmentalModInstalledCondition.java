package com.fizzware.dramaticdoors.crafting.conditions;

import com.fizzware.dramaticdoors.DramaticDoors;
import com.google.gson.JsonObject;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class EnvironmentalModInstalledCondition implements ICondition
{
	private final ResourceLocation location;

	public EnvironmentalModInstalledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return ModList.get().isLoaded("environmental");
	}

	public static class Serializer implements IConditionSerializer<EnvironmentalModInstalledCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(DramaticDoors.MOD_ID, "environmental_mod_installed");
		}

		@Override
		public void write(JsonObject json, EnvironmentalModInstalledCondition value) {
			// Nothing to write here...
		}

		@Override
		public EnvironmentalModInstalledCondition read(JsonObject json) {
			return new EnvironmentalModInstalledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}