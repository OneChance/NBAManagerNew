package com.zhstar.demo.nbamanager.util;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zhstar.demo.nbamanager.services.IGameServices;

import java.io.IOException;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class GameNetUtil {
    private static IGameServices gameServices;

    public static IGameServices getGameServices() {
        if (gameServices == null) {

            OkHttpClient client = new OkHttpClient();

            client.interceptors().add(new Interceptor() {

                @Override
                public Response intercept(Chain chain) throws IOException {

                    Request.Builder builder = chain.request()
                            .newBuilder();

                    if(!Session.SessionId.equals("")){
                        builder = builder.addHeader("Cookie", Session.SessionId);
                    }

                    Request request = builder.build();

                    Response response = chain.proceed(request);

                    if(Session.SessionId.equals("")){
                        Session.SessionId = response.header("Set-Cookie");
                    }

                    return response;
                }
            });


            Retrofit restAdapter = new Retrofit.Builder()
                    .baseUrl(URLs.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

            gameServices = restAdapter.create(IGameServices.class);
        }

        return gameServices;
    }

    public static <T> Observable<T> SetObserverCommonAction(Observable<T> observable) {

        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
