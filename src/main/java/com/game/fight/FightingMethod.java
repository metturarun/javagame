package com.game.fight;

public final class FightingMethod {

	private static final int STRIKE = 10;
	private static final int KICK = 15;
	private static final int UPPERKICK = 20;
	private static final int BLOCK = 0;

	public static int getStrike() {
		return STRIKE;
	}

	public static int getKick() {
		return KICK;
	}

	public static int getUpperkick() {
		return UPPERKICK;
	}

	public static int getBlock() {
		return BLOCK;
	}

}
