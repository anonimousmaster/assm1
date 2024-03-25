package com.example.lab1_ph35122_dohoanglong;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    String DOMAIN = "http://10.82.0.103:3000/";

    @GET("/api/list")
    Call<List<nguoidungModel>> getnguoidungs();


}
