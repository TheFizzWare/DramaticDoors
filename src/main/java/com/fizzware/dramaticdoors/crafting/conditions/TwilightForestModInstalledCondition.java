package com.fizzware.dramaticdoors.crafting.conditions;

import com.fizzware.dramaticdoors.DramaticDoors;
import com.google.gson.JsonObject;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class TwilightForestModInstalledCondition implements ICondition
{
	private final ResourceLocation location;

	public TwilightForestModInstalledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return ModList.get().isLoaded("twilightforest");
	}

	public static class Serializer implements IConditionSerializer<TwilightForestModInstalledCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(DramaticDoors.MOD_ID, "twilightforest_mod_installed");
		}

		@Override
		public void write(JsonObject json, TwilightForestModInstalledCondition value) {
			// Nothing to write here...
		}

		@Override
		public TwilightForestModInstalledCondition read(JsonObject json) {
			return new TwilightForestModInstalledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}