package com.app.SDL;
import java.util.Random;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class PluginListener implements Listener
{   
	main plugin;
	
	public PluginListener(){
		plugin = main.getInstance();
	}
    
    // Executes before the second method because it has a much lower priority.
    @EventHandler
    public void onSpawnerSpawn(SpawnerSpawnEvent event)
    {
    	Entity spawnEntity = event.getEntity();
    	// void setMetadata(String metadataKey, MetadataValue newMetadataValue)
    	spawnEntity.setMetadata("isSpawner", 
    			new FixedMetadataValue(plugin, true ));
    }
    
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event){
    	//Entity spawnEntity = event.getEntity();
    	if(new Random().nextDouble() < 0.2){
    		event.getDrops().clear();
    	}
    	event.setDroppedExp(event.getDroppedExp() / 5 );
    }
}
