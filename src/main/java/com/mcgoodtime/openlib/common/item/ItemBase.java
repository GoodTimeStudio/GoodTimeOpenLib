package com.mcgoodtime.openlib.common.item;

import com.mcgoodtime.openlib.common.core.ISubMod;
import com.mcgoodtime.openlib.common.util.EnvironmentHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.List;

/**
 * Created by BestOwl on 2016/10/2.
 *
 * Item registry template.
 * @author BestOwl
 */
public abstract class ItemBase extends Item {

    private String itemName;
    private ISubMod mod;

    public ItemBase(String name, ISubMod subMod) {
        this.mod = subMod;

        this.setUnlocalizedName(mod.getModID() + "." + name);
        this.itemName = name;
        GameRegistry.register(this, new ResourceLocation(mod.getResourceDomain(), itemName));

        if (this.needGenerateDefaultModel() && EnvironmentHelper.isDevEnvironment()) {
            this.generateDefaultModelJson();
        }
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

    protected boolean needGenerateDefaultModel() {
        return true;
    }

    private void generateDefaultModelJson() {

    }
}
