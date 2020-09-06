package org.piotrwyrw.iridiumscoreboard.commands;

import org.bukkit.command.CommandSender;
import org.piotrwyrw.iridiumscoreboard.IridiumScoreBoard;
import org.piotrwyrw.iridiumscoreboard.global.Messages;
import org.piotrwyrw.iridiumscoreboard.global.Permissions;
import org.piotrwyrw.iridiumscoreboard.util.Utilities;

public class ClearCommand extends CommandHandler {
	
	@Override
	public boolean handleCommand(CommandSender sender, String[] args) {
		if (!Utilities.hasPermission(sender, Permissions.COMMAND_CLEAR)) {
			sender.sendMessage(Messages.NO_PERMISSION);
			return false;
		}
		
		if (args.length != 1) {
			sender.sendMessage(Messages.EXPECTED_ARGUMENTS(0));
			return false;
		}
		
		IridiumScoreBoard.getScoreBoard().removeAllPanels();
		IridiumScoreBoard.getScoreBoard().write(true);
		sender.sendMessage(Messages.CLEAR_PANELS);
		return true;
	}
	
}
