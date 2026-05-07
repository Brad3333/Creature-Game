package com.game.entities.creatures;

import com.game.entities.Creature;
import com.game.entities.CreatureType;

public class Lightning extends Creature {
    public Lightning(int baseCreatureHealth, int baseCreatureAttack, int xp, int xpRate) {
        super(baseCreatureHealth, baseCreatureAttack, xp, xpRate, CreatureType.LIGHTNING);
    }
}
