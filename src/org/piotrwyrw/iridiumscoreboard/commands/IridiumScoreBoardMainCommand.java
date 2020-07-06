package org.piotrwyrw.iridiumscoreboard.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.piotrwyrw.iridiumscoreboard.commands.help.HelpPage;

public class IridiumScoreBoardMainCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {	
		
		if (args.length == 0) {
			HelpPage.show(sender);
			return true;
		}
		
		switch (args[0]) {
		case "add":
			return new AddCommand().handleCommand(sender, args);
		case "clear":
			return new ClearCommand().handleCommand(sender, args);
		case "save":
			return new SaveCommand().handleCommand(sender, args);
		case "start":
			return new StartCommand().handleCommand(sender, args);
		case "stop":
			return new StopCommand().handleCommand(sender, args);
		case "test":
			return new TestPanelCommand().handleCommand(sender, args);
		case "reload":
			return new ReloadCommand().handleCommand(sender, args);
		default:
			HelpPage.show(sender);
			return true;
		}
	}

}
