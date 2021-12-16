package com.fizzware.dramaticdoors.crafting.conditions;

import com.fizzware.dramaticdoors.DramaticDoors;
import com.google.gson.JsonObject;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class BiomesOPlentyModInstalledCondition implements ICondition
{
	private final ResourceLocation location;

	public BiomesOPlentyModInstalledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return ModList.get().isLoaded("biomesoplenty");
	}

	public static class Serializer implements IConditionSerializer<BiomesOPlentyModInstalledCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(DramaticDoors.MOD_ID, "biomesoplenty_mod_installed");
		}

		@Override
		public void write(JsonObject json, BiomesOPlentyModInstalledCondition value) {
			// Nothing to write here...
		}

		@Override
		public BiomesOPlentyModInstalledCondition read(JsonObject json) {
			return new BiomesOPlentyModInstalledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}