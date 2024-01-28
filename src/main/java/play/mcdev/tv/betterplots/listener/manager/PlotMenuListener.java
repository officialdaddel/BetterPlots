package play.mcdev.tv.betterplots.listener.manager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import play.mcdev.tv.betterplots.util.manager.*;
import play.mcdev.tv.betterplots.util.Utilities;

public class PlotMenuListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(e.getCurrentItem() == null) return;
        if(e.getCurrentItem().getItemMeta() == null) return;
        if(e.getView().getTitle().equalsIgnoreCase(PlotMenuManager.guiname)){
            if(e.getCurrentItem().getItemMeta().hasLocalizedName()){
                e.setCancelled(true);
                switch (e.getCurrentItem().getItemMeta().getLocalizedName()){
                    case "border":
                        BorderManager.openBorderMenu(p);
                        break;
                    case "wall":
                        WallManager.openWallMenu(p);
                        break;
                }
            }
        }
    }
}
