package com.joshscoper.customfood;

import com.joshscoper.customfood.commands.CustomFoodCommand;
import com.joshscoper.customfood.food.FoodManager;
import com.joshscoper.customfood.util.FileManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private FileManager config;
    private FileManager lang;
    private FileManager food;
    private FoodManager foodManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        setupFiles();
        initializeManagers();
        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void setupFiles(){
        config = new FileManager(this, "config.yml");
        lang = new FileManager(this, "lang.yml");
        food = new FileManager(this, "food.yml");
        config.setupFile();
        lang.setupFile();
        food.setupFile();
    }

    private void initializeManagers(){
        foodManager = new FoodManager(this);
    }
    private void registerCommands(){
        new CustomFoodCommand(this);
    }
    private void registerEvents(){}
    public FileManager getConfigManager() {
        return config;
    }

    public FileManager getLangManager() {
        return lang;
    }

    public FileManager getFoodFile() {
        return food;
    }

    public FoodManager getFoodManager() {
        return foodManager;
    }
}
