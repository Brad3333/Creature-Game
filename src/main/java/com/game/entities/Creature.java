package com.game.entities;

public class Creature extends Entity {
        private int baseCreatureHealth;
        private int baseCreatureAttack;

        private int xp;
        private int level;
        private int xpRate;

        private int creatureHealth;
        private int creatureAttack;

        public CreatureType type;

        // Constructor
        public Creature(int baseCreatureHealth, int baseCreatureAttack, int xp, int xpRate, CreatureType type) {
                this.baseCreatureHealth = baseCreatureHealth;
                this.baseCreatureAttack = baseCreatureAttack;
                this.xp = xp;
                this.xpRate = xpRate;
                this.type = type;

                this.level = xp / 100;
                this.creatureHealth = baseCreatureHealth + (level * 10);
                this.creatureAttack = baseCreatureAttack + (level * 5);
        }

        // Getters and Setters
        public int getBaseCreatureHealth() {
                return baseCreatureHealth;
        }

        public void setBaseCreatureHealth(int baseCreatureHealth) {
                this.baseCreatureHealth = baseCreatureHealth;
        }

        public int getBaseCreatureAttack() {
                return baseCreatureAttack;
        }

        public void setBaseCreatureAttack(int baseCreatureAttack) {
                this.baseCreatureAttack = baseCreatureAttack;
        }

        public int getXp() {
                return xp;
        }

        public void setXp(int xp) {
                this.xp = xp;
        }

        public int getLevel() {
                return level;
        }

        public void setLevel(int level) {
                this.level = level;
        }

        public int getXpRate() {
                return xpRate;
        }

        public void setXpRate(int xpRate) {
                this.xpRate = xpRate;
        }

        public int getCreatureHealth() {
                return creatureHealth;
        }

        public void setCreatureHealth(int creatureHealth) {
                this.creatureHealth = creatureHealth;
        }

        public int getCreatureAttack() {
                return creatureAttack;
        }

        public void setCreatureAttack(int creatureAttack) {
                this.creatureAttack = creatureAttack;
        }

        public CreatureType getType() {
                return type;
        }

        public void setType(CreatureType type) {
                this.type = type;
        }
}
