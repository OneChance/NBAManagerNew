package com.zhstar.demo.nbamanager.Entity;


public class TeamInfoItem {
    private int itemName;
    private String itemValue;

    public TeamInfoItem() {

    }

    public TeamInfoItem(int itemName, String itemValue) {
        this.itemName = itemName;
        this.itemValue = itemValue;
    }

    public int getItemName() {
        return itemName;
    }

    public void setItemName(int itemName) {
        this.itemName = itemName;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }
}
