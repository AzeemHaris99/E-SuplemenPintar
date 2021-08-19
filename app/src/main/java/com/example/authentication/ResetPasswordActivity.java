package com.example.authentication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPasswordActivity extends AppCompatActivity {
    private EditText userEmail;
    private Button sendEmail;
    private FirebaseAuth firebaseAuth;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_password);
        userEmail=findViewById(R.id.forgotemail);
        sendEmail=findViewById(R.id.send);
        back=(ImageView)findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        firebaseAuth=FirebaseAuth.getInstance();
        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=userEmail.getText().toString();
                if(TextUtils.isEmpty(email)) {
                    userEmail.setError("Masukkan emel anda");
                    return;
                }
                else {
                    firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()) {
                                Toast.makeText(ResetPasswordActivity.this,"Sila lihat emel anda untuk tetapkan semula kata laluan anda", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(ResetPasswordActivity.this,MainActivity.class));
                            }
                            else {
                                String message=task.getException().getMessage();
                                Toast.makeText(ResetPasswordActivity.this,"Ralat:"+message, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
