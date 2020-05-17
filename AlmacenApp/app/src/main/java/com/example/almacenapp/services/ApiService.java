package com.example.almacenapp.services;

import com.example.almacenapp.models.Producto;
import com.example.almacenapp.models.ResponseMessage;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ApiService {

    String API_BASE_URL = "http://192.168.1.8:8080/";

    @GET("/productos")
    Call<List<Producto>> getProductos();

    @FormUrlEncoded
    @POST("/productos")
    Call<ResponseMessage> createProducto(@Field("nombre") String nombre,
                                         @Field("precio") String precio,
                                         @Field("detalles") String detalles);
    @Multipart
    @POST("/productos")
    Call<ResponseMessage> createProductoWithImage(
            @Part("nombre") RequestBody nombre,
            @Part("precio") RequestBody precio,
            @Part("detalles") RequestBody detalles,
            @Part MultipartBody.Part imagen
    );

    @DELETE("/productos/{id}")
    Call<ResponseMessage> destroyProducto(@Path("id") Integer id);

    @GET("/productos/{id}")
    Call<Producto> showProducto(@Path("id") Integer id);


    @FormUrlEncoded
    @POST("/usuarios")
    Call<ResponseMessage> createUsuario(@Field("username") String username,
                                        @Field("password") String password,
                                        @Field("nombres") String detalles,
                                        @Field("correo") String correo);
    @Multipart
    @POST("/usuarios")
    Call<ResponseMessage> createUsuarioWithImage(
            @Part("username") RequestBody username,
            @Part("password") RequestBody password,
            @Part("nombres") RequestBody nombres,
            @Part("correo") RequestBody correo,
            @Part MultipartBody.Part imagen
    );

}

