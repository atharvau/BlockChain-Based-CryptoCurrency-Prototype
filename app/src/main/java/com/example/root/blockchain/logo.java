package com.example.root.blockchain;

import android.content.Intent;
import android.os.Environment;
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

import java.io.File;

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
        File dir = Environment.getExternalStorageDirectory();
        File file = new File(dir, "blockchain.db");
        File file1 = new File(dir, "blockchain.db-journal");

        File file2 = new File(dir, "newnode.db");

        File file3 = new File(dir, "newnode.db-journal");

        boolean deleted = file.delete();
        boolean deleted1 = file1.delete();
        boolean deleted2 = file2.delete();
        boolean delete3=file3.delete();






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
