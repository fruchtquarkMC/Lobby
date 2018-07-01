package net.greatfinity.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardJoinListener implements Listener{

	@EventHandler
	public void handlePlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = board.registerNewObjective("hallo", "du");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName("§6greatfinity");
		obj.getScore(" ").setScore(6);
		obj.getScore("§fDein Name:").setScore(5);
		obj.getScore("§6§l" + p.getName()).setScore(4);
		obj.getScore(" ").setScore(3);
		obj.getScore("§fServer:").setScore(2);
		obj.getScore("§6§lHub-1").setScore(1);
		
		p.setScoreboard(board);
	}
}
