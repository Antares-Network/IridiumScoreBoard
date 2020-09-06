package org.piotrwyrw.iridiumscoreboard.commands;

import org.bukkit.command.CommandSender;
import org.piotrwyrw.iridiumscoreboard.IridiumScoreBoard;
import org.piotrwyrw.iridiumscoreboard.config.Configuration;
import org.piotrwyrw.iridiumscoreboard.global.Messages;
import org.piotrwyrw.iridiumscoreboard.global.Permissions;
import org.piotrwyrw.iridiumscoreboard.scoreboard.ScoreUpdater;
import org.piotrwyrw.iridiumscoreboard.util.Utilities;

public class ReloadCommand extends CommandHandler {

	@Override
	public boolean handleCommand(CommandSender sender, String[] args) {
		if (!Utilities.hasPermission(sender, Permissions.COMMAND_RELOAD)) {
			sender.sendMessage(Messages.NO_PERMISSION);
			return false;
		}
		
		if (args.length != 1) {
			sender.sendMessage(Messages.EXPECTED_ARGUMENTS(0));
			return false;
		}
		
		IridiumScoreBoard.getInstance().reloadConfig();
		Configuration.readConfig();
		ScoreUpdater updater = new ScoreUpdater(IridiumScoreBoard.getScoreBoard());
		updater.run();
		sender.sendMessage(Messages.RELOAD_COMPLETE);
		return true;
	}

}
