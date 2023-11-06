package me.blackfur.noweed;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static ForgeConfigSpec.BooleanValue WEED_GROW;
    public static ForgeConfigSpec.BooleanValue WEED_SPREAD;

    public static ForgeConfigSpec.BooleanValue CROP_TRAMPLE;

    static {
        BUILDER.push("Base Config");
        WEED_GROW = BUILDER.comment("Whether weed randomly grows on crop blocks").define("weed_grow", false);
        WEED_SPREAD = BUILDER.comment("Whether existing weed spreads").define("weed_spread", false);
        CROP_TRAMPLE = BUILDER.comment("Whether sprinting on crops destroys them").define("crop_trample", false);
        BUILDER.pop();

        SPEC = BUILDER.build();
    }
}
