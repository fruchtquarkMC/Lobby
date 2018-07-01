package net.greatfinity.net.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.greatfinity.listener.AsyncPlayerChatEvent_Mute;

public class Command_Mute implements CommandExecutor{


	@Override
	public boolean onCommand(CommandSender cs, Command arg1, String arg2, String[] args) {
		if(!(cs instanceof Player)) return true;
		
		Player p = (Player)cs;
		
		if(!p.isOp()) {
			p.sendMessage("§cDazu fehlen dir leider die Rechte!");
			if(args.length == 0) {
				
				if(AsyncPlayerChatEvent_Mute.chat == true)
				Bukkit.broadcastMessage("§cDer Chat wurde deaktiviert!");
				AsyncPlayerChatEvent_Mute.chat = false;
			} else {
				Bukkit.broadcastMessage("§aDer Chat wurde aktiviert!");
				AsyncPlayerChatEvent_Mute.chat = true;
			}
			
			return false;
		}
		return false;
	}
	}
	