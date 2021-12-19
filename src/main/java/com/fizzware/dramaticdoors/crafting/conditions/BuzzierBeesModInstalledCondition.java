package com.fizzware.dramaticdoors.crafting.conditions;

import com.fizzware.dramaticdoors.DramaticDoors;
import com.google.gson.JsonObject;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class BuzzierBeesModInstalledCondition implements ICondition
{
	private final ResourceLocation location;

	public BuzzierBeesModInstalledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return ModList.get().isLoaded("buzzier_bees");
	}

	public static class Serializer implements IConditionSerializer<BuzzierBeesModInstalledCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(DramaticDoors.MOD_ID, "buzzier_bees_mod_installed");
		}

		@Override
		public void write(JsonObject json, BuzzierBeesModInstalledCondition value) {
			// Nothing to write here...
		}

		@Override
		public BuzzierBeesModInstalledCondition read(JsonObject json) {
			return new BuzzierBeesModInstalledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}