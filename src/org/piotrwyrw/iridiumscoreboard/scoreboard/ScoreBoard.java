package org.piotrwyrw.iridiumscoreboard.scoreboard;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.piotrwyrw.iridiumscoreboard.IridiumScoreBoard;
import org.piotrwyrw.iridiumscoreboard.globals.Messages;

public class ScoreBoard {
	public List<ScorePanel> scorepanels;
	
	public ScoreBoard() {
		this.scorepanels = new ArrayList<ScorePanel>();
	}
	
	public void test() {
		if (scorepanels == null)
			return;
		if (scorepanels.size() <= 0)
			return;
		for (int i = 0; i < scorepanels.size(); i ++) {
			ScorePanel p = scorepanels.get(i);
			if (!(p.location.getBlock().getState() instanceof Sign)) {
				Bukkit.broadcastMessage(Messages.TEST_WRONG_BLOCK);
				System.err.println("----- WARNING: " + p.location.getX() + ", " + p.location.getY() + ", " + p.location.getZ() + " should be a sign, but the block is of type " + p.location.getBlock().getType().toString() + " -----");
				continue;
			}
			p.updateSign(true, null, null, i + 1);
		}
	}
	
	public void write(boolean remove) {
		if (remove) {
			IridiumScoreBoard.getPanels().set("scoreboard.panels", null);
			IridiumScoreBoard.savePanels();
			return;
		}
		List<Location> locs = new ArrayList<Location>();
		for (int i = 0; i < scorepanels.size(); i ++)
			IridiumScoreBoard.getPanels().set("scoreboard.panels.ISB" + String.valueOf(i), scorepanels.get(i).location);
		IridiumScoreBoard.savePanels();
	}
	
	public void addPanel(ScorePanel panel) {
		this.scorepanels.add(panel);
	}
	
	public void removePanel(ScorePanel panel) {
		this.scorepanels.remove(panel);
	}
	
	public void removeAllPanels() {
		for (int i = 0; i < scorepanels.size(); i ++)
			scorepanels.remove(i);
		scorepanels.clear();
	}
	
	public int count() {
		return this.scorepanels.size();
	}
}
