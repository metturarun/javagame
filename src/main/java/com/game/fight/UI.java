package com.game.fight;

import java.util.List;

import com.game.character.Character;
import com.game.enemy.Enemy;

public interface UI {
	
 void printStory();
 void printGetName();
 String getName();
 void createCharacterMessage();
 void showCharacterDetails();
 String exploreOptions();
 int getEnergyLevel();
 int getSkillLevel();
 void printErrorMessage();
 void readyToFight();
 List<Enemy> populateOpponents();
 void showOpponentArrival();
 Enemy pickAndShowRandomOpponent(List<Enemy> enemies);
 String showFightMessage();
 Object fight(Character chars, Enemy opponent);
 Character populateCharacter(String personName, int energyLevel, int skillLevel);
 Object continueFighting(Character chars, Enemy opponent);
 int showFightingMethods();
 Object fight(Character person, Enemy opponent, int attackType,String mode);
 void continueFighting(Character person, Enemy opponent, int attackType,String mode);
 void saveGame(Character person);
 Character resumeGame(String fileName);
}
