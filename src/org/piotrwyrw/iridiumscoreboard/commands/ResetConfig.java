package org.piotrwyrw.iridiumscoreboard.commands;

import org.bukkit.command.CommandSender;
import org.piotrwyrw.iridiumscoreboard.IridiumScoreBoard;
import org.piotrwyrw.iridiumscoreboard.config.IridiumScoreBoardConfiguration;
import org.piotrwyrw.iridiumscoreboard.globals.Messages;
import org.piotrwyrw.iridiumscoreboard.globals.Permissions;
import org.piotrwyrw.iridiumscoreboard.scoreboard.ScoreUpdater;

public class ResetConfig extends CommandHandler {

	@Override
	public boolean handleCommand(CommandSender sender, String[] args) {
		if (!sender.hasPermission(Permissions.RESET_CONFIG)) {
			sender.sendMessage(Messages.NO_PERMISSION);
			return false;
		}
		
		if (args.length != 1) {
			sender.sendMessage(Messages.EXPECTED_ARGUMENTS(0));
			return false;
		}
		
		sender.sendMessage(Messages.RESETTING_CONF);
		IridiumScoreBoard.getInstance().saveResource("config.yml", true);
		sender.sendMessage(Messages.RESET_DONE);
		return true;
	}

}
