package org.piotrwyrw.iridiumscoreboard.commands.help;

import org.bukkit.command.CommandSender;
import org.piotrwyrw.iridiumscoreboard.globals.Permissions;

public class HelpPage {
	
	static String[] helpPage = {
			"",
			"§8o------------------------------------------------o",
			"§b/isb add §8- §eAdd a panel to the scoreboard §c(" + Permissions.ADD_SCORE_PANEL + ")",
			"§b/isb clear §8- §eRemove all panels from the scoreboard §c(" + Permissions.REMALL_SCORE_PANELS + ")",
			"§b/isb save §8- §eSave all panels to a file §c(" + Permissions.SAVE_SCORE_PANELS + ")",
			"§b/isb start §8- §eStart the update timer §c(" + Permissions.START_UPDATE + ")",
			"§b/isb stop §8- §eStop the update timer §c(" + Permissions.STOP_UPDATE + ")",
			"§b/isb test §8- §eTest all panels §c(" + Permissions.TEST_SCORE_PANELS + ")",
			"§b/isb reload §8- §eReload the config §c(" + Permissions.RELOAD_ISB + ")",
			"§b/isb reset §8- §eReset the config §c(" + Permissions.RESET_CONFIG + ")",
			"§8o------------------------------------------------o",
	};
	
	public static void show(CommandSender sender) {
		for (String line : helpPage)
			sender.sendMessage(line);
	}
}
