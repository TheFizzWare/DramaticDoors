package com.fizzware.dramaticdoors.crafting.conditions;

import com.fizzware.dramaticdoors.DramaticDoors;
import com.google.gson.JsonObject;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class EnhancedMushroomsModInstalledCondition implements ICondition
{
	private final ResourceLocation location;

	public EnhancedMushroomsModInstalledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return ModList.get().isLoaded("enhanced_mushrooms");
	}

	public static class Serializer implements IConditionSerializer<EnhancedMushroomsModInstalledCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(DramaticDoors.MOD_ID, "enhanced_mushrooms_mod_installed");
		}

		@Override
		public void write(JsonObject json, EnhancedMushroomsModInstalledCondition value) {
			// Nothing to write here...
		}

		@Override
		public EnhancedMushroomsModInstalledCondition read(JsonObject json) {
			return new EnhancedMushroomsModInstalledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}