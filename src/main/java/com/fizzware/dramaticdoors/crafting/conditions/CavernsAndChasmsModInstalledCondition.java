package com.fizzware.dramaticdoors.crafting.conditions;

import com.fizzware.dramaticdoors.DramaticDoors;
import com.google.gson.JsonObject;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class CavernsAndChasmsModInstalledCondition implements ICondition
{
	private final ResourceLocation location;

	public CavernsAndChasmsModInstalledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return ModList.get().isLoaded("caverns_and_chasms");
	}

	public static class Serializer implements IConditionSerializer<CavernsAndChasmsModInstalledCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(DramaticDoors.MOD_ID, "caverns_and_chasms_mod_installed");
		}

		@Override
		public void write(JsonObject json, CavernsAndChasmsModInstalledCondition value) {
			// Nothing to write here...
		}

		@Override
		public CavernsAndChasmsModInstalledCondition read(JsonObject json) {
			return new CavernsAndChasmsModInstalledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}