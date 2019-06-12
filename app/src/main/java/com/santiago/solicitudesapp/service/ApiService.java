package com.santiago.solicitudesapp.service;


import com.santiago.solicitudesapp.models.ResponseMessage;
import com.santiago.solicitudesapp.models.Solicitud;

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

    String API_BASE_URL = "http://192.168.137.1:9092";

    @GET("/productos")
    Call<List<Solicitud>> getSolicitudes();


    @FormUrlEncoded
    @POST("/solicitudes")
    Call<ResponseMessage> createProducto(@Field("correo") String nombre,
                                         @Field("tipo") String precio,
                                         @Field("motivo") String detalles);
    @Multipart
    @POST("/solicitudes")
    Call<ResponseMessage> createSolicitudWithImage(
            @Part("correo") RequestBody correo,
            @Part("tipo") RequestBody tipo,
            @Part("motivo") RequestBody motivo,
            @Part MultipartBody.Part imagen
    );


}
