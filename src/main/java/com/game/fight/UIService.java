package com.game.fight;

import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.game.character.Character;
import com.game.common.CommonUtils;
import com.game.enemy.Enemy;

public class UIService implements UI {

	Scanner scan = new Scanner(System.in);
	Random random = new Random();
	private String characterName;
	private int energyLevel;
	private int skillLevel;
	private String mode = "pro";

	@Override
	public void printStory() {
		CommonUtils.printLine();
		CommonUtils.printText("Welcome to the FightClub!. Fights will go on as long as they have to.");
		CommonUtils.printText("Your opponent is assigned automatically.");
		CommonUtils.printText("You can save a game and resume later.");
		CommonUtils.printLine();
	}

	@Override
	public void printGetName() {
		CommonUtils.printText("Braveheart, How do we call you?");
	}

	@Override
	public String getName() {
		setCharacterName(scan.nextLine());
		return characterName;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}

	@Override
	public void createCharacterMessage() {
		CommonUtils.printLine();
		CommonUtils.printText("Great, Welcome " + characterName + ".");
		CommonUtils.printText("Lets go ahead and create your character");

	}

	@Override
	public void showCharacterDetails() {
		CommonUtils.printText("You are free to choose your character strenth and skill level. Choose wisely");
		CommonUtils.printLine();
	}

	@Override
	public int getEnergyLevel() {
		CommonUtils.printTextInline("Enter your desired Energy Level");
		CommonUtils.printTextInline("Enter any number with in 100");
		try {
			energyLevel = scan.nextInt();
		} catch (InputMismatchException ex) {
			printErrorMessage();
			energyLevel = 0;
		}
		scan.nextLine();
		return energyLevel;
	}

	@Override
	public int getSkillLevel() {
		CommonUtils.printLine();
		CommonUtils.printTextInline("Enter your desired Skill Level.");
		CommonUtils.printTextInline("1 for Novice, 2 for Master and 3 for Expert.");
		try {
			skillLevel = scan.nextInt();
		} catch (InputMismatchException ex) {
			printErrorMessage();
			skillLevel = 0;
		}
		scan.nextLine();
		if (skillLevel != 0) {
			if (!(skillLevel == 1 || skillLevel == 2 || skillLevel == 3)) {
				printErrorMessage();
				skillLevel = 0;
			}
		}
		CommonUtils.printLine();
		return skillLevel;
	}

	@Override
	public void printErrorMessage() {
		CommonUtils.printTextInline("That was not understood, try again!!!");
	}

	@Override
	public void readyToFight() {
		CommonUtils.printTextInline("Opponent will appear soon. Once ready press F for fight");
	}

	@Override
	public List<Enemy> populateOpponents() {
		List<Enemy> opponents = Arrays.asList(new Enemy("Bruce Lee", 90, 3), new Enemy("Jet Li", 80, 2),
				new Enemy("Jackie Chan", 70, 2), new Enemy("Ip Man", 100, 3), new Enemy("Ong Bak", 40, 1));
		return opponents;
	}

	@Override
	public Enemy pickAndShowRandomOpponent(List<Enemy> enemies) {
		Enemy enemy = enemies.get(random.nextInt(enemies.size()));
		CommonUtils.printTextInline("Opponent has arrived");
		CommonUtils.printLine();
		CommonUtils.printTextInline(enemy.toString());
		CommonUtils.printLine();
		return enemy;
	}

	@Override
	public String showFightMessage() {
		CommonUtils.printTextInline("When you are ready, press F to begin fight");
		CommonUtils.printTextInline("Good Luck.");
		String fight = scan.nextLine();
		if (!(fight.equalsIgnoreCase("F"))) {
			fight = "NA";
		}
		return fight;

	}

	@Override
	public void showOpponentArrival() {
		CommonUtils.printTextInline("Sit tight and wait for the opponent to arrive.");
	}

	@Override
	public HashMap<String, Object> fight(Character chars, Enemy opponent) {

		HashMap<String, Object> obj = new HashMap<String, Object>();
		if ((chars.getEnergyLevel() < opponent.getEnergyLevel()) & (chars.getSkillLevel() < opponent.getSkillLevel())) {
			chars.setExperienceLevel(chars.getExperienceLevel() + 1);
			chars.setEnergyLevel(chars.getEnergyLevel() - 10);
			opponent.setEnergyLevel(opponent.getEnergyLevel() + 10 > 100 ? 100 : opponent.getEnergyLevel() + 10);

			obj.put("winner", opponent);
			obj.put("loser", chars);
			CommonUtils.printTextInline("Hasta la Vista!!!, Your opponent has won");
			CommonUtils.printTextInline(opponent.toString());
			CommonUtils.printLine();
			CommonUtils.printTextInline("Your current stats are " + chars.toString());
		} else {
			chars.setExperienceLevel(chars.getExperienceLevel() + 1);
			chars.setEnergyLevel(chars.getEnergyLevel() + 10 > 100 ? 100 : chars.getEnergyLevel() + 10);
			chars.setCurrentPoints(chars.getCurrentPoints() + 1);
			opponent.setEnergyLevel(opponent.getEnergyLevel() - 10);
			obj.put("winner", chars);
			obj.put("loser", opponent);
			CommonUtils.printTextInline("Gracious!!!, You won the fight and earned experience and energy");
			CommonUtils.printTextInline("Your current stats are " + chars.toString());
		}

		return obj;
	}

	@Override
	public Character populateCharacter(String personName, int energyLevel, int skillLevel) {
		Character person = new Character(personName, energyLevel, skillLevel, 0, 0);
		return person;
	}

	@Override
	public Object continueFighting(Character chars, Enemy opponent) {
		boolean play = true;
		do {
			CommonUtils.printLine();
			CommonUtils.printTextInline("Do you want to play again!!! Press y/n?");
			String option = scan.nextLine();
			if (option.equals("y")) {
				showOpponentArrival();
				Enemy opponentNew = pickAndShowRandomOpponent(populateOpponents());
				showFightMessage();
				fight(chars, opponentNew);
				play = true;
			} else {
				CommonUtils.printTextInline("Thanks for playing fair.");
				play = false;
			}
		} while (play);
		return null;
	}

	@Override
	public int showFightingMethods() {
		int fightType = 0;
		CommonUtils.printLine();
		CommonUtils.printTextInline("Choose the type of attack");
		CommonUtils.printTextInline("1.Strike -> Damage inflicted " + FightingMethod.getStrike());
		CommonUtils.printTextInline("2.Kick -> Damage inflicted " + FightingMethod.getKick());
		CommonUtils.printTextInline("3.UpperKick  -> Damage inflicted " + FightingMethod.getUpperkick());
		CommonUtils.printTextInline("4.Block  -> Damage inflicted " + FightingMethod.getBlock());
		CommonUtils.printLine();
		try {
			fightType = scan.nextInt();
		} catch (InputMismatchException ex) {
			printErrorMessage();
			fightType = 0;
		}
		scan.nextLine();

		return fightType;
	}

	@Override
	public HashMap<String, Object> fight(Character person, Enemy opponent, int attackType, String mode) {
		HashMap<String, Object> obj = new HashMap<String, Object>();

		Actions[] actions = Actions.values();
		int enemyAction = random.nextInt(actions.length);

		CommonUtils.printTextInline("You have attacked using " + actions[attackType - 1].name());
		CommonUtils.printTextInline("Enemy has attacked you using " + actions[enemyAction].name());

		CommonUtils.printLine();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int damage = actions[attackType - 1].getActionValue() - actions[enemyAction].getActionValue();
		person.setExperienceLevel(person.getExperienceLevel() + 1);
		if (damage == 0 || actions[enemyAction].name().equals("BLOCK")
				|| actions[attackType - 1].name().equals("BLOCK")) {
			CommonUtils.printTextInline("Its a draw..Keep fighting");
		} else if (damage > 0) {
			CommonUtils.printTextInline("Congrats...You have inflicted damage to the opponent");
			person.setEnergyLevel((person.getEnergyLevel() + damage) > 100 ? 100 : (person.getEnergyLevel() + damage));
			opponent.setEnergyLevel(opponent.getEnergyLevel() - damage);

			if (mode.equals("pro")) {
				person.setCurrentPoints(person.getCurrentPoints() + 1);
			}

		} else {
			CommonUtils.printTextInline("You have lost the fight and took damage");
			person.setEnergyLevel(person.getEnergyLevel() + damage);
			opponent.setEnergyLevel(
					(opponent.getEnergyLevel() + damage) > 100 ? 100 : (opponent.getEnergyLevel() + damage));
		}

		CommonUtils.printLine();
		CommonUtils.printTextInline("Your stats are " + person);

		if (person.getEnergyLevel() == 0) {
			CommonUtils.printTextInline("You lost!!! ");
			System.exit(0);
		}

		return obj;
	}

	@Override
	public void continueFighting(Character person, Enemy opponent, int attackType,String mode) {
		boolean play = true;
		do {
			CommonUtils.printLine();
			CommonUtils.printTextInline("Do you want to play again!!! Press y/n?");
			String option = scan.nextLine();
			if (option.equals("y")) {
				showOpponentArrival();
				Enemy opponentNew = pickAndShowRandomOpponent(populateOpponents());
				showFightMessage();
				fight(person, opponentNew, showFightingMethods(),mode);
				play = true;
			} else {
				CommonUtils.WriteObjectToFile(person, person.getName());
				CommonUtils.printTextInline("Thanks for playing fair. Your profile saved, you can use the same again");
				play = false;
			}
		} while (play);

	}

	@Override
	public void saveGame(Character person) {
		CommonUtils.WriteObjectToFile(person, person.getName());
	}

	@Override
	public Character resumeGame(String fileName) {
		Character person = CommonUtils.readObjectFromFile(fileName);
		String reload = "";
		if (!(null == person)) {
			CommonUtils.printLine();
			CommonUtils.printTextInline("We have your profile " + person);
			CommonUtils.printTextInline("Would you like to use the above(y/n)");
			reload = scan.nextLine();
			if (reload.equalsIgnoreCase("Y")) {
				CommonUtils.printTextInline("Your existing profile is loaded!!! Kindly create enemy and fight");
			} else {
				person = null;
			}
		}
		return person;
	}

	@Override
	public String exploreOptions() {
		CommonUtils.printLine();
		CommonUtils.printTextInline("Would you like to play in Demo mode(y) or PRO Mode(n)");
		CommonUtils.printTextInline("If you play in demo mode you will not gain reward points when you win a game");
		if ("Y".equalsIgnoreCase(scan.nextLine())) {
			mode = "demo";
		}
		
		CommonUtils.printTextInline("You are playing in " + mode +" mode.");
		return mode;
	}
}
