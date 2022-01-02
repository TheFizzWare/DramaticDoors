package com.fizzware.dramaticdoors.crafting.conditions;

import com.fizzware.dramaticdoors.DramaticDoors;
import com.google.gson.JsonObject;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class SupplementariesModInstalledCondition implements ICondition
{
	private final ResourceLocation location;

	public SupplementariesModInstalledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return ModList.get().isLoaded("supplementaries");
	}

	public static class Serializer implements IConditionSerializer<SupplementariesModInstalledCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(DramaticDoors.MOD_ID, "supplementaries_mod_installed");
		}

		@Override
		public void write(JsonObject json, SupplementariesModInstalledCondition value) {
			// Nothing to write here...
		}

		@Override
		public SupplementariesModInstalledCondition read(JsonObject json) {
			return new SupplementariesModInstalledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}