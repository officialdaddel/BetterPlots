package play.mcdev.tv.betterplots.util.manager;

import com.plotsquared.core.PlotAPI;
import com.plotsquared.core.configuration.ConfigurationUtil;
import com.plotsquared.core.player.PlotPlayer;
import com.plotsquared.core.plot.BlockBucket;
import com.plotsquared.core.plot.Plot;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import com.sk89q.worldedit.function.pattern.Pattern;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import play.mcdev.tv.betterplots.util.Utilities;

import java.util.ArrayList;
import java.util.List;

import static play.mcdev.tv.betterplots.util.Utilities.*;


public class BorderManager {
    public static String borderguiname = "§6Randmenü";
    public static void openBorderMenu(Player p){
        Inventory inventory = Bukkit.createInventory(null, 5*9, borderguiname);
        for(int i = 0; i < 5*9; i++){
            if(i == 10){
                setBorderItem(p, Material.POLISHED_BLACKSTONE_SLAB, "0", "§eSpieler", "Standard", inventory, i);
            }else if(i == 11){
                setBorderItem(p, Material.BARRIER, "1", "§eSpieler", "Luft", inventory, i);
            }else if(i == 12){
                setBorderItem(p, Material.OAK_SLAB, "2", "§eSpieler", "Eichenholzstufe", inventory, i);
            }else if(i == 13){
                setBorderItem(p, Material.SANDSTONE_SLAB, "3", "§5Stamm", "Sandsteinstufe", inventory, i);
            }else if(i == 14){
                setBorderItem(p, Material.SANDSTONE, "4", "§5Stamm", "Sandstein", inventory, i);
            }else if(i == 15){
                setBorderItem(p, Material.RAIL, "5", "§5Stamm", "Schiene", inventory, i);
            }else if(i == 16){
                setBorderItem(p, Material.SOUL_TORCH, "6", "§9Ehre", "Seelenfackel", inventory, i);
            }else if(i == 19){
                setBorderItem(p, Material.NETHER_BRICK_SLAB, "7", "§9Ehre", "Netherziegelstufe", inventory, i);
            }else if(i == 20){
                setBorderItem(p, Material.OAK_FENCE, "8", "§9Ehre", "Eichenholzzaun", inventory, i);
            }else if(i == 21){
                setBorderItem(p, Material.QUARTZ_SLAB, "9", "§2Emerald", "Quarzstufe", inventory, i);
            }else if(i == 22){
                setBorderItem(p, Material.QUARTZ_BLOCK, "10", "§2Emerald", "Quarzblock", inventory, i);
            }else if(i == 23){
                setBorderItem(p, Material.POLISHED_BLACKSTONE_WALL, "11", "§2Emerald", "Polierte Schwarzsteinmauer", inventory, i);
            }else if(i == 24){
                setBorderItem(p, Material.GOLD_BLOCK, "12", "§bUltra", "Goldblock", inventory, i);
            }else if(i == 25){
                setBorderItem(p, Material.BAMBOO_FENCE, "13", "§bUltra", "Bambuszaun", inventory, i);
            }else if(i == 28){
                setBorderItem(p, Material.PURPLE_WOOL, "14", "§bUltra", "Lila Wolle", inventory, i);
            }else if(i == 29){
                setBorderItem(p, Material.DIAMOND_BLOCK, "15", "§6Premium", "Diamantblock", inventory, i);
            }else if(i == 30){
                setBorderItem(p, Material.BEACON, "16", "§6Premium", "Leuchtfeuer", inventory, i);
            }else if(i == 31){
                setBorderItem(p, Material.DEEPSLATE_BRICK_SLAB, "17", "§6Premium", "Tiefenschieferziegelstufe", inventory, i);
            }else if(i == 32){
                setBorderItem(p, Material.NETHERITE_BLOCK, "18", "§dLegende", "Netheriteblock", inventory, i);
            }else if(i == 33){
                setBorderItem(p, Material.BEDROCK, "19", "§dLegende", "Bedrock", inventory, i);
            }else if(i == 34){
                setBorderItem(p, Material.END_PORTAL_FRAME, "20", "§dLegende", "Endportalrahmen", inventory, i);
            }else if(i == 36){
                setBack(inventory, i);
            }else {
                setPlaceholders(inventory, i);
            }
        }
        p.openInventory(inventory);
    }
    public static void setBorder(Player p, String border, Material material){
        PlotAPI plotAPI = new PlotAPI();
        PlotPlayer<Player> plotPlayer = PlotPlayer.from(p);
        Plot plot = plotPlayer.getCurrentPlot();
        Pattern pattern = ((BlockBucket)ConfigurationUtil.BLOCK_BUCKET.parseString(material.toString())).toPattern();
        if(p.hasPermission(perms + "border." + border)){
            if(plot != null){
                if(plotPlayer.getCurrentPlot().isOwner(p.getUniqueId())){
                    for(Plot plots : plot.getConnectedPlots()){
                        plots.getArea().getPlotManager().setComponent(plots.getId(), "border", pattern, plotPlayer, null);
                    }
                    p.sendMessage(prefix + "§aDu hast den Rand erfolgreich geändert!");
                    p.closeInventory();
                }else {
                    Utilities.notYourPlot(p);
                }
            }else {
                Utilities.notOnPlot(p);
            }
        }else{
            Utilities.noperm(p);
        }
    }
    private static void setBorderItem(Player p, Material material, String border, String rank, String displayName, Inventory inventory, int slot){
        ItemStack is = new ItemStack(material);
        ItemMeta im = is.getItemMeta();
        List<String> lines = new ArrayList<>();
        if(p.hasPermission(perms + "border." + border)){
            lines.add(0, "§aVerfügbar");
            lines.add(1, "§8Zum ändern klicken");
        }else {
            lines.add(0, "");
            lines.add(1, "§7Verfügbar ab " + rank);
        }
        lines.add(2, "§7");
        im.setDisplayName("§f" + displayName);
        im.setLore(lines);
        im.setLocalizedName(border);
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
