package com.fizzware.dramaticdoors.init;

import com.fizzware.dramaticdoors.content.TallDoorBlock;
import com.fizzware.dramaticdoors.util.Ref;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.TallBlockItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Arrays;
import java.util.Set;

public enum DoorMaterial {
    // Vanilla
    OAK("tall_oak_door", Material.WOOD, MaterialColor.WOOD, 3.0F, SoundType.WOOD, Blocks.OAK_DOOR.getRegistryName()),
    SPRUCE("tall_spruce_door", Material.WOOD, MaterialColor.OBSIDIAN, 3.0F, SoundType.WOOD, Blocks.SPRUCE_DOOR.getRegistryName()),
    BIRCH("tall_birch_door", Material.WOOD, MaterialColor.SAND, 3.0F, SoundType.WOOD, Blocks.BIRCH_DOOR.getRegistryName()),
    JUNGLE("tall_jungle_door", Material.WOOD, MaterialColor.DIRT, 3.0F, SoundType.WOOD, Blocks.JUNGLE_DOOR.getRegistryName()),
    ACACIA("tall_acacia_door", Material.WOOD, MaterialColor.ADOBE, 3.0F, SoundType.WOOD, Blocks.ACACIA_DOOR.getRegistryName()),
    DARK_OAK("tall_dark_oak_door", Material.WOOD, MaterialColor.BROWN, 3.0F, SoundType.WOOD, Blocks.DARK_OAK_DOOR.getRegistryName()),
    IRON("tall_iron_door", Material.IRON, MaterialColor.IRON, 5.0F, SoundType.METAL, Blocks.IRON_DOOR.getRegistryName()),

    // Upgrade Aquatic
    DRIFTWOOD("upgrade_aquatic", "tall_driftwood_door", Material.WOOD, MaterialColor.STONE, 2.0F, SoundType.WOOD, null),
    RIVER("upgrade_aquatic", "tall_river_door", Material.WOOD, MaterialColor.BROWN, 2.0F, SoundType.WOOD, null),
    TOOTH("upgrade_aquatic", "tall_tooth_door", Material.ROCK, MaterialColor.SAND, 3.0F, 9.0F, null, null), // No Sound Type? Matches End Stone

    // Atmospheric
    ROSEWOOD("atmospheric", "tall_rosewood_door", Material.WOOD, MaterialColor.WOOD, 3.0F, SoundType.WOOD, null), // Matches Oak Door
    YUCCA("atmospheric", "tall_yucca_door", Material.WOOD, MaterialColor.WOOD, 3.0F, SoundType.WOOD, null), // Matches Oak Door
    KOUSA("atmospheric", "tall_kousa_door", Material.WOOD, MaterialColor.WOOD, 3.0F, SoundType.WOOD, null), // Matches Oak Door
    ASPEN("atmospheric", "tall_aspen_door", Material.WOOD, MaterialColor.WOOD, 3.0F, SoundType.WOOD, null), // Matches Oak Door
    GRIMWOOD("atmospheric", "tall_grimwood_door", Material.WOOD, MaterialColor.WOOD, 3.0F, SoundType.WOOD, null), // Matches Oak Door?

    // Biomes O' Plenty
    FIR("biomesoplenty", "tall_fir_door", Material.WOOD, MaterialColor.WHITE_TERRACOTTA, 3.0F, SoundType.WOOD, null),
    REDWOOD("biomesoplenty", "tall_redwood_door", Material.WOOD, MaterialColor.ORANGE_TERRACOTTA, 3.0F, SoundType.WOOD, null),
    CHERRY("biomesoplenty", "tall_cherry_door", Material.WOOD, MaterialColor.RED, 3.0F, SoundType.WOOD, null),
    MAHOGANY("biomesoplenty", "tall_mahogany_door", Material.WOOD, MaterialColor.PINK_TERRACOTTA, 3.0F, SoundType.WOOD, null),
    JACARANDA("biomesoplenty", "tall_jacaranda_door", Material.WOOD, MaterialColor.WHITE_TERRACOTTA, 3.0F, SoundType.WOOD, null),
    PALM("biomesoplenty", "tall_palm_door", Material.WOOD, MaterialColor.YELLOW_TERRACOTTA, 3.0F, SoundType.WOOD, null),
    WILLOW("biomesoplenty", "tall_willow_door", Material.WOOD, MaterialColor.LIME_TERRACOTTA, 3.0F, SoundType.WOOD, null),
    DEAD("biomesoplenty", "tall_dead_door", Material.WOOD, MaterialColor.STONE, 3.0F, SoundType.WOOD, null),
    MAGIC("biomesoplenty", "tall_magic_door", Material.WOOD, MaterialColor.BLUE, 3.0F, SoundType.WOOD, null),
    UMBRAN("biomesoplenty", "tall_umbran_door", Material.WOOD, MaterialColor.BLUE_TERRACOTTA, 3.0F, SoundType.WOOD, null),
    HELLBARK("biomesoplenty", "tall_hellbark_door", Material.WOOD, MaterialColor.GRAY_TERRACOTTA, 3.0F, SoundType.WOOD, null),
    ETHEREAL("biomesoplenty", "tall_ethereal_door", Material.WOOD, MaterialColor.QUARTZ, 3.0F, SoundType.WOOD, null),

    // Bloomful
    WISTERIA("bloomful", "tall_wisteria_door", Material.WOOD, MaterialColor.WHITE_TERRACOTTA, 3.0F, SoundType.WOOD, null);

    private final String REGISTRY_NAME;
    private final String NAMESPACE;
    private final Block BLOCK;
    private final ResourceLocation INGREDIENT;
    private final Item ITEM;
    private final Material MATERIAL;
    private final MaterialColor COLOR;
    private final float HARDNESS;
    private final float RESISTANCE;
    private final SoundType SOUND;

    DoorMaterial(String registry_name, Material material, MaterialColor color, float hardness, float resistance, SoundType sound, ResourceLocation ingredient) {
        this("minecraft", registry_name, material, color, hardness, resistance, sound, ingredient);
    }

    DoorMaterial(String namespace, String registry_name, Material material, MaterialColor color, float hardness, float resistance, SoundType sound, ResourceLocation ingredient) {
        this.REGISTRY_NAME = registry_name;
        this.NAMESPACE = namespace;
        this.MATERIAL = material;
        this.COLOR = color;
        this.HARDNESS = hardness;
        this.RESISTANCE = resistance;
        this.SOUND = sound;
        this.BLOCK = makeBlock();
        this.ITEM = makeBlockItem();
        if (ingredient == null) {
            this.INGREDIENT = new ResourceLocation(namespace + ":" + registry_name.substring(5));
        } else {
            this.INGREDIENT = ingredient;
        }
    }

    DoorMaterial(String registry_name, Material material, MaterialColor color, float hardness_and_resistance, SoundType sound, ResourceLocation ingredient) {
        this(registry_name, material, color, hardness_and_resistance, hardness_and_resistance, sound, ingredient);
    }

    DoorMaterial(String namespace, String registry_name, Material material, MaterialColor color, float hardness_and_resistance, SoundType sound, ResourceLocation ingredient) {
        this(namespace, registry_name, material, color, hardness_and_resistance, hardness_and_resistance, sound, ingredient);
    }

    public Block getBlock() {
        return this.BLOCK;
    }

    public ResourceLocation getIngredient() { return this.INGREDIENT; }

    public Item getItem() {
        return this.ITEM;
    }

    private Block makeBlock() {
        Block.Properties properties = makeProperties();
        return (new TallDoorBlock(properties)).setRegistryName(Ref.MOD_ID, this.REGISTRY_NAME);
    }

    private Item makeBlockItem() {
        return (new TallBlockItem(this.BLOCK, (new Item.Properties()).group(ItemGroup.REDSTONE))).setRegistryName(Ref.MOD_ID, this.REGISTRY_NAME);
    }

    private Block.Properties makeProperties() {
        Block.Properties result = Block.Properties.create(this.MATERIAL, this.COLOR).hardnessAndResistance(this.HARDNESS, this.RESISTANCE);
        if (this.SOUND != null) {
            result = result.sound(this.SOUND);
        }
        return result;
    }

    public String getKeyword() {
        return this.REGISTRY_NAME.replace("tall_","").replace("_door", "");
    }

    public enum DoorGroup {
        VANILLA("minecraft", OAK, IRON, SPRUCE, BIRCH, JUNGLE, ACACIA, DARK_OAK),
        ATMOSPHERIC("atmospheric", ROSEWOOD, YUCCA, KOUSA, ASPEN, GRIMWOOD),
        BLOOMFUL("bloomful", WISTERIA),
        BOP("biomesoplenty", FIR, REDWOOD, CHERRY, MAHOGANY, JACARANDA, PALM, WILLOW, DEAD, MAGIC, UMBRAN, HELLBARK, ETHEREAL),
        UPGRADE_AQUATIC("upgrade_aquatic", DRIFTWOOD, RIVER, TOOTH),
        QUARK("quark"),
        DOUBLEDOORS("doubledoors");

        private final String DOMAIN;
        private final DoorMaterial[] GROUP;

        DoorGroup(String domain, DoorMaterial... group) {
            this.DOMAIN = domain;
            this.GROUP = group;
        }

        public static DoorGroup getByModId(String mod_id) {
            return Arrays.stream(DoorGroup.values()).filter(group -> group.getDomain().equals(mod_id)).findFirst().orElseThrow(() -> new IllegalArgumentException(mod_id));
        }

        private DoorMaterial[] getGroup() {
            return this.GROUP;
        }

        private String getDomain() {
            return this.DOMAIN;
        }

        public Block[] getGroupBlocks() {
            return Arrays.stream(this.GROUP).map(DoorMaterial::getBlock).toArray(Block[]::new);
        }

        public Item[] getGroupItems() {
            return Arrays.stream(this.GROUP).map(DoorMaterial::getItem).toArray(Item[]::new);
        }

        public DoorMaterial[] getGroupMaterials() {
            return this.GROUP.clone();
        }

    }
}
