package org.piotrwyrw.iridiumscoreboard.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.piotrwyrw.iridiumscoreboard.Main;
import org.piotrwyrw.iridiumscoreboard.Messages;
import org.piotrwyrw.iridiumscoreboard.Permissions;

public class StartCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!sender.hasPermission(Permissions.START_UPDATE)) {
			sender.sendMessage(Messages.NO_PERMISSION);
			return false;
		}
		
		if (args.length != 0) {
			sender.sendMessage(Messages.EXPECTED_ARGUMENTS(0));
			return false;
		}
		
		Main.startUpdater();
		sender.sendMessage(Messages.TASK_START);
		return true;
	}
	
}
