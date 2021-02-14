package com.prawin.gitTrendrepo.api;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "https://private-anon-dcbcde0593-githubtrendingapi.apiary-mock.com/";


    @GET("repositories?language=&since=daily&spoken_language_code=")
     Call<List<Hero>> getHeroes(
            @Query("lanuage") String language
    );

    @GET("repositories?language=&since=daily&spoken_language_code=")
    Call<List<Hero>> getHeroes();
}