package net.greatfinity.lobby;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import net.greatfinity.listener.AsyncPlayerChatEvent_Mute;
import net.greatfinity.listener.ScoreboardJoinListener;
import net.greatfinity.net.command.Command_Mute;

public class Main  extends JavaPlugin implements Listener{
	
	PluginManager pm = Bukkit.getPluginManager();

	@Override
	public void onEnable() {
		loadCommands();
		loadListener();
		this.getServer().getPluginManager().registerEvents(this, this);
		System.out.println("Das Lobby-Plugin wurde aktiviert.");
	}
	 @Override
	 public void onDisable() {
		 System.out.println("Bis dann.");
	 }
	 
	 private void loadCommands() {
		 getCommand("mute").setExecutor(new Command_Mute());
	 }
	 
	 private void loadListener() {
		 pm.registerEvents(new AsyncPlayerChatEvent_Mute(), this);
		 pm.registerEvents(new ScoreboardJoinListener(), this);
	 }
	 
 @EventHandler
	 public void onJoin(PlayerJoinEvent e) {
		 Player p = e.getPlayer();
		 if(p.isOp()) {
			 e.setJoinMessage("§c" + p.getName() + " §6hat die Lobby betreten.");
		 } else {
			 e.setJoinMessage("§a" + p.getName() + " §7hat die Lobby betreten.");
		 }
	 }
		 public void onLeave(PlayerQuitEvent e) {
			 Player p = e.getPlayer();
			 if(p.isOp()) {
				 e.setQuitMessage("§c" + p.getName() + " §6hat die Lobby verlassen.");
			 } else {
				 e.setQuitMessage("§a" + p.getName() + " §7hat die Lobby verlassen.");
			 }
		 
	 }
		 
		 @EventHandler
			public void onDamage(EntityDamageEvent e){
				if(!(e.getEntity() instanceof Player)){
					return;
				}else{
					if(e.getCause().equals(DamageCause.FALL)){
						e.setCancelled(true);
					}
				}
		 }
}
