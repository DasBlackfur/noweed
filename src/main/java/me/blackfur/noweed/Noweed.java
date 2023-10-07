package me.blackfur.noweed;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Noweed.MODID)
public class Noweed {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "noweed";

    public Noweed() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC, "noweed-config.toml");
    }
}
