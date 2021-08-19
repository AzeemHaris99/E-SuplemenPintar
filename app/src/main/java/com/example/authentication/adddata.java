package com.example.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;

import java.util.HashMap;
import java.util.Map;

public class adddata extends AppCompatActivity {
    EditText name,email,health;
    Button submit;
    ImageView back;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddata);

        name=(EditText)findViewById(R.id.add_name);
        email=(EditText)findViewById(R.id.add_email);
        health=(EditText)findViewById(R.id.add_health);
        back=(ImageView)findViewById(R.id.add_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        submit=(Button)findViewById(R.id.add_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameEt=name.getText().toString();
                String emailEt=email.getText().toString();
                String healthEt=health.getText().toString();
                if(TextUtils.isEmpty(nameEt)){
                    name.setError("Masukkan nama anda");
                    return;
                }
                else if(TextUtils.isEmpty(emailEt)){
                    email.setError("Masukkan emel anda");
                    return;
                }
                else if(TextUtils.isEmpty(healthEt)){
                    health.setError("Masukkan masalah kesihatan anda");
                    return;
                }
                else {
                    processinsert();
                }
            }
        });
    }
    private void processinsert()
    {
        Map<String,Object> map=new HashMap<>();
        map.put("name",name.getText().toString());
        map.put("email",email.getText().toString());
        map.put("health",health.getText().toString());
        map.put("timestamp", ServerValue.TIMESTAMP);
        FirebaseAuth mAuth=FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        String uid = currentUser.getUid();
        FirebaseDatabase.getInstance().getReference().child("pengguna").child(uid).push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        name.setText("");
                        email.setText("");
                        health.setText("");
                        Toast.makeText(getApplicationContext(),"Maklumat Berjaya Dihantar.",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {
                        Toast.makeText(getApplicationContext(),"Maklumat Tidak Berjaya Dihantar",Toast.LENGTH_LONG).show();
                    }
                });

    }

}