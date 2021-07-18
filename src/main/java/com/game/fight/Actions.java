package com.game.fight;

public enum Actions {

	STRIKE(1, 10), KICK(2, 15), UPPERKICK(3, 20), BLOCK(4, 0);

	private Actions(int actionType, int actionValue) {
		this.actionType = actionType;
		this.actionValue = actionValue;
	}

	private int actionType;
	private int actionValue;

	public int getActionType() {
		return actionType;
	}

	public int getActionValue() {
		return actionValue;
	}

}
