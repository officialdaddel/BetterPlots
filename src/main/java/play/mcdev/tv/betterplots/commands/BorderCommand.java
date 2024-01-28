package play.mcdev.tv.betterplots.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import play.mcdev.tv.betterplots.util.Utilities;

import static play.mcdev.tv.betterplots.util.Utilities.*;

public class BorderCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            p.sendMessage(prefix + "§cBenutze: /plotmanager");
        }else {
            Utilities.consoleError(sender);
        }
        return false;
    }
}
