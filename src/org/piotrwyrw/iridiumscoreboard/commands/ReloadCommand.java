package org.piotrwyrw.iridiumscoreboard.commands;

import org.bukkit.command.CommandSender;
import org.piotrwyrw.iridiumscoreboard.IridiumScoreBoard;
import org.piotrwyrw.iridiumscoreboard.config.Configuration;
import org.piotrwyrw.iridiumscoreboard.global.Messages;
import org.piotrwyrw.iridiumscoreboard.global.Permissions;
import org.piotrwyrw.iridiumscoreboard.scoreboard.ScoreUpdater;

public class ReloadCommand extends CommandHandler {

	@Override
	public boolean handleCommand(CommandSender sender, String[] args) {
		if (!sender.hasPermission(Permissions.COMMAND_RELOAD)) {
			sender.sendMessage(Messages.NO_PERMISSION);
			return false;
		}
		
		if (args.length != 1) {
			sender.sendMessage(Messages.EXPECTED_ARGUMENTS(0));
			return false;
		}
		
		sender.sendMessage(Messages.RELOADING);
		IridiumScoreBoard.getInstance().reloadConfig();
		Configuration.readConfig();
		ScoreUpdater updater = new ScoreUpdater(IridiumScoreBoard.getScoreBoard());
		updater.run();
		sender.sendMessage(Messages.RELOAD_COMPLETE);
		return true;
	}

}
