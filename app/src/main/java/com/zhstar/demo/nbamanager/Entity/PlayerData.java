package com.zhstar.demo.nbamanager.Entity;


import java.util.List;

public class PlayerData extends ServerData{

    private List<Player> data;

    public List<Player> getData() {
        return data;
    }

    public void setData(List<Player> data) {
        this.data = data;
    }
}
