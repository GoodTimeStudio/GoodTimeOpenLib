package com.mcgoodtime.openlib.common.util;

import net.minecraft.client.Minecraft;
import net.minecraft.launchwrapper.Launch;

/**
 * Created by BestOwl on 2016/10/2.
 *
 * Get mod the current running environment
 */
public class EnvironmentHelper {

    public static boolean isDevEnvironment() {
        return Launch.blackboard.get("fml.deobfuscatedEnvironment") == Boolean.TRUE;
    }

    //Non deobfuscated environment
    public static boolean isNormalEnvironment() {
        return Launch.blackboard.get("fml.deobfuscatedEnvironment") == Boolean.FALSE;
    }
}
