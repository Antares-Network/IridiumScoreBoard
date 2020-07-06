package org.piotrwyrw.iridiumscoreboard.commands;

import org.bukkit.command.CommandSender;
import org.piotrwyrw.iridiumscoreboard.IridiumScoreBoard;
import org.piotrwyrw.iridiumscoreboard.globals.Messages;
import org.piotrwyrw.iridiumscoreboard.globals.Permissions;

public class ClearCommand extends CommandHandler {
	
	@Override
	public boolean handleCommand(CommandSender sender, String[] args) {
		if (!sender.hasPermission(Permissions.REMALL_SCORE_PANELS)) {
			sender.sendMessage(Messages.NO_PERMISSION);
			return false;
		}
		
		if (args.length != 1) {
			sender.sendMessage(Messages.EXPECTED_ARGUMENTS(0));
			return false;
		}
		
		IridiumScoreBoard.getScoreBoard().removeAllPanels();
		IridiumScoreBoard.getScoreBoard().write(true);
		sender.sendMessage(Messages.REMALL_DONE);
		return true;
	}
	
}
