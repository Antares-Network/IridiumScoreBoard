package org.piotrwyrw.iridiumscoreboard.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.piotrwyrw.iridiumscoreboard.IridiumScoreBoard;
import org.piotrwyrw.iridiumscoreboard.global.Messages;
import org.piotrwyrw.iridiumscoreboard.global.Permissions;
import org.piotrwyrw.iridiumscoreboard.util.Utilities;

public class StartCommand extends CommandHandler {

	@Override
	public boolean handleCommand(CommandSender sender, String[] args) {
		if (!Utilities.hasPermission(sender, Permissions.COMMAND_START)) {
			sender.sendMessage(Messages.NO_PERMISSION);
			return false;
		}
		
		if (args.length != 1) {
			sender.sendMessage(Messages.EXPECTED_ARGUMENTS(0));
			return false;
		}
		
		IridiumScoreBoard.startUpdater();
		sender.sendMessage(Messages.START_TASK);
		return true;
	}
	
}
