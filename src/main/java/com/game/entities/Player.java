package com.game.entities;

public class Player extends Character {
    private int playerHealth;
    private int playerMoney;
    private Creature[] playerCreatures;
    private Item[] playerItemInventory;

    // Constructor
    public Player(int playerHealth, int playerMoney, Creature[] playerCreatures, Item[] playerItemInventory) {
        this.playerHealth = playerHealth;
        this.playerMoney = playerMoney;
        this.playerCreatures = playerCreatures;
        this.playerItemInventory = playerItemInventory;
    }
    // Getters and Setters
    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

    public int getPlayerMoney() {
        return playerMoney;
    }

    public void setPlayerMoney(int playerMoney) {
        this.playerMoney = playerMoney;
    }

    public Creature[] getPlayerCreatures() {
        return playerCreatures;
    }

    public void setPlayerCreatures(Creature[] playerCreatures) {
        this.playerCreatures = playerCreatures;
    }

    public Item[] getPlayerItemInventory() {
        return playerItemInventory;
    }

    public void setPlayerItemInventory(Item[] playerItemInventory) {
        this.playerItemInventory = playerItemInventory;
    }

}
