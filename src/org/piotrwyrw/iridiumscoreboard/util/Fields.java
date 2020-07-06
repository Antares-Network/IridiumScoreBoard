package org.piotrwyrw.iridiumscoreboard.util;

import com.iridium.iridiumskyblock.Island;

public class Fields {
	public static String islandFields(String str, String owner, int top, Island island) {
		String out = str;
		out = out.replaceAll("\\%PLAYER\\%", owner);
		out = out.replaceAll("\\%NUMBER\\%", String.valueOf(top));
		out = out.replaceAll("\\%VALUE\\%", String.valueOf(island.getValue()));
		out = out.replaceAll("\\%MEMBERS\\%", String.valueOf(island.getMembers().size()));
		out = out.replaceAll("\\%NAME\\%", island.getName());
		out = out.replaceAll("\\%ID\\%", String.valueOf(island.getId()));
		out = out.replaceAll("\\%ONISLAND\\%", String.valueOf(island.getPlayersOnIsland().size()));
		return out;
	}
	
	public static String specialCharacterFields(String str) {
		String out = str;
		out = out.replaceAll("\\%LAQUO\\%", "«");
		out = out.replaceAll("\\%RAQUO\\%", "»");
		out = out.replaceAll("\\%REG\\%", "®");
		out = out.replaceAll("\\%COPY\\%", "©");
		out = out.replaceAll("\\%PARAGRAPH\\%", "§");
		out = out.replaceAll("\\%APOSTROPHE\\%", "'");
		out = out.replaceAll("\\&", "§");
		return out;
	}
	
}
