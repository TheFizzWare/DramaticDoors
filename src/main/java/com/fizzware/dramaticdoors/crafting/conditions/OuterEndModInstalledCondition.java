package com.fizzware.dramaticdoors.crafting.conditions;

import com.fizzware.dramaticdoors.DramaticDoors;
import com.google.gson.JsonObject;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class OuterEndModInstalledCondition implements ICondition
{
	private final ResourceLocation location;

	public OuterEndModInstalledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return ModList.get().isLoaded("outer_end");
	}

	public static class Serializer implements IConditionSerializer<OuterEndModInstalledCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(DramaticDoors.MOD_ID, "outer_end_mod_installed");
		}

		@Override
		public void write(JsonObject json, OuterEndModInstalledCondition value) {
			// Nothing to write here...
		}

		@Override
		public OuterEndModInstalledCondition read(JsonObject json) {
			return new OuterEndModInstalledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}