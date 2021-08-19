package com.example.authentication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.unity3d.player.UnityPlayerActivity;

public class MainmenuActivity extends Activity {
    private Button logout;
    private long backPressedTime;
    private Toast backToast;
    private ImageView scan, form, Info;
    private TextView imbas, masalah, bahan;

    @Override
    public void onBackPressed() {
        if(backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        }
        else {
            backToast = Toast.makeText(getBaseContext(), "Sila tekan 2 kali butang kembali untuk keluar", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);
        logout=findViewById(R.id.logout);
        scan=findViewById(R.id.scan);
        form=findViewById(R.id.form);
        Info=findViewById(R.id.Info);
        imbas=findViewById(R.id.imbas);
        masalah=findViewById(R.id.masalah_kesihatan);
        bahan=findViewById(R.id.bahan);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(logout.getContext());
                builder.setTitle("Log Keluar");
                builder.setMessage("Anda pasti ingin log keluar?");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseAuth.getInstance().signOut();
                        SharedPreferences sharedPreferences = getSharedPreferences("logindata", MODE_PRIVATE);
                        sharedPreferences.edit().clear().commit();
                        Intent intent = new Intent(MainmenuActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();
            }
        });
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainmenuActivity.this, UnityPlayerActivity.class);
                startActivity(intent);
            }
        });
        imbas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainmenuActivity.this, UnityPlayerActivity.class);
                startActivity(intent);
            }
        });
        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainmenuActivity.this,FormActivity.class);
                startActivity(intent);
            }
        });
        masalah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainmenuActivity.this,FormActivity.class);
                startActivity(intent);
            }
        });
        Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainmenuActivity.this,ingActivity.class);
                startActivity(intent);
            }
        });
        bahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainmenuActivity.this,ingActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkuserstatus();
    }

    void checkuserstatus(){
        SharedPreferences sharedPreferences=getSharedPreferences("logindata",MODE_PRIVATE);
        Boolean counter=sharedPreferences.getBoolean("logincounter",Boolean.valueOf(String.valueOf(MODE_PRIVATE)));
        String email=sharedPreferences.getString("useremail",String.valueOf(MODE_PRIVATE));
        if (!counter){
            startActivity(new Intent(MainmenuActivity.this,MainActivity.class));
            finish();
        }
    }

}
