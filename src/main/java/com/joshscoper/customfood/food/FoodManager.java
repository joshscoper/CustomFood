package com.joshscoper.customfood.food;

import com.joshscoper.customfood.Main;
import com.joshscoper.customfood.food.effects.EffectType;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class FoodManager {

    private Main main;
    private HashMap<String, Food > foodMap;

    public FoodManager(Main main){
        this.main = main;
        foodMap = new HashMap<>();
        initFood();
    }

    private void initFood(){
        for (String key : main.getFoodFile().getFile().getKeys(false)){
            createFoodObject(key);
        }
    }

    private void createFoodObject(String foodName){
        FileConfiguration foodFile = main.getFoodFile().getFile();
        if (foodFile.getKeys(false).contains(foodName)){
            ItemStack item = foodFile.getItemStack(foodName+".item");
            int modelData = foodFile.getInt(foodName+".item-meta.custom-model-data");
            String displayName = foodFile.getString(foodName+"item-meta.display-name");
            ArrayList<String> lore = (ArrayList<String>) foodFile.getStringList(foodName+".item-meta.lore");
            EffectType effectType = EffectType.valueOf(foodFile.getString(foodName+"effect").toUpperCase());
            Food foodObject = new Food(item,modelData,displayName,lore,effectType);
            foodMap.put(foodName,foodObject);
        }
    }

}
