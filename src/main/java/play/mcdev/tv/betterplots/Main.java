package play.mcdev.tv.betterplots;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import play.mcdev.tv.betterplots.commands.BorderCommand;
import play.mcdev.tv.betterplots.commands.PlotManagerCommand;
import play.mcdev.tv.betterplots.commands.WallCommand;
import play.mcdev.tv.betterplots.listener.manager.BorderMenuListener;
import play.mcdev.tv.betterplots.listener.manager.PlotMenuListener;
import play.mcdev.tv.betterplots.listener.manager.WallMenuListener;

import static play.mcdev.tv.betterplots.util.Utilities.version;

public final class Main extends JavaPlugin {
    public static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getLogger().info("BetterPlots " + version + " enabled");

        getCommand("plotmanager").setExecutor(new PlotManagerCommand());
        getCommand("border").setExecutor(new BorderCommand());
        getCommand("wall").setExecutor(new WallCommand());

        PluginManager plm = Bukkit.getPluginManager();
        plm.registerEvents(new PlotMenuListener(), this);
        plm.registerEvents(new BorderMenuListener(), this);
        plm.registerEvents(new WallMenuListener(), this);


    }

    @Override
    public void onDisable() {
        getLogger().info("BetterPlots " + version + " disabled");
    }

    public static Main getPlugin() {
        return plugin;
    }
}
