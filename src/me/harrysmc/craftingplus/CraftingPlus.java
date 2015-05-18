package me.harrysmc.craftingplus;

import me.harrysmc.craftingplus.cmd.CmdManager;
import me.harrysmc.craftingplus.craftingrecipe.ShapedCraftingRecipe;
import me.harrysmc.craftingplus.craftingrecipe.ShapelessCraftingRecipe;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by HarrysMc on 17/05/2015.
 */

public class CraftingPlus extends JavaPlugin {

    private Logger log = getLogger();
    private FileConfiguration config = getConfig();
    private String permissionMessage;
    private String reloadSuccessMessage;
    private String invalidCommandMessage;

    @Override
    public void onEnable(){
        setupConfig();
        log.info("Config setup!");

        reloadData();
        log.info("Data reloaded!");

        addRecipes();
        log.info("All recipes setup!");

        addCommands();
        log.info("Commands setup!");

    }

    @Override
    public void onDisable(){

        Bukkit.getServer().clearRecipes();
        log.info("Recipes cleared!");

    }

    private void addRecipes(){

        //<editor-fold desc ="Music Discs">
        new ShapedCraftingRecipe(this, "disc13", new ItemStack(Material.GOLD_RECORD, 1), true, new String[]{" O ", "OGO", " O "})
                .setIngredient('O', Material.OBSIDIAN).setIngredient('G', Material.GOLD_INGOT)
                .setup();

        new ShapedCraftingRecipe(this, "discCat", new ItemStack(Material.GREEN_RECORD, 1), true, new String[]{" O ", "OEO", " O "})
                .setIngredient('O', Material.OBSIDIAN).setIngredient('E', Material.EMERALD)
                .setup();

        new ShapedCraftingRecipe(this, "discBlocks", new ItemStack(Material.RECORD_3, 1), true, new String[]{" O ", "OBO", " O "})
                .setIngredient('O', Material.OBSIDIAN).setIngredient('B', Material.BRICK)
                .setup();

        new ShapedCraftingRecipe(this, "discChirp", new ItemStack(Material.RECORD_4, 1), true,  new String[]{" O ", "ORO", " O "})
                .setIngredient('O', Material.OBSIDIAN).setIngredient('R', Material.REDSTONE)
                .setup();

        new ShapedCraftingRecipe(this, "discFar", new ItemStack(Material.RECORD_5, 1), true, new String[]{" O ", "OSO", " O "})
                .setIngredient('O', Material.OBSIDIAN).setIngredient('S', Material.SLIME_BALL)
                .setup();

        new ShapedCraftingRecipe(this, "discMall", new ItemStack(Material.RECORD_6, 1), true, new String[]{" O ", "OCO", " O "})
                .setIngredient('O', Material.OBSIDIAN).setIngredient('C', Material.CLAY)
                .setup();

        new ShapedCraftingRecipe(this, "discMellohi", new ItemStack(Material.RECORD_7, 1), true, new String[]{" O ", "OGO", " O "})
                .setIngredient('O', Material.OBSIDIAN).setIngredient('G', Material.GHAST_TEAR)
                .setup();

        new ShapedCraftingRecipe(this, "discStal", new ItemStack(Material.RECORD_8, 1), true, new String[]{" O ", "OCO", " O "})
                .setIngredient('O', Material.OBSIDIAN).setIngredient('C', Material.COAL)
                .setup();

        new ShapedCraftingRecipe(this, "discStrad", new ItemStack(Material.RECORD_9, 1), true, new String[]{" O ", "OQO", " O "})
                .setIngredient('O', Material.OBSIDIAN).setIngredient('Q', Material.QUARTZ)
                .setup();

        new ShapedCraftingRecipe(this, "discWard", new ItemStack(Material.RECORD_10, 1), true, new String[]{" O ", "OEO", " O "})
                .setIngredient('O', Material.OBSIDIAN).setIngredient('E', Material.EYE_OF_ENDER)
                .setup();

        new ShapedCraftingRecipe(this, "disc11", new ItemStack(Material.RECORD_11, 1), true, new String[]{" O ", "OCO", " O "})
                .setIngredient('O', Material.OBSIDIAN).setIngredient('C', Material.COAL, 1)
                .setup();

        new ShapedCraftingRecipe(this, "discWait", new ItemStack(Material.RECORD_12, 1), true, new String[]{" O ", "ODO", " O "})
                .setIngredient('O', Material.OBSIDIAN).setIngredient('D', Material.DIAMOND)
                .setup();

        //</editor-fold>

        //<editor-fold desc ="Horse Armour">
        new ShapedCraftingRecipe(this, "ironHorseArmor", new ItemStack(Material.IRON_BARDING, 1), true, new String[]{"  I", "IBI", "III"})
                .setIngredient('I', Material.IRON_INGOT).setIngredient('B', Material.WOOL, 15)
                .setup();

        new ShapedCraftingRecipe(this, "goldHorseArmor", new ItemStack(Material.GOLD_BARDING, 1), true, new String[]{"  G", "GRG", "GGG"})
                .setIngredient('G', Material.GOLD_INGOT).setIngredient('R', Material.WOOL, 14)
                .setup();

        new ShapedCraftingRecipe(this, "diamondHorseArmor", new ItemStack(Material.DIAMOND_BARDING, 1), true, new String[]{"  D", "DBD", "DDD"})
                .setIngredient('D', Material.DIAMOND).setIngredient('B', Material.WOOL, 11)
                .setup();
        //</editor-fold>

        //<editor-fold desc ="Ice">
        new ShapedCraftingRecipe(this, "ice", new ItemStack(Material.ICE, 1), true, new String[]{"SSS", "SWS", "SSS"})
                .setIngredient('S', Material.SNOW_BALL).setIngredient('W', Material.WATER_BUCKET)
                .setup();

        new ShapelessCraftingRecipe(this, "packedIce", new ItemStack(Material.PACKED_ICE, 1), true)
                .addIngredient(4, Material.ICE)
                .setup();
        //</editor-fold>

        //<editor-fold desc ="Miscellaneous">
        new ShapedCraftingRecipe(this, "saddle", new ItemStack(Material.SADDLE, 1), true, new String[]{"LLL", "SLS", "I I"})
                .setIngredient('L', Material.LEATHER).setIngredient('S', Material.STRING)
                .setIngredient('I', Material.IRON_INGOT).setup();

        new ShapedCraftingRecipe(this, "nameTag", new ItemStack(Material.NAME_TAG, 1), true, new String[]{"  S", " P ", "P  "})
                .setIngredient('S', Material.STRING).setIngredient('P', Material.PAPER)
                .setup();

        new ShapedCraftingRecipe(this, "cobWeb", new ItemStack(Material.WEB, 1), true, new String[]{"SSS", "SBS", "SSS"})
                .setIngredient('S', Material.STRING).setIngredient('B', Material.SNOW_BALL)
                .setup();

        new ShapedCraftingRecipe(this, "mobSpawner", new ItemStack(Material.MOB_SPAWNER, 1), false, new String[]{"III", "IPI", "III"})
                .setIngredient('I', Material.IRON_FENCE).setIngredient('P', Material.MONSTER_EGG, 90)
                .setup();
        //</editor-fold>

    }

    private void addCommands(){

        getCommand("craftingplus").setExecutor(new CmdManager(this));

    }

    private void setupConfig(){

        config.addDefault("permission-message", "&cYou do not have permission for this command!");
        config.addDefault("reload-success-message", "&aThe config has been successfully reloaded.");
        config.addDefault("invalid-command-message", "&cThat is an invalid command. Type '/craftingplus help' for help.");

        config.options().copyDefaults(true);
        saveConfig();

    }

    public void reloadData(){

        permissionMessage = ChatColor.translateAlternateColorCodes('&', config.getString("permission-message") );
        reloadSuccessMessage = ChatColor.translateAlternateColorCodes('&', config.getString("reload-success-message"));
        invalidCommandMessage = ChatColor.translateAlternateColorCodes('&', config.getString("invalid-command-message"));

    }

    public String getPermissionMessage(){ return permissionMessage; }
    public String getReloadSuccessMessage(){ return reloadSuccessMessage; }
    public String getInvalidCommandMessage(){ return invalidCommandMessage; }

}
