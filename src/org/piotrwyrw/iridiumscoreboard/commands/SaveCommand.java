package org.piotrwyrw.iridiumscoreboard.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.piotrwyrw.iridiumscoreboard.IridiumScoreBoard;
import org.piotrwyrw.iridiumscoreboard.globals.Messages;
import org.piotrwyrw.iridiumscoreboard.globals.Permissions;

public class SaveCommand extends CommandHandler {

	@Override
	public boolean handleCommand(CommandSender sender, String[] args) {
		if (!sender.hasPermission(Permissions.SAVE_SCORE_PANELS)) {
			sender.sendMessage(Messages.NO_PERMISSION);
			return false;
		}
		
		if (args.length != 1) {
			sender.sendMessage(Messages.EXPECTED_ARGUMENTS(0));
			return false;
		}
		
		IridiumScoreBoard.getScoreBoard().write(false);
		sender.sendMessage(Messages.SAVED);
		return true;
	}
	
}
