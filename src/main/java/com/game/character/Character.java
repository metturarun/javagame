package com.game.character;

import java.io.Serializable;

public class Character implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5455393119636552685L;

	private String name;
	private int energyLevel;
	private int skillLevel;
	private int experienceLevel;
	private int currentPoints;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getExperienceLevel() {
		return experienceLevel;
	}

	public void setExperienceLevel(int experienceLevel) {
		this.experienceLevel = experienceLevel;
	}

	public int getCurrentPoints() {
		return currentPoints;
	}

	public void setCurrentPoints(int currentPoints) {
		this.currentPoints = currentPoints;
	}

	public Character() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "name=" + name + ", energyLevel=" + energyLevel + ", skillLevel=" + skillLevel
				+ ", experienceLevel=" + experienceLevel + ", currentPoints=" + currentPoints;
	}

	public Character(String name, int energyLevel, int skillLevel, int experienceLevel, int currentPoints) {
		super();
		this.name = name;
		this.energyLevel = energyLevel;
		this.skillLevel = skillLevel;
		this.experienceLevel = experienceLevel;
		this.currentPoints = currentPoints;
	}

}
