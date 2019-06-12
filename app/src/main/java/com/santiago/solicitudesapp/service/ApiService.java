package com.santiago.solicitudesapp.service;


import com.santiago.solicitudesapp.models.ResponseMessage;
import com.santiago.solicitudesapp.models.Solicitud;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;


public interface ApiService {

    String API_BASE_URL = "http://192.168.137.1:8081";
    //String API_BASE_URL = "http://10.200.171.149:8081";

    @GET("/solicitudes")
    Call<List<Solicitud>> getSolicitudes();


    @FormUrlEncoded
    @POST("/solicitudes")
    Call<ResponseMessage> createSolicitud(@Field("correo") String correo,
                                         @Field("tipo") String tipo,
                                         @Field("motivo") String motivo);
    @Multipart
    @POST("/solicitudes")
    Call<ResponseMessage> createSolicitudWithImage(
            @Part("correo") RequestBody correo,
            @Part("tipo") RequestBody tipo,
            @Part("motivo") RequestBody motivo,
            @Part MultipartBody.Part imagen
    );


}
