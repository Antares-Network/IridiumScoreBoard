package org.piotrwyrw.iridiumscoreboard.global;

import org.piotrwyrw.iridiumscoreboard.IridiumScoreBoard;

public class Texts {
	public static String[] about = {
		"",
		"§b          IridiumScoreBoard",
		"§7  Running IridiumScoreBoard §cv" + IridiumScoreBoard.getInstance().getDescription().getVersion(),
		"§7       For help use §c/isb help",
		""
	};
	
	public static String[] help = {
		"",
		"§8o------------------------------------------------o",
		"§b/isb add §8- §eAdd a panel to the scoreboard §c(" + Permissions.COMMAND_ADD + ")",
		"§b/isb clear §8- §eRemove all panels from the scoreboard §c(" + Permissions.COMMAND_CLEAR + ")",
		"§b/isb save §8- §eSave all panels to a file §c(" + Permissions.COMMAND_SAVE + ")",
		"§b/isb start §8- §eStart the update timer §c(" + Permissions.COMMAND_START + ")",
		"§b/isb stop §8- §eStop the update timer §c(" + Permissions.COMMAND_STOP + ")",
		"§b/isb test §8- §eTest all panels §c(" + Permissions.COMMAND_TEST + ")",
		"§b/isb reload §8- §eReload the config §c(" + Permissions.COMMAND_RELOAD + ")",
		"§b/isb reset §8- §eReset the config §c(" + Permissions.COMMAND_RESET + ")",
		"§8o------------------------------------------------o"	
	};
	
	public static String[] enable = {
		"- - - - - - - - - - - - - - - -",
		"",
		"   Enabled IridiumScoreBoard",
		"",
		"- - - - - - - - - - - - - - - -"
	};
	
	public static String[] disable = {
		"- - - - - - - - - - - - - - - -",
		"",
		"  Disabled IridiumScoreBoard",
		"",
		"- - - - - - - - - - - - - - - -"
	};
}
