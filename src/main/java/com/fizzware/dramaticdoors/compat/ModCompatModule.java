package com.fizzware.dramaticdoors.compat;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
@SuppressWarnings("BooleanMethodAlwaysInverted")
public enum ModCompatModule implements IStringSerializable {
    VANILLA("minecraft", false),
    QUARK("quark", false, false),
    DOUBLEDOORS("doubledoors", false, false),
    ATMOSPHERIC("atmospheric", true),
    BLOOMFUL("bloomful", true),
    BOP("biomesoplenty", true),
    UPGRADE_AQUATIC("upgrade_aquatic", true);

    private final String MOD_ID;
    private boolean LOADED;
    private final String VERSION;
    private final boolean DISABLED;
    private final boolean REQUIRES_REGISTRY;

    ModCompatModule(String mod_id, boolean disabled, boolean requires_registry) {
        ModList modlist = ModList.get();
        this.MOD_ID = mod_id;
        this.LOADED = modlist.isLoaded(mod_id);
        this.DISABLED = disabled;
        this.REQUIRES_REGISTRY = requires_registry;
        if (LOADED) {
            assert modlist.getModContainerById(mod_id).isPresent();
            ModContainer mc = modlist.getModContainerById(mod_id).get();
            this.VERSION = mc.getModInfo().getVersion().toString();
        } else {
            this.VERSION = null;
        }
    }

    ModCompatModule(String mod_id, boolean disabled) {
        ModList modlist = ModList.get();
        this.MOD_ID = mod_id;
        this.LOADED = modlist.isLoaded(mod_id);
        this.DISABLED = disabled;
        this.REQUIRES_REGISTRY = true;
        if (LOADED) {
            assert modlist.getModContainerById(mod_id).isPresent();
            ModContainer mc = modlist.getModContainerById(mod_id).get();
            this.VERSION = mc.getModInfo().getVersion().toString();
        } else {
            this.VERSION = null;
        }
    }

    @Override
    public String getName() {
        return MOD_ID;
    }

    public String getFullName() {
        return "[" + MOD_ID + "] version [" + VERSION + "]";
    }

    public boolean isLoaded() {
        return LOADED;
    }

    public boolean checkLoaded() {
        ModList modlist = ModList.get();
        boolean wasAlreadyLoaded = this.LOADED;
        this.LOADED = modlist.isLoaded(MOD_ID) && modlist.getModContainerById(MOD_ID).isPresent();
        return wasAlreadyLoaded != this.LOADED;
    }

    public boolean isDisabled() { return DISABLED; }

    public static String[] getSupportedMods() {
        return Arrays.stream(ModCompatModule.values()).filter(module -> !module.isDisabled()).map(ModCompatModule::getName).toArray(String[]::new);
    }

    public static String[] getRegistryMods() {
        return Arrays.stream(ModCompatModule.values()).filter(module -> !module.isDisabled() && module.REQUIRES_REGISTRY).map(ModCompatModule::getName).toArray(String[]::new);
    }

    public static ModCompatModule getByModId(String mod_id) {
        return Arrays.stream(ModCompatModule.values()).filter(module -> module.getName().equals(mod_id)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

}
