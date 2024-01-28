package play.mcdev.tv.betterplots.listener.manager;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import play.mcdev.tv.betterplots.util.manager.BorderManager;
import play.mcdev.tv.betterplots.util.manager.PlotMenuManager;
import play.mcdev.tv.betterplots.util.manager.WallManager;

public class WallMenuListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getCurrentItem() == null) return;
        if (e.getCurrentItem().getItemMeta() == null) return;
        if (e.getView().getTitle().equalsIgnoreCase(WallManager.wallguiname)) {
            if (e.getCurrentItem().getItemMeta().hasLocalizedName()) {
                e.setCancelled(true);
                switch (e.getCurrentItem().getItemMeta().getLocalizedName()) {
                    case "0":
                        WallManager.setWall(p, "0", Material.STONE);
                        break;
                    case "1":
                        WallManager.setWall(p, "1", Material.OAK_PLANKS);
                        break;
                    case "2":
                        WallManager.setWall(p, "2", Material.GLOWSTONE);
                        break;
                    case "3":
                        WallManager.setWall(p, "3", Material.SEA_LANTERN);
                        break;
                    case "4":
                        WallManager.setWall(p, "4", Material.SANDSTONE);
                        break;
                    case "5":
                        WallManager.setWall(p, "5", Material.DARK_OAK_PLANKS);
                        break;
                    case "6":
                        WallManager.setWall(p, "6", Material.QUARTZ_BLOCK);
                        break;
                    case "7":
                        WallManager.setWall(p, "7", Material.SMOOTH_QUARTZ);
                        break;
                    case "8":
                        WallManager.setWall(p, "8", Material.CHERRY_PLANKS);
                        break;
                    case "9":
                        WallManager.setWall(p, "9", Material.PRISMARINE);
                        break;
                    case "10":
                        WallManager.setWall(p, "10", Material.DARK_PRISMARINE);
                        break;
                    case "11":
                        WallManager.setWall(p, "11", Material.AMETHYST_BLOCK);
                        break;
                    case "12":
                        WallManager.setWall(p, "12", Material.GOLD_BLOCK);
                        break;
                    case "13":
                        WallManager.setWall(p, "13", Material.DEEPSLATE_TILES);
                        break;
                    case "14":
                        WallManager.setWall(p, "14", Material.PURPUR_BLOCK);
                        break;
                    case "15":
                        WallManager.setWall(p, "15", Material.DIAMOND_BLOCK);
                        break;
                    case "16":
                        WallManager.setWall(p, "16", Material.TUFF);
                        break;
                    case "17":
                        WallManager.setWall(p, "17", Material.SHROOMLIGHT);
                        break;
                    case "18":
                        WallManager.setWall(p, "18", Material.NETHERITE_BLOCK);
                        break;
                    case "19":
                        WallManager.setWall(p, "19", Material.BEDROCK);
                        break;
                    case "20":
                        WallManager.setWall(p, "20", Material.CALCITE);
                        break;
                    case "back":
                        PlotMenuManager.openPlotMenu(p);
                        break;
                }
            }
        }
    }
}
