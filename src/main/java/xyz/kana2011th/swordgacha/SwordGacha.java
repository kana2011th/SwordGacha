package xyz.kana2011th.swordgacha;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SwordGacha extends JavaPlugin {

    public static SwordGacha instance;

    @Override
    public void onEnable() {
        // Plugin startup logic

        // make plugin so public to other class ._.
        instance = this;

        // core of plugin that are event based
        this.getServer().getPluginManager().registerEvents(new Listener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        // make it null before shutdown.
        instance = null;
    }
}
