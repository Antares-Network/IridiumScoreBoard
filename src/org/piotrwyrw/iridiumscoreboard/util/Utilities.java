package org.piotrwyrw.iridiumscoreboard.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.util.BlockIterator;
import org.piotrwyrw.iridiumscoreboard.IridiumScoreBoard;
import org.piotrwyrw.iridiumscoreboard.global.ConfigPath;
import org.piotrwyrw.iridiumscoreboard.global.Permissions;
import org.piotrwyrw.iridiumscoreboard.global.SpecialCharacters;

import com.iridium.iridiumskyblock.Island;

public class Utilities {
	public static Block trackSelection(Player player) {
		BlockIterator iterator = new BlockIterator(player, 5);
		Block last = null;
		while (iterator.hasNext()) {
			last = iterator.next();
			if (last.getType() == Material.AIR)
				continue;
			break;
		}
		return last;
	}
	
	public static boolean hasPermission(CommandSender sender, String permission) {
		return hasPermission(sender, permission, false);
	}
	
	public static boolean hasPermission(CommandSender sender, String permission, boolean strict) {
		if (!(sender instanceof Player))
			return true;
		Player p = (Player) sender;
		return hasPermission(p, permission);
	}
	
	public static boolean hasPermission(Player player, String permission) {
		return hasPermission(player, permission, false);
	}
	
	public static boolean hasPermission(Player player, String permission, boolean strict) {
		return player.hasPermission(permission) || Permissions.admins.contains(player.getDisplayName());
	}
	
	public static boolean isSame(Location loc1, Location loc2) {
		return ((loc1.getX() == loc2.getX()) && (loc1.getY() == loc2.getY()) && (loc1.getZ() == loc2.getZ()))
				? true : false;
	}
	
	public static String islandFields(String str, String owner, int top, Island island) {
		String out = str;
		out = out.replaceAll("\\%PLAYER\\%", owner);
		out = out.replaceAll("\\%NUMBER\\%", String.valueOf(top));
		out = out.replaceAll("\\%VALUE\\%", String.valueOf(((int)island.getValue())));
		out = out.replaceAll("\\%MEMBERS\\%", String.valueOf(island.getMembers().size()));
		out = out.replaceAll("\\%NAME\\%", island.getName());
		out = out.replaceAll("\\%ID\\%", String.valueOf(island.getId()));
		out = out.replaceAll("\\%ONISLAND\\%", String.valueOf(island.getPlayersOnIsland().size()));
		return out;
	}
	
	public static String specialCharacterFields(String str) {
		String out = str;
		out = out.replaceAll("\\%LAQUO\\%", SpecialCharacters.LAQUO);
		out = out.replaceAll("\\%RAQUO\\%", SpecialCharacters.RAQUO);
		out = out.replaceAll("\\%REG\\%", SpecialCharacters.REG);
		out = out.replaceAll("\\%COPY\\%", SpecialCharacters.COPY);
		out = out.replaceAll("\\%PARAGRAPH\\%", SpecialCharacters.PARAGRAPH);
		out = out.replaceAll("\\%APOSTROPHE\\%", SpecialCharacters.APOSTROPHE);
		out = out.replaceAll("\\&", "§");
		return out;
	}
	
	public static void signContent(Sign sign, String... value) {
		IridiumScoreBoard isb = IridiumScoreBoard.getInstance();
		
		if (value.length != 4) {
			isb.getLogger().warning("\n\n--- Could not set sign value: Expected value to be 4 lines long. ---\n");
			return;
		}
		
		for (int line = 0; line < value.length; line ++)
			sign.setLine(line, value[line]);
		
		sign.update();
	}
}
