package play.mcdev.tv.betterplots.util.manager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

public class PlotMenuManager {
    public static String guiname = "§6Grundstücksmenü";
    public static void openPlotMenu(Player p){
        Inventory inventory = Bukkit.createInventory(null, 3*9, guiname);
        for (int i = 0; i < 3*9; i++){
            if(i == 12){
                setBorderItem(inventory, i);
            }else if(i == 14){
                setWallItem(inventory, i);
            }else {
                setPlaceholders(inventory, i);
            }
        }
        p.openInventory(inventory);
    }
    private static void setPlaceholders(Inventory inventory, int slot){
        ItemStack is = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(" ");
        im.setLocalizedName("placeholder");
        is.setItemMeta(im);
        inventory.setItem(slot, is);
    }
    private static void setBorderItem(Inventory inventory, int slot){
        ItemStack is = new ItemStack(Material.POLISHED_BLACKSTONE_SLAB);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName("§6Rand");
        im.setLocalizedName("border");
        im.setLore(Arrays.asList("Wähle einen neuen Grundstücksrand", " "));
        is.setItemMeta(im);
        inventory.setItem(slot, is);
    }
    private static void setWallItem(Inventory inventory, int slot){
        ItemStack is = new ItemStack(Material.STONE);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName("§2Wand");
        im.setLocalizedName("wall");
        im.setLore(Arrays.asList("Wechsel das Aussehen deiner Wände", " "));
        is.setItemMeta(im);
        inventory.setItem(slot, is);
    }
    /*private static void setEmptyItem(Inventory inventory, int slot){
        ItemStack is = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName("§eAushöhlen");
        im.setLocalizedName("empty");
        im.setLore(Arrays.asList("Leere dein Grundstück", " "));
        is.setItemMeta(im);
        inventory.setItem(slot, is);
    }
    private static void setManagePlotItem(Inventory inventory, int slot){
        ItemStack is = new ItemStack(Material.PAPER);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName("§3Gründstücke");
        im.setLocalizedName("plotmanager");
        im.setLore(Arrays.asList("Verwalte deine Grundstücke", ""));
        is.setItemMeta(im);
        inventory.setItem(slot, is);
    }
    private static void setMembersItem(Player p, Inventory inventory, int slot){
        ItemStack is = new ItemStack(Material.LEGACY_SKULL_ITEM, 1,(short) 3);
        SkullMeta im = (SkullMeta) is.getItemMeta();
        im.setOwner(p.getName());
        im.setDisplayName("§bMitglieder");
        im.setLocalizedName("members");
        im.setLore(Arrays.asList("Verwalte Spieler auf deinem Grundstück", ""));
        is.setItemMeta(im);
        inventory.setItem(slot, is);
    }*/
}
