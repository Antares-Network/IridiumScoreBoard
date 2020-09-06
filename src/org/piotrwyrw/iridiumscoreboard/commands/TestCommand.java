package org.piotrwyrw.iridiumscoreboard.commands;

import java.util.List;

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

public class TestCommand extends CommandHandler {

	@Override
	public boolean handleCommand(CommandSender sender, String[] args) {
		if (!Utilities.hasPermission(sender, Permissions.COMMAND_TEST)) {
			sender.sendMessage(Messages.NO_PERMISSION);
			return false;
		}
		
		if (args.length != 1) {
			sender.sendMessage(Messages.EXPECTED_ARGUMENTS(0));
			return false;
		}
		
		IridiumScoreBoard.getScoreBoard().test(sender);
		sender.sendMessage(Messages.DONE_TESTING);
		return true;
	}
	
}
