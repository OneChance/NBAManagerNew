package com.zhstar.demo.nbamanager.services;

import com.zhstar.demo.nbamanager.entity.PlayerData;
import com.zhstar.demo.nbamanager.entity.TeamData;
import com.zhstar.demo.nbamanager.entity.UserData;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import rx.Observable;


public interface IGameServices {
    @FormUrlEncoded
    @POST("nba/account/login/?device=app")
    public Observable<UserData> Login(@Field("user_name") String username, @Field("password") String password);

    @GET("/nba/game/myteam/?device=app&ask=players")
    public Observable<PlayerData> getTeamPlayers();

    @GET("/nba/game/myteam/?device=app&ask=teamInfo")
    public Observable<TeamData> getTeamInfo();
}
