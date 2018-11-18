package com.example.joyprakash.genericdownloadmanager;

import com.example.joyprakash.genericdownloadmanager.response.DownloadResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("bins/ez8j6")
    Call<DownloadResponse> getDownloadLink();
}
