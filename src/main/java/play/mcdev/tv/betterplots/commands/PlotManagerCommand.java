package play.mcdev.tv.betterplots.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import play.mcdev.tv.betterplots.util.manager.PlotMenuManager;
import play.mcdev.tv.betterplots.util.Utilities;

import static play.mcdev.tv.betterplots.util.Utilities.perms;

public class PlotManagerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission(perms + "open")){
                PlotMenuManager.openPlotMenu(p);
            }else {
                Utilities.noperm(p);
            }
        }else {
            Utilities.consoleError(sender);
        }
        return false;
    }
}
