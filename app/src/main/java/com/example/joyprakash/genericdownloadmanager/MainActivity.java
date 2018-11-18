package com.example.joyprakash.genericdownloadmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.joyprakash.genericdownloadmanager.downloadfileprovider.DownloadFileHelper;
import com.example.joyprakash.genericdownloadmanager.response.DownloadResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Button downloadButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        downloadButton = findViewById(R.id.downloadButton);
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadFile();
            }
        });
    }

    private void downloadFile() {
        Service service = APIClient.getClient().create(Service.class);
        service.getDownloadLink().enqueue(new Callback<DownloadResponse>() {
            @Override
            public void onResponse(Call<DownloadResponse> call, Response<DownloadResponse> response) {
                if (response.isSuccessful()){
                    if(response.body() != null){
                       new DownloadFileHelper(MainActivity.this,response.body().getDownloadUrl());
                    }
                }else {
                    Toast.makeText(MainActivity.this,"Something went wrong",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DownloadResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Result failed",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
