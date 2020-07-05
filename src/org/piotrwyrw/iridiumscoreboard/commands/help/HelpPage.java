package org.piotrwyrw.iridiumscoreboard.commands.help;

import org.bukkit.command.CommandSender;

public class HelpPage {
	
	static String[] helpPage = {
			"§8-----------------------------------------------------",
			"§b/isb add §8- §eAdd a panel to the scoreboard §c(isb.add)",
			"§b/isb clear §8- §eRemove all panels from the scoreboard §c(isb.clear)",
			"§b/isb save §8- §eSave all panels to a file §c(isb.save)",
			"§b/isb start §8- §eStart the update timer §c(isb.start)",
			"§b/isb stop §8- §eStop the update timer §c(isb.stop)",
			"§b/isb test §8- §eTest all panels §c(isb.test)",
			"§8-----------------------------------------------------"
	};
	
	public static void show(CommandSender sender) {
		for (String line : helpPage)
			sender.sendMessage(line);
	}
}
