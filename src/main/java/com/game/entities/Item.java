package com.game.entities;

public class Item extends Entity {

    private String tooltip;
    private ItemRarity rarity;

    public enum ItemRarity {
        COMMON, RARE, LEGENDARY
    }

    // Constructor
    public Item(String tooltip, ItemRarity rarity) {
        this.tooltip = tooltip;
        this.rarity = rarity;
    }

    // Getters and Setters
    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public ItemRarity getRarity() {
        return rarity;
    }

    public void setRarity(ItemRarity rarity) {
        this.rarity = rarity;
    }
}
