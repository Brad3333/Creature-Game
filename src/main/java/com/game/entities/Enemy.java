package com.game.entities;

public class Enemy {
    private int enemyHealth;
    private Creature[] enemyCreatures;

    // Constructor
    public Enemy(int enemyHealth, Creature[] enemyCreatures) {
        this.enemyHealth = enemyHealth;
        this.enemyCreatures = enemyCreatures;
    }

    // Getters and Setters
    public int getEnemyHealth() {
        return enemyHealth;
    }

    public Creature[] getEnemyCreatures() {
        return enemyCreatures;
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public void setEnemyCreatures(Creature[] enemyCreatures) {
        this.enemyCreatures = enemyCreatures;
    }

}