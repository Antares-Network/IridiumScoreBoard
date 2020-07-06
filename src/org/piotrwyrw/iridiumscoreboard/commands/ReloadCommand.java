package org.piotrwyrw.iridiumscoreboard.commands;

import org.bukkit.command.CommandSender;
import org.piotrwyrw.iridiumscoreboard.IridiumScoreBoard;
import org.piotrwyrw.iridiumscoreboard.config.IridiumScoreBoardConfiguration;
import org.piotrwyrw.iridiumscoreboard.globals.Messages;
import org.piotrwyrw.iridiumscoreboard.globals.Permissions;
import org.piotrwyrw.iridiumscoreboard.scoreboard.ScoreUpdater;

public class ReloadCommand extends CommandHandler {

	@Override
	public boolean handleCommand(CommandSender sender, String[] args) {
		if (!sender.hasPermission(Permissions.RELOAD_ISB)) {
			sender.sendMessage(Messages.NO_PERMISSION);
			return false;
		}
		
		if (args.length != 1) {
			sender.sendMessage(Messages.EXPECTED_ARGUMENTS(0));
			return false;
		}
		
		sender.sendMessage(Messages.CONF_RELOADING);
		IridiumScoreBoard.getInstance().reloadConfig();
		IridiumScoreBoardConfiguration isbc = new IridiumScoreBoardConfiguration();
		ScoreUpdater updater = new ScoreUpdater(IridiumScoreBoard.getScoreBoard());
		updater.run();
		sender.sendMessage(Messages.CONF_RELOAD);
		return true;
	}

}
