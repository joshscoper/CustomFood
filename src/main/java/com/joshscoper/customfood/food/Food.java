package com.joshscoper.customfood.food;

import com.joshscoper.customfood.food.effects.Effect;
import com.joshscoper.customfood.food.effects.EffectType;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Food {

    private ItemStack itemType;
    private Integer modelData;
    private String displayName;
    private ArrayList<String> lore;
    private EffectType effect;

    public Food(ItemStack itemType, Integer modelData, String displayName, ArrayList<String> lore, EffectType effect){
        this.itemType = itemType;
        this.modelData = modelData;
        this.displayName = displayName;
        this.lore = lore;
        this.effect = effect;
    }

    public ItemStack getItemType() {
        return itemType;
    }

    public void setItemType(ItemStack itemType) {
        this.itemType = itemType;
    }

    public Integer getModelData() {
        return modelData;
    }

    public void setModelData(Integer modelData) {
        this.modelData = modelData;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public ArrayList<String> getLore() {
        return lore;
    }

    public void setLore(ArrayList<String> lore) {
        this.lore = lore;
    }

    public EffectType getEffect() {
        return effect;
    }

    public void setEffect(EffectType effect) {
        this.effect = effect;
    }
}
