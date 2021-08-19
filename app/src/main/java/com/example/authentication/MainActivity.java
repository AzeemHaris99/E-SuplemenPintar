package com.example.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private EditText emailEt,passwordEt;
    private Button SignInButton;
    private TextView SignUpTv,ForgotPasswordTv;
    private ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth=FirebaseAuth.getInstance();
        emailEt=findViewById(R.id.email);
        passwordEt=findViewById(R.id.password);
        SignInButton=findViewById(R.id.login);
        progressDialog=new ProgressDialog(this);
        ForgotPasswordTv=findViewById(R.id.forgotpasswordTv);
        SignUpTv=findViewById(R.id.signUpTv);
        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
        ForgotPasswordTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ResetPasswordActivity.class);
                startActivity(intent);
            }
        });
        SignUpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void Login(){
        String email=emailEt.getText().toString();
        String password=passwordEt.getText().toString();
        if(TextUtils.isEmpty(email)){
            emailEt.setError("Masukkan emel anda");
            return;
        }
        else if(TextUtils.isEmpty(password)){
            passwordEt.setError("Masukkan kata laluan anda");
            return;
        }
        progressDialog.setMessage("Sila tunggu...");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Log Masuk Berjaya", Toast.LENGTH_LONG).show();
                    SharedPreferences sharedPreferences=getSharedPreferences("logindata",MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putBoolean("logincounter",true);
                    editor.putString("useremail",email);
                    editor.apply();
                    FirebaseUser currentUser = firebaseAuth.getCurrentUser();
                    String uid = currentUser.getUid();
                    Intent intent=new Intent(MainActivity.this,MainmenuActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(MainActivity.this, "Log Masuk Gagal", Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();
            }
        });
    }
}