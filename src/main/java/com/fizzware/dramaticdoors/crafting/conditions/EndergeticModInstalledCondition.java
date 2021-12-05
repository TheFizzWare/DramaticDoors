package com.fizzware.dramaticdoors.crafting.conditions;

import com.fizzware.dramaticdoors.DramaticDoors;
import com.google.gson.JsonObject;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class EndergeticModInstalledCondition implements ICondition
{
	private final ResourceLocation location;

	public EndergeticModInstalledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return ModList.get().isLoaded("endergetic");
	}

	public static class Serializer implements IConditionSerializer<EndergeticModInstalledCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(DramaticDoors.MOD_ID, "endergetic_mod_installed");
		}

		@Override
		public void write(JsonObject json, EndergeticModInstalledCondition value) {
			// Nothing to write here...
		}

		@Override
		public EndergeticModInstalledCondition read(JsonObject json) {
			return new EndergeticModInstalledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}