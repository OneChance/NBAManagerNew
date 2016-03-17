package com.zhstar.demo.nbamanager.Entity;


public class TeamInfoItem {
    private int iconRid;
    private String itemValue;

    public TeamInfoItem() {

    }

    public TeamInfoItem(int iconRid, String itemValue) {
        this.iconRid = iconRid;
        this.itemValue = itemValue;
    }

    public int getIconRid() {
        return iconRid;
    }

    public void setIconRid(int iconRid) {
        this.iconRid = iconRid;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }
}
