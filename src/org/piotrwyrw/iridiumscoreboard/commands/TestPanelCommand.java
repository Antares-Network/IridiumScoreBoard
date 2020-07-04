package org.piotrwyrw.iridiumscoreboard.commands;

import java.util.List;

import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.piotrwyrw.iridiumscoreboard.Main;
import org.piotrwyrw.iridiumscoreboard.Messages;
import org.piotrwyrw.iridiumscoreboard.Permissions;
import org.piotrwyrw.iridiumscoreboard.ScorePanel;
import org.piotrwyrw.iridiumscoreboard.SelectionTracker;

import com.iridium.iridiumskyblock.Island;
import com.iridium.iridiumskyblock.Utils;

public class TestPanelCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!sender.hasPermission(Permissions.TEST_SCORE_PANELS)) {
			sender.sendMessage(Messages.NO_PERMISSION);
			return false;
		}
		
		if (args.length != 0) {
			sender.sendMessage(Messages.EXPECTED_ARGUMENTS(0));
			return false;
		}
		
		Main.getScoreBoard().test();
		sender.sendMessage(Messages.TEST_DONE);
		return true;
	}
	
}
