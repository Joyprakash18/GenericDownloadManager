package com.example.joyprakash.genericdownloadmanager.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DownloadResponse {
    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("downloadUrl")
    @Expose
    private String downloadUrl;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
}
