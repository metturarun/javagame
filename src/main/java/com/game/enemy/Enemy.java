package com.game.enemy;

import java.io.Serializable;

public class Enemy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2798442994434092507L;

	private String enemyName;
	private int energyLevel;
	private int skillLevel;

	public String getEnemyName() {
		return enemyName;
	}

	public void setEnemyName(String enemyName) {
		this.enemyName = enemyName;
	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

	public int getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}

	public Enemy() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "enemyName=" + enemyName + ", energyLevel=" + energyLevel + ", skillLevel=" + skillLevel ;
	}

	public Enemy(String enemyName, int energyLevel, int skillLevel) {
		super();
		this.enemyName = enemyName;
		this.energyLevel = energyLevel;
		this.skillLevel = skillLevel;
	}

}
