package com.example.authentication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.facebook.shimmer.Shimmer;
import com.facebook.shimmer.ShimmerDrawable;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.DialogPlusBuilder;
import com.orhanobut.dialogplus.ViewHolder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Handler;

public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder> {
    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final myviewholder holder, final int position, @NonNull final model model) {
        holder.name.setText(model.getName());
        holder.email.setText(model.getEmail());
        holder.health.setText(model.getHealth());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.name.getContext());
                builder.setTitle("Buang Butiran");
                builder.setMessage("Anda pasti ingin membuang butiran ini?");

                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    FirebaseAuth mAuth=FirebaseAuth.getInstance();
                    FirebaseUser currentUser = mAuth.getCurrentUser();
                    String uid = currentUser.getUid();
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("pengguna").child(uid).child(getRef(position).getKey()).removeValue();
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
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus=DialogPlus.newDialog(holder.name.getContext()).setContentHolder(new ViewHolder(R.layout.dialogcontent)).setExpanded(true, 1000).create();

                View myview=dialogPlus.getHolderView();
                final EditText name=myview.findViewById(R.id.uname);
                final EditText email=myview.findViewById(R.id.uemail);
                final EditText health=myview.findViewById(R.id.uhealth);

                Button submit=myview.findViewById(R.id.usubmit);

                name.setText(model.getName());
                email.setText(model.getEmail());
                health.setText(model.getHealth());

                dialogPlus.show();

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String,Object> map=new HashMap<>();
                        map.put("name",name.getText().toString());
                        map.put("email",email.getText().toString());
                        map.put("health",health.getText().toString());
                        map.put("timestamp", ServerValue.TIMESTAMP);

                        FirebaseAuth mAuth=FirebaseAuth.getInstance();
                        FirebaseUser currentUser = mAuth.getCurrentUser();
                        String uid = currentUser.getUid();
                        FirebaseDatabase.getInstance().getReference().child("pengguna").child(uid).child(getRef(position).getKey()).updateChildren(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                dialogPlus.dismiss();
                            }
                        })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });
            }
        });
    }
    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }


    class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView edit,delete;
        TextView name,email,health;
        private SimpleDateFormat simpleDateFormat ;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.nametext);
            email=(TextView)itemView.findViewById(R.id.emailtext);
            health=(TextView)itemView.findViewById(R.id.healthtext);

            edit=(ImageView)itemView.findViewById(R.id.editicon);
            delete=(ImageView)itemView.findViewById(R.id.deleteicon);

            String isoDatePattern = "dd/MM/yyyy  HH:mm";
            simpleDateFormat = new SimpleDateFormat(isoDatePattern);
        }
    }
}
