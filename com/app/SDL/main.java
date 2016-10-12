package com.app.SDL;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	// Fired when plugin is first enabled
	static private main instance;
	@Override
	public void onEnable() {
		instance = this;
		getLogger().info("怪磚掉落物限制插件已啟用...");
		//register our command "kit" (set on instance of your command class as executor
		//register our Event API with Listener
		PluginManager pluginManager = this.getServer().getPluginManager();
		pluginManager.registerEvents(new PluginListener(),this);
	}
	// Fired when plugin is first disabled
	@Override
	public void onDisable( ) {
		getLogger().info("怪磚掉落物限制插件已關閉...");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("Hello") && sender instanceof Player ) {
			Player player = (Player) sender;
			player.sendMessage(ChatColor.GREEN + "Hello, " + ChatColor.YELLOW + player.getName() + "!");
			return false;
			
		}
		return false;
	}
	
	public static main getInstance(){
		return instance;
	}
}
