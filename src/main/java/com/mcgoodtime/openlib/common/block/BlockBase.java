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

package com.mcgoodtime.openlib.common.block;

import com.mcgoodtime.openlib.common.core.ISubMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.IForgeRegistryEntry;

/**
 * Created by BestOwl on 2016/9/9 22:32.
 *
 * Block registry template.
 * @author BestOwl
 */
public class BlockBase extends Block implements IForgeRegistryEntry<Block> {

    public String internalName;
    private ISubMod mod;

    /**
     *
     * @param blockName block internal name(UnlocalizedName).
     */
    public BlockBase(Material materialIn, String blockName, ISubMod subMod) {
        super(materialIn);
        this.mod = subMod;

        this.setUnlocalizedName(subMod.getModID() + "." + "block" + "." + blockName);
        this.setCreativeTab(subMod.getCreativeTab());
        this.internalName = blockName;
        GameRegistry.register(this, new ResourceLocation(mod.getResourceDomain(), blockName));
    }

    public Class<? extends ItemBlock> getItemBlockClass() {
        return ItemBlock.class;
    }
}
