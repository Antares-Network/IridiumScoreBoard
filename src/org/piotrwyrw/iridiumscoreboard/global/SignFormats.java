package org.piotrwyrw.iridiumscoreboard.global;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SignFormats {
	public static List<String> sign_format = new ArrayList<String>(Arrays.asList(
			"",
			"§6§l#{NUMBER}",
			"§7{PLAYER}",
			"§c{VALUE}"));
	public static List<String> test = new ArrayList<String>(Arrays.asList(
			"§8" + SpecialCharacters.LAQUO + "§1§lTEST" + "§8" + SpecialCharacters.RAQUO,
			"§8" + SpecialCharacters.LAQUO + "§2§lTEST" + "§8" + SpecialCharacters.RAQUO,
			"§8" + SpecialCharacters.LAQUO + "§3§lTEST" + "§8" + SpecialCharacters.RAQUO,
			"§8" + SpecialCharacters.LAQUO + "§4§lTEST" + "§8" + SpecialCharacters.RAQUO));
	public static List<String> empty = new ArrayList<String>(Arrays.asList(
			"",
			"",
			"",
			""));
}
