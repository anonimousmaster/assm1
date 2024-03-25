package com.example.lab1_ph35122_dohoanglong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText emailedit ,passedit;
    private Button btnlogin, btnregis;
    private FirebaseAuth mAuth;
    // ----------------------------------------------------------------
    private EditText edtPhoneNumber;
    private Button btnVerifyPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        setTitleToolbar();

        // ánh xạ
        emailedit=findViewById(R.id.email);
        passedit = findViewById(R.id.password);
        btnlogin = findViewById(R.id.btnlogin);
        btnregis = findViewById(R.id.btnregis);

        // sự kiện
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        btnregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

        initui();
        btnVerifyPhoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strPhoneNumber = edtPhoneNumber.getText().toString().trim();
                onClickVerifyPhoneNumber(strPhoneNumber);
            }
        });
    }
    private void onClickVerifyPhoneNumber(String strPhoneNumber) {

    }
    private void setTitleToolbar(){
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Verify Phone Number");
        }
    }
    private void initui(){
        edtPhoneNumber = findViewById(R.id.edt_phone_number);
        btnVerifyPhoneNumber = findViewById(R.id.btn_verify_phone_number);
    }
    private void register(){
        Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(i);
    }
    private void login() {
        String email,pass;
        email = emailedit.getText().toString();
        pass = passedit.getText().toString();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Vui Lòng Nhập Vào Email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this,"Vui Lòng Nhập Vào PassWord",Toast.LENGTH_SHORT).show();
            return;
        }
        // CODE chính
        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Đăng nhập không thành công",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}