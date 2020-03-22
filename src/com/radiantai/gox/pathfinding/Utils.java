package com.radiantai.gox.pathfinding;

import java.util.UUID;

import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.radiantai.gox.GoX;

public class Utils {
	
	public static String GenerateId(int length) {
		String uuid = UUID.randomUUID().toString().substring(0, length-1);
		return uuid;
	}
	
	public static Vector getVector(String dir) {
		dir = dir.toLowerCase();
		switch (dir) {
		case "north":
			return new Vector(0,0,-1);
		case "east":
			return new Vector(1,0,0);
		case "west":
			return new Vector(-1,0,0);
		case "south":
			return new Vector(0,0,1);
		}
		return null;
	}
	
	public static BlockFace getBlockFace(String dir) {
		switch (dir) {
		case "north":
			return BlockFace.NORTH;
		case "east":
			return BlockFace.EAST;
		case "west":
			return BlockFace.WEST;
		case "south":
			return BlockFace.SOUTH;
		}
		return BlockFace.NORTH;
	}
	
	public static boolean isValidDirection(String dir) {
		dir = dir.toLowerCase();
		return dir.equals("north")  || dir.equals("east") || dir.equals("south") || dir.equals("west");
	}
	
	public static void resetPathMeta(Player player, GoX plugin) {
		if (player.hasMetadata("go_destination")) {
			player.removeMetadata("go_destination", plugin);
		}
		if (player.hasMetadata("go_path")) {
			player.removeMetadata("go_path", plugin);
		}
	}
}
