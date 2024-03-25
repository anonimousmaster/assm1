package com.example.lab1_ph35122_dohoanglong;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab1_ph35122_dohoanglong.ApiService;
import com.example.lab1_ph35122_dohoanglong.NguoidungAdapter;
import com.example.lab1_ph35122_dohoanglong.R;
import com.example.lab1_ph35122_dohoanglong.nguoidungModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView lvMain;
    List<nguoidungModel> listnguoidungModel;

    NguoidungAdapter nguoidungAdapterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lvMain = findViewById(R.id.listviewMain);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<nguoidungModel>> call = apiService.getnguoidungs();
        call.enqueue(new Callback<List<nguoidungModel>>() {
            @Override
            public void onResponse(Call<List<nguoidungModel>> call, Response<List<nguoidungModel>> response) {
                if (response.isSuccessful()) {
                    listnguoidungModel = response.body();

                    nguoidungAdapterAdapter = new NguoidungAdapter(getApplicationContext(), listnguoidungModel);

                    lvMain.setAdapter(nguoidungAdapterAdapter);
                }
            }
            @Override
            public void onFailure(Call<List<nguoidungModel>> call, Throwable t) {
                Log.e("Main", t.getMessage());
            }
        });
    }
}