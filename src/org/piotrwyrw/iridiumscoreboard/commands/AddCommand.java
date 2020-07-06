package org.piotrwyrw.iridiumscoreboard.commands;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.piotrwyrw.iridiumscoreboard.IridiumScoreBoard;
import org.piotrwyrw.iridiumscoreboard.globals.Messages;
import org.piotrwyrw.iridiumscoreboard.globals.Permissions;
import org.piotrwyrw.iridiumscoreboard.scoreboard.ScorePanel;
import org.piotrwyrw.iridiumscoreboard.util.SelectionTracker;

import com.iridium.iridiumskyblock.Island;
import com.iridium.iridiumskyblock.Utils;

public class AddCommand extends CommandHandler {
	
	@Override
	public boolean handleCommand(CommandSender sender, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Messages.NO_CONSOLE);
			return false;
		}
		
		if (!sender.hasPermission(Permissions.ADD_SCORE_PANEL)) {
			sender.sendMessage(Messages.NO_PERMISSION);
			return false;
		}
		
		if (args.length != 1) {
			sender.sendMessage(Messages.EXPECTED_ARGUMENTS(0));
			return false;
		}
		
		Block selected = SelectionTracker.track((Player)(sender));
		
		if (!(selected.getState() instanceof Sign)) {
			sender.sendMessage(Messages.NOT_SIGN);
			return false;
		}
		
		// TODO Add sign to score list
		List<Island> islands = Utils.getTopIslands();
		ScorePanel sp = new ScorePanel(SelectionTracker.track(((Player)sender)).getLocation());
		IridiumScoreBoard.getScoreBoard().addPanel(sp);
		
		sender.sendMessage(Messages.PANEL_ADDED);
		return true;
	}
}