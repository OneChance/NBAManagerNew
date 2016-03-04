package com.zhstar.demo.nbamanager.services;

import com.zhstar.demo.nbamanager.Entity.TeamData;
import com.zhstar.demo.nbamanager.Entity.UserData;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import rx.Observable;


public interface IGameServices {
    @FormUrlEncoded
    @POST("nba/account/login/?device=app")
    public Observable<UserData> Login(@Field("user_name") String username, @Field("password") String password);

    @GET("/nba/game/myteam/?device=app")
    public Observable<TeamData> getTeam();
}
