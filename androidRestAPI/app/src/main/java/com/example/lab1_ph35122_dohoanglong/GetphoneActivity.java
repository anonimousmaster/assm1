package com.example.lab1_ph35122_dohoanglong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GetphoneActivity extends AppCompatActivity {
    private EditText edtOtp;
    private Button btnSendOtp;
    private TextView tvSendOtpAgain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getphone);

        setTitleToolbar();
        initui();
        btnSendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strOtp = edtOtp.getText().toString().trim();
                onClickSendOtpCode(strOtp);
            }
        });

        tvSendOtpAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickSendOtpAgain();
            }


        });
    }

    private void setTitleToolbar(){
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Enter OTP Code ");
        }

    }
    private void initui(){
        edtOtp = findViewById(R.id.edt_otp);
        btnSendOtp = findViewById(R.id.btn_send_otp_code);
        tvSendOtpAgain = findViewById(R.id.tv_send_otp_again);
    }

    private void onClickSendOtpAgain() {
    }
    private void onClickSendOtpCode(String strOtp) {

    }
}