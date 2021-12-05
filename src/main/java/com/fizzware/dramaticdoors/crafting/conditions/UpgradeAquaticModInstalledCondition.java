package com.fizzware.dramaticdoors.crafting.conditions;

import com.fizzware.dramaticdoors.DramaticDoors;
import com.google.gson.JsonObject;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class UpgradeAquaticModInstalledCondition implements ICondition
{
	private final ResourceLocation location;

	public UpgradeAquaticModInstalledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return ModList.get().isLoaded("upgrade_aquatic");
	}

	public static class Serializer implements IConditionSerializer<UpgradeAquaticModInstalledCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(DramaticDoors.MOD_ID, "upgrade_aquatic_mod_installed");
		}

		@Override
		public void write(JsonObject json, UpgradeAquaticModInstalledCondition value) {
			// Nothing to write here...
		}

		@Override
		public UpgradeAquaticModInstalledCondition read(JsonObject json) {
			return new UpgradeAquaticModInstalledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}