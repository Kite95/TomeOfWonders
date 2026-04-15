package com.platypushasnohat.tome_of_wonders;

import net.neoforged.fml.config.IConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec;

public class TomeOfWondersConfig {

    public static IConfigSpec COMMON_CONFIG;

    public static final String CATEGORY_MOBS = "mobs";
    public static final String CATEGORY_SQUILL = "squill";

    // common
    public static ModConfigSpec.IntValue SQUILL_SPAWN_HEIGHT;
    public static ModConfigSpec.BooleanValue SQUILL_SCHOOL_SPAWNING;

    static {
        ModConfigSpec.Builder COMMON_BUILDER = new ModConfigSpec.Builder();

        COMMON_BUILDER.push(CATEGORY_MOBS);

        COMMON_BUILDER.push(CATEGORY_SQUILL);
        SQUILL_SPAWN_HEIGHT = COMMON_BUILDER.comment("Spawn height for squills").defineInRange("squillSpawnHeight", 128, 0, 320);
        SQUILL_SCHOOL_SPAWNING = COMMON_BUILDER.comment("Whether squills spawn in schools").define("squillSchoolSpawning", true);
        COMMON_BUILDER.pop();

        COMMON_BUILDER.pop();
        COMMON_CONFIG = COMMON_BUILDER.build();
    }
}
