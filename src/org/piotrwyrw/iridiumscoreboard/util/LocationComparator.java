package org.piotrwyrw.iridiumscoreboard.util;

import org.bukkit.Location;

public class LocationComparator {
	public static boolean isSame(Location loc1, Location loc2) {
		return ((loc1.getX() == loc2.getX()) && (loc1.getY() == loc2.getY()) && (loc1.getZ() == loc2.getZ()))
				? true : false;
	}
}
