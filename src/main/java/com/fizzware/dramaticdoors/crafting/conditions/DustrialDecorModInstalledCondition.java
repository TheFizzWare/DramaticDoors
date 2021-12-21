package com.fizzware.dramaticdoors.crafting.conditions;

import com.fizzware.dramaticdoors.DramaticDoors;
import com.google.gson.JsonObject;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class DustrialDecorModInstalledCondition implements ICondition
{
	private final ResourceLocation location;

	public DustrialDecorModInstalledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return ModList.get().isLoaded("dustrial_decor");
	}

	public static class Serializer implements IConditionSerializer<DustrialDecorModInstalledCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(DramaticDoors.MOD_ID, "dustrial_decor_mod_installed");
		}

		@Override
		public void write(JsonObject json, DustrialDecorModInstalledCondition value) {
			// Nothing to write here...
		}

		@Override
		public DustrialDecorModInstalledCondition read(JsonObject json) {
			return new DustrialDecorModInstalledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}