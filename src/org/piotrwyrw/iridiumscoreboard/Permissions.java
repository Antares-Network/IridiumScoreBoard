package org.piotrwyrw.iridiumscoreboard;

public class Permissions {
	
	// Permission to add a score panel
	public static String ADD_SCORE_PANEL = "isb.add";
		
	// Permission to clear all score panels
	public static String REMALL_SCORE_PANELS = "isb.clear";
	
	// Permission to stop the update timer
	public static String STOP_UPDATE = "isb.stop";
	
	// Permission to start a new update timer
	public static String START_UPDATE = "ist.start";
	
	// Test the score panels (DANGEROUS)
	public static String TEST_SCORE_PANELS = "isb.test";
	
	// Save current state to a file
	public static String SAVE_SCORE_PANELS = "isb.save";
}
