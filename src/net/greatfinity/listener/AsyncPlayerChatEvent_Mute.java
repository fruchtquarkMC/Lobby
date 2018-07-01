package net.greatfinity.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChatEvent_Mute implements Listener{

	public static boolean chat = true;
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		
		Player p = e.getPlayer();
		if(chat == false) {
				e.setCancelled(true);
				p.sendMessage("§aDer Chat ist in der Lobby deaktiviert! Bitte betrete einen SkyBlock-Server um schreiben zu können.");
				return;
			}

		
		
	}
}
