package play.mcdev.tv.betterplots.util;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import play.mcdev.tv.betterplots.Main;

public class Utilities {
    public static String version = "v" + Main.getPlugin().getDescription().getVersion() + "-mc" + Main.getPlugin().getDescription().getAPIVersion();
    public static String prefix = "§2BetterPlots §8» §7";
    public static String perms = "betterplots.";
    public static String x = perms + "*";
    public static void noperm(Player p){
        p.sendMessage(prefix + "§4Dazu hast du keine Rechte!");
        p.closeInventory();
    }
    public static void consoleError(CommandSender sender){
        sender.sendMessage("Die Console darf diesen Command nicht ausführen!");
    }
    public static void commingSoon(Player p){
        p.sendMessage(prefix + "§bBald verfügbar!");
    }
    public static void notYourPlot(Player p){
        p.sendMessage(prefix + "§cDieses Grundstück gehört nicht dir!");
    }
    public static void notOnPlot(Player p){
        p.sendMessage(prefix + "§cDu befindest dich auf keinem Grundstück!");
    }
}
