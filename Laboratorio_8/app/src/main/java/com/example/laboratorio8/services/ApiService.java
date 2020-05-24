package com.example.laboratorio8.services;

//import com.example.laboratorio8.models.Location;
import com.example.laboratorio8.models.Mapa;

import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {


    @GET("nearbysearch/json")
    Call<Mapa> getDataMarkers(@Query("location")String location,
                              @Query("radius")String radius,
                              @Query("type")String type,
                              @Query("keyword")String keyword,
                              @Query("key")String key);
}
