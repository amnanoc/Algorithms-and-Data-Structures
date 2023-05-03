package com.company;

public class Item {
    private ItemType type;
    private int value = 0;

    public Item(ItemType type, int value) {
        this.type = type;
        this.value = value;
    }

    public Item(ItemType type) {
        this.type = type;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
