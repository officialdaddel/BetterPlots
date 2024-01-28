package play.mcdev.tv.betterplots.util.manager;

import com.plotsquared.core.PlotAPI;
import com.plotsquared.core.configuration.ConfigurationUtil;
import com.plotsquared.core.player.PlotPlayer;
import com.plotsquared.core.plot.BlockBucket;
import com.plotsquared.core.plot.Plot;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import com.sk89q.worldedit.function.pattern.Pattern;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import play.mcdev.tv.betterplots.util.Utilities;

import java.util.ArrayList;
import java.util.List;

import static play.mcdev.tv.betterplots.util.Utilities.*;

public class WallManager {
    public static String wallguiname = "§6Wandmenü";
    public static void openWallMenu(Player p){
        Inventory inventory = Bukkit.createInventory(null, 5*9, wallguiname);
        for(int i = 0; i < 5*9; i++){
            if(i == 10){
                setWallItem(p, Material.STONE, "0", "§eSpieler", "Standard", inventory, i);
            }else if(i == 11){
                setWallItem(p, Material.OAK_PLANKS, "1", "§eSpieler", "Eichenholzbretter", inventory, i);
            }else if(i == 12){
                setWallItem(p, Material.GLOWSTONE, "2", "§eSpieler", "Leuchtstein", inventory, i);
            }else if(i == 13){
                setWallItem(p, Material.SEA_LANTERN, "3", "§5Stamm", "Seelaterne", inventory, i);
            }else if(i == 14){
                setWallItem(p, Material.SANDSTONE, "4", "§5Stamm", "Sandstein", inventory, i);
            }else if(i == 15){
                setWallItem(p, Material.DARK_OAK_PLANKS, "5", "§5Stamm", "Schwarzeichenholz", inventory, i);
            }else if(i == 16){
                setWallItem(p, Material.QUARTZ_BLOCK, "6", "§9Ehre", "Quarzblock", inventory, i);
            }else if(i == 19){
                setWallItem(p, Material.SMOOTH_QUARTZ, "7", "§9Ehre", "Glatter Quarzblock", inventory, i);
            }else if(i == 20){
                setWallItem(p, Material.CHERRY_PLANKS, "8", "§9Ehre", "Kirschenholz", inventory, i);
            }else if(i == 21){
                setWallItem(p, Material.PRISMARINE, "9", "§2Emerald", "Prismarin", inventory, i);
            }else if(i == 22){
                setWallItem(p, Material.DARK_PRISMARINE, "10", "§2Emerald", "Dunkler Prismarin", inventory, i);
            }else if(i == 23){
                setWallItem(p, Material.AMETHYST_BLOCK, "11", "§2Emerald", "Amethystblock", inventory, i);
            }else if(i == 24){
                setWallItem(p, Material.GOLD_BLOCK, "12", "§bUltra", "Goldblock", inventory, i);
            }else if(i == 25){
                setWallItem(p, Material.DEEPSLATE_TILES, "13", "§bUltra", "Tiefenschieferfliesen", inventory, i);
            }else if(i == 28){
                setWallItem(p, Material.PURPUR_BLOCK, "14", "§bUltra", "Purpurblock", inventory, i);
            }else if(i == 29){
                setWallItem(p, Material.DIAMOND_BLOCK, "15", "§6Premium", "Diamantblock", inventory, i);
            }else if(i == 30){
                setWallItem(p, Material.TUFF, "16", "§6Premium", "Tuff", inventory, i);
            }else if(i == 31){
                setWallItem(p, Material.SHROOMLIGHT, "17", "§6Premium", "Pilzlicht", inventory, i);
            }else if(i == 32){
                setWallItem(p, Material.NETHERITE_BLOCK, "18", "§dLegende", "Netheriteblock", inventory, i);
            }else if(i == 33){
                setWallItem(p, Material.BEDROCK, "19", "§dLegende", "Bedrock", inventory, i);
            }else if(i == 34){
                setWallItem(p, Material.CALCITE, "20", "§dLegende", "Kalzit", inventory, i);
            }else if(i == 36){
                setBack(inventory, i);
            }else {
                setPlaceholders(inventory, i);
            }
        }
        p.openInventory(inventory);
    }
    public static void setWall(Player p, String wall, Material material){
        PlotAPI plotAPI = new PlotAPI();
        PlotPlayer<Player> plotPlayer = PlotPlayer.from(p);
        Plot plot = plotPlayer.getCurrentPlot();
        Pattern pattern = ((BlockBucket) ConfigurationUtil.BLOCK_BUCKET.parseString(material.toString())).toPattern();
        if(p.hasPermission(perms + ".wall." + wall)){
            if(plot != null){
                if(plotPlayer.getCurrentPlot().isOwner(p.getUniqueId())){
                    for(Plot plots : plot.getConnectedPlots()){
                        plots.getArea().getPlotManager().setComponent(plots.getId(), "wall", pattern, plotPlayer, null);
                    }
                    p.sendMessage(prefix + "§aDu hast die Wand erfolgreich geändert!");
                    p.closeInventory();
                }else {
                    Utilities.notYourPlot(p);
                }
            }else {
                Utilities.notOnPlot(p);
            }
        }else {
            noperm(p);
        }
    }
    private static void setWallItem(Player p, Material material, String wall, String rank, String displayName, Inventory inventory, int slot){
        ItemStack is = new ItemStack(material);
        ItemMeta im = is.getItemMeta();
        List<String> lines = new ArrayList<>();
        if(p.hasPermission(perms + "wall." + wall)){
            lines.add(0, "§aVerfügbar");
            lines.add(1, "§8Zum ändern klicken");
        }else {
            lines.add(0, "");
            lines.add(1, "§7Verfügbar ab " + rank);
        }
        lines.add(2, "§7");
        im.setDisplayName("§f" + displayName);
        im.setLore(lines);
        im.setLocalizedName(wall);
        is.setItemMeta(im);
        inventory.setItem(slot, is);
    }
    private static void setBack(Inventory inventory, int slot){
        ItemStack is = new ItemStack(Material.ARROW);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName("§cZurück");
        im.setLocalizedName("back");
        is.setItemMeta(im);
        inventory.setItem(slot, is);
    }
    private static void setPlaceholders(Inventory inventory, int slot){
        ItemStack is = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(" ");
        im.setLocalizedName("placeholder");
        is.setItemMeta(im);
        inventory.setItem(slot, is);
    }
}
