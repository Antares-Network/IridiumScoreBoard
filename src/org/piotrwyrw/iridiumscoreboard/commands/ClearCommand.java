package org.piotrwyrw.iridiumscoreboard.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.piotrwyrw.iridiumscoreboard.Main;
import org.piotrwyrw.iridiumscoreboard.Messages;
import org.piotrwyrw.iridiumscoreboard.Permissions;

public class ClearCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!sender.hasPermission(Permissions.REMALL_SCORE_PANELS)) {
			sender.sendMessage(Messages.NO_PERMISSION);
			return false;
		}
		
		if (args.length != 0) {
			sender.sendMessage(Messages.EXPECTED_ARGUMENTS(0));
			return false;
		}
		
		Main.getScoreBoard().removeAllPanels();
		Main.getScoreBoard().write(true);
		sender.sendMessage(Messages.REMALL_DONE);
		return true;
	}
	
}
