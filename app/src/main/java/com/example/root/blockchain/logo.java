package com.example.root.blockchain;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class logo extends AppCompatActivity {
String uid;
public  static MyInfo myInfo;
String name;
String profilepicture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
uid= FirebaseAuth.getInstance().getUid();


setTitle("LOGO");

        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference();
        databaseReference.child("Profiles").child("Users").child(uid).child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                name=dataSnapshot.getValue().toString() ;



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        databaseReference.child("Profiles").child("Users").child(uid).child("profilepicture").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                profilepicture=dataSnapshot.getValue().toString() ;
if((name!=null)&&(profilepicture!=null)){






}


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        myInfo=new MyInfo(uid,name,profilepicture);
        Intent intent=new Intent(logo.this,MyWallet.class);

        startActivity(intent);
    }
});

    }


}
