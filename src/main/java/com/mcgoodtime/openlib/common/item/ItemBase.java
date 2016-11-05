/*
 * This file is part of ProductionLine, licensed under MIT License (MIT).
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
 */
package com.mcgoodtime.openlib.common.item;

import com.mcgoodtime.openlib.common.core.GoodTimeOpenLib;
import com.mcgoodtime.openlib.common.core.ISubMod;
import com.mcgoodtime.openlib.common.util.EnvironmentHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Created by BestOwl on 2016/10/2.
 *
 * Item registry template.
 * @author BestOwl
 */
public abstract class ItemBase extends Item {

    protected String itemName;
    private ISubMod mod;

    public ItemBase(String name, ISubMod subMod) {
        this.mod = subMod;
        this.itemName = name;

        this.setUnlocalizedName(this.mod.getModID() + "." + name);
        this.setCreativeTab(this.mod.getCreativeTab());

        if (this.needGenerateDefaultModel() && EnvironmentHelper.isDevEnvironment() && GoodTimeOpenLib.isClientSide) {
            this.generateDefaultModelJson();
        }

        GameRegistry.<Item>register(this, this.loc(name));
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> list, boolean bool) {
        int i = 1;
        String unLocal = this.getUnlocalizedName() + ".desc" + i;

        while (I18n.hasKey(unLocal)) {
            list.add(I18n.format(unLocal));
            i++;
            unLocal = this.getUnlocalizedName() + ".desc" + i;
        }
    }

    public ResourceLocation loc(String name) {
        return new ResourceLocation(this.mod.getModID(), name);
    }

    @SideOnly(Side.CLIENT)
    protected boolean needGenerateDefaultModel() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    private void generateDefaultModelJson() {

    }
}
