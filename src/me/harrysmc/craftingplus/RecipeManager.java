package me.harrysmc.craftingplus;

import me.harrysmc.craftingplus.craftingrecipe.ShapedCraftingRecipe;
import me.harrysmc.craftingplus.craftingrecipe.ShapelessCraftingRecipe;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Hary on 19/05/2015.
 */
public class RecipeManager {

    CraftingPlus plugin;

    public RecipeManager(CraftingPlus plugin){

        this.plugin = plugin;

        addRecipes();

    }

    private void addRecipes(){

        //<editor-fold desc ="Music Discs">
        createDisk("13", Material.GOLD_RECORD, Material.GOLD_INGOT);
        createDisk("Cat", Material.GREEN_RECORD, Material.EMERALD);
        createDisk("Blocks", Material.RECORD_3, Material.BRICK);
        createDisk("Chirp", Material.RECORD_4, Material.REDSTONE);
        createDisk("Far", Material.RECORD_5, Material.SLIME_BALL);
        createDisk("Mall", Material.RECORD_6, Material.CLAY);
        createDisk("Mellohi", Material.RECORD_7, Material.GHAST_TEAR);
        createDisk("Stal", Material.RECORD_8, Material.COAL);
        createDisk("Strad", Material.RECORD_9, Material.QUARTZ);
        createDisk("Ward", Material.RECORD_10, Material.EYE_OF_ENDER);
        createDisk("11", Material.RECORD_11, Material.COAL, 1);
        createDisk("Wait", Material.RECORD_12, Material.DIAMOND);
        //</editor-fold>

        //<editor-fold desc ="Horse Armour">
        createHorseArmor("iron", Material.IRON_BARDING, 15);
        createHorseArmor("gold", Material.GOLD_BARDING, 14);
        createHorseArmor("diamond", Material.DIAMOND_BARDING, 11);
        //</editor-fold>

        //<editor-fold desc ="Ice">
        new ShapedCraftingRecipe(plugin, "ice", new ItemStack(Material.ICE, 1), true, new String[]{"SSS", "SWS", "SSS"})
                .setIngredient('S', Material.SNOW_BALL).setIngredient('W', Material.WATER_BUCKET)
                .setup();

        new ShapelessCraftingRecipe(plugin, "packedIce", new ItemStack(Material.PACKED_ICE, 1), true)
                .addIngredient(4, Material.ICE)
                .setup();
        //</editor-fold>

        //<editor-fold desc ="Miscellaneous">
        new ShapedCraftingRecipe(plugin, "saddle", new ItemStack(Material.SADDLE, 1), true, new String[]{"LLL", "SLS", "I I"})
                .setIngredient('L', Material.LEATHER).setIngredient('S', Material.STRING)
                .setIngredient('I', Material.IRON_INGOT).setup();

        new ShapedCraftingRecipe(plugin, "nameTag", new ItemStack(Material.NAME_TAG, 1), true, new String[]{"  S", " P ", "P  "})
                .setIngredient('S', Material.STRING).setIngredient('P', Material.PAPER)
                .setup();

        new ShapedCraftingRecipe(plugin, "cobWeb", new ItemStack(Material.WEB, 1), true, new String[]{"SSS", "SBS", "SSS"})
                .setIngredient('S', Material.STRING).setIngredient('B', Material.SNOW_BALL)
                .setup();

        new ShapedCraftingRecipe(plugin, "mobSpawner", new ItemStack(Material.MOB_SPAWNER, 1), false, new String[]{"III", "IPI", "III"})
                .setIngredient('I', Material.IRON_FENCE).setIngredient('P', Material.MONSTER_EGG, 90)
                .setup();
        //</editor-fold>

    }

    private void createDisk(String name, Material disc, Material item, int data){

        new ShapedCraftingRecipe(plugin, "disc" + name, new ItemStack(disc, 1), true, new String[]{" O ", "OMO", " O "})
                .setIngredient('O', Material.OBSIDIAN).setIngredient('M', item, data)
                .setup();

    }

    private void createDisk(String name, Material disc, Material item){

        createDisk(name, disc, item, 0);

    }

    private void createHorseArmor(String name, Material armor, int data){

        new ShapedCraftingRecipe(plugin, name + "HorseArmor", new ItemStack(armor, 1), true, new String[]{"  I", "IBI", "III"})
                .setIngredient('I', Material.IRON_INGOT).setIngredient('B', Material.WOOL, data)
                .setup();

    }
}
