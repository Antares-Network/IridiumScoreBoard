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
import org.piotrwyrw.iridiumscoreboard.global.Messages;
import org.piotrwyrw.iridiumscoreboard.global.Permissions;
import org.piotrwyrw.iridiumscoreboard.scoreboard.ScorePanel;
import org.piotrwyrw.iridiumscoreboard.util.Utilities;

import com.iridium.iridiumskyblock.Island;
import com.iridium.iridiumskyblock.Utils;

public class AddCommand extends CommandHandler {
	
	@Override
	public boolean handleCommand(CommandSender sender, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Messages.CONSOLE_NOT_ALLOWED);
			return false;
		}
		
		if (!Utilities.hasPermission(sender, Permissions.COMMAND_ADD)) {
			sender.sendMessage(Messages.NO_PERMISSION);
			return false;
		}
		
		if (args.length != 1) {
			sender.sendMessage(Messages.EXPECTED_ARGUMENTS(0));
			return false;
		}
		
		Block selected = Utilities.trackSelection((Player)(sender));
		
		if (!(selected.getState() instanceof Sign)) {
			sender.sendMessage(Messages.NOT_A_SIGN);
			return false;
		}
		
		// TODO Add sign to score list
		List<Island> islands = Utils.getTopIslands();
		ScorePanel sp = new ScorePanel(Utilities.trackSelection(((Player)sender)).getLocation());
		IridiumScoreBoard.getScoreBoard().addPanel(sp);
		
		sender.sendMessage(Messages.ADD_PANEL);
		return true;
	}
}
