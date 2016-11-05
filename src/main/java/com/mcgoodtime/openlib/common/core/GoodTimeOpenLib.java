/*
 * This file is part of GoodTimeOpenLib, licensed under MIT License (MIT).
 *
 * Copyright (c) 2016 GoodTime Studio <https://github.com/GoodTimeStudio>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 */

package com.mcgoodtime.openlib.common.core;

import net.minecraft.client.Minecraft;
import net.minecraft.crash.CrashReport;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by BestOwl on 2016/9/9 23:07.
 *
 */
@Mod(
        modid = GoodTimeOpenLib.MOD_NAME,
        version = GoodTimeOpenLib.VERSION,
        acceptedMinecraftVersions = GoodTimeOpenLib.MC_VERSION
)
public class GoodTimeOpenLib {

    public static final String MOD_NAME = "GoodTimeOpenLib";
    public static final String VERSION = "${version}";
    public static final String MC_VERSION = "${mc_version}";

    @SidedProxy(
            serverSide = "com.mcgoodtime.openlib.common.core.GoodTimeOpenLib$CommonProxy",
            clientSide = "com.mcgoodtime.openlib.common.core.GoodTimeOpenLib$ClientProxy"
    )
    public static CommonProxy proxy;

    public static boolean isClientSide = false;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit();
    }

    public static class CommonProxy {
        public void preInit() {}
    }

    public static class ClientProxy extends CommonProxy {
        @Override
        public void preInit() {
            super.preInit();
            isClientSide = true;
        }
    }
}
