package play.mcdev.tv.betterplots.listener.manager;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import play.mcdev.tv.betterplots.util.manager.BorderManager;
import play.mcdev.tv.betterplots.util.manager.PlotMenuManager;

public class BorderMenuListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getCurrentItem() == null) return;
        if (e.getCurrentItem().getItemMeta() == null) return;
        if (e.getView().getTitle().equalsIgnoreCase(BorderManager.borderguiname)) {
            if (e.getCurrentItem().getItemMeta().hasLocalizedName()) {
                e.setCancelled(true);
                switch (e.getCurrentItem().getItemMeta().getLocalizedName()) {
                    case "0":
                        BorderManager.setBorder(p, "0", Material.POLISHED_BLACKSTONE_SLAB);
                        break;
                    case "1":
                        BorderManager.setBorder(p, "1", Material.AIR);
                        break;
                    case "2":
                        BorderManager.setBorder(p, "2", Material.OAK_SLAB);
                        break;
                    case "3":
                        BorderManager.setBorder(p, "3", Material.SANDSTONE_SLAB);
                        break;
                    case "4":
                        BorderManager.setBorder(p, "4", Material.SANDSTONE);
                        break;
                    case "5":
                        BorderManager.setBorder(p, "5", Material.RAIL);
                        break;
                    case "6":
                        BorderManager.setBorder(p, "6", Material.SOUL_TORCH);
                        break;
                    case "7":
                        BorderManager.setBorder(p, "7", Material.NETHER_BRICK_SLAB);
                        break;
                    case "8":
                        BorderManager.setBorder(p, "8", Material.OAK_FENCE);
                        break;
                    case "9":
                        BorderManager.setBorder(p, "9", Material.QUARTZ_SLAB);
                        break;
                    case "10":
                        BorderManager.setBorder(p, "10", Material.QUARTZ_BLOCK);
                        break;
                    case "11":
                        BorderManager.setBorder(p, "12", Material.POLISHED_BLACKSTONE_WALL);
                        break;
                    case "12":
                        BorderManager.setBorder(p, "13", Material.GOLD_BLOCK);
                        break;
                    case "13":
                        BorderManager.setBorder(p, "14", Material.BAMBOO_FENCE);
                        break;
                    case "14":
                        BorderManager.setBorder(p, "15", Material.PURPLE_WOOL);
                        break;
                    case "15":
                        BorderManager.setBorder(p, "16", Material.DIAMOND_BLOCK);
                        break;
                    case "16":
                        BorderManager.setBorder(p, "17", Material.BEACON);
                        break;
                    case "17":
                        BorderManager.setBorder(p, "18", Material.DEEPSLATE_BRICK_SLAB);
                        break;
                    case "18":
                        BorderManager.setBorder(p, "19", Material.NETHERITE_BLOCK);
                        break;
                    case "19":
                        BorderManager.setBorder(p, "20", Material.BEDROCK);
                        break;
                    case "20":
                        BorderManager.setBorder(p, "21", Material.END_PORTAL_FRAME);
                        break;
                    case "back":
                        PlotMenuManager.openPlotMenu(p);
                        break;
                }
            }
        }
    }
}
