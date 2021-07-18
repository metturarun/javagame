package com.game.fight;

import java.util.HashMap;

import com.game.enemy.Enemy;

public interface AccessDamage {
	
	HashMap<Character, Enemy> accessDamage(Character chars, Enemy opponent, int attackType);

}
