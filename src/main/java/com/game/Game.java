package com.game;

import java.util.List;

import com.game.character.Character;
import com.game.enemy.Enemy;
import com.game.fight.UI;
import com.game.fight.UIService;

public class Game {
	public static void main(String[] args) throws InterruptedException {
//This is comment
		int energyLevel = 0;
		int skillLevel = 0;
		String fightMessage = null;
		int attackType = 0;
		String mode = "pro";

		UI uiService = new UIService();
		uiService.printStory();
		uiService.printGetName();
		String personName = uiService.getName();
		Character person = uiService.resumeGame(personName);
		if (null == person) {
			uiService.createCharacterMessage();
			uiService.showCharacterDetails();
			do {
				energyLevel = uiService.getEnergyLevel();
			} while (energyLevel == 0);
			do {
				skillLevel = uiService.getSkillLevel();
			} while (skillLevel == 0);

			person = uiService.populateCharacter(personName, energyLevel, skillLevel);
		}
		mode = uiService.exploreOptions();
		List<Enemy> enemies = uiService.populateOpponents();
		uiService.showOpponentArrival();
		Thread.sleep(2000);
		Enemy opponent = uiService.pickAndShowRandomOpponent(enemies);
		do {
			fightMessage = uiService.showFightMessage();
		} while (fightMessage.equalsIgnoreCase("NA"));

		do {
			attackType = uiService.showFightingMethods();
		} while (attackType == 0);

		uiService.fight(person, opponent, attackType, mode);
		uiService.continueFighting(person, opponent, attackType, mode);

	}

}
