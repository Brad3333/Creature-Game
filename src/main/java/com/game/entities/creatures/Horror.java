package com.game.entities.creatures;

import com.game.entities.Creature;
import com.game.entities.CreatureType;

public class Horror extends Creature {
    public Horror(int baseCreatureHealth, int baseCreatureAttack, int xp, int xpRate) {
        super(baseCreatureHealth, baseCreatureAttack, xp, xpRate, CreatureType.HORROR);
    }
}
