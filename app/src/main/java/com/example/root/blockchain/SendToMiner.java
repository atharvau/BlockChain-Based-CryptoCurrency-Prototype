package com.example.root.blockchain;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;

import pl.bclogic.pulsator4droid.library.PulsatorLayout;

public class SendToMiner extends AppCompatActivity {
    FirebaseStorage storage;
    StorageReference storageRef,imageRef,DownRef;
    ProgressDialog progressDialog;
    UploadTask uploadTask;
    public Uri down;
    DatabaseReference fb;
    Uri selectedImage;
    private static final int READ_REQUEST_CODE = 42;
    EditText amount;
    Button sendmoney;
    String Sender=logo.myInfo.getUid();
    String Reciver;

TextView nameS,nameR;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
  int  NvaisOpen=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_to_miner);


        nameR=findViewById(R.id.textView17);
        nameS=findViewById(R.id.textView15);
        nameS.setText(logo.myInfo.getName());





        dl = (DrawerLayout)findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl,R.string.common_open_on_phone, R.string.app_name);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView)findViewById(R.id.nv);

        nv.setItemIconTintList(null);



        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {



        int id = menuItem.getItemId();
        switch(id)
        {
            case R.id.BlockChain:
blockchainintent();
return  true;

        case R.id.MyWallet:

MyWalletintent();return  true;


            case R.id.SendMoney:

sendtominerintent();return  true;


            case R.id.Mining:

miningintent();return  true;


            default:
                return false;
        }


    }
});



        if(Sender.equals("q4SmT6KlBIZ9O4ysayXloXg4aPI2")){


    Reciver="dYe8n7O5zVh9hcaVhOc5MEocQxd2";

}else if(Sender.equals("dYe8n7O5zVh9hcaVhOc5MEocQxd2")){

    Reciver="q4SmT6KlBIZ9O4ysayXloXg4aPI2";

}


DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference();

databaseReference.child("Profiles").child("Users").child(Reciver).child("name").addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        nameR.setText(dataSnapshot.getValue().toString());

    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});



        databaseReference.child("Profiles").child("Users").child(Reciver).child("profilepicture").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               // nameR.setText(dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

















        PulsatorLayout pulsator = (PulsatorLayout) findViewById(R.id.pulsator);
        pulsator.start();


        PulsatorLayout pulsator1 = (PulsatorLayout) findViewById(R.id.pulsator2);
        pulsator1.start();


        PulsatorLayout pulsator2 = (PulsatorLayout) findViewById(R.id.pulsator3);
        pulsator2.start();









amount=findViewById(R.id.amount);
sendmoney=findViewById(R.id.SendMoney);
sendmoney.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        String amountstring=amount.getText().toString();

        Log.d("", "onClick: +");
        DatabaseHelperNewNode newNodeReq=new DatabaseHelperNewNode(SendToMiner.this);
int m=newNodeReq.Delet();
     Boolean a=  newNodeReq.insertData(Sender,Reciver,amountstring,"","","","","");


if(a==true){


    Toast.makeText(getBaseContext(),"Ledger Created : NewNode",Toast.LENGTH_SHORT).show();
    selectedImage = Uri.fromFile(new File("/mnt/sdcard/newnode.db"));
    uploadImage();





            }





    }
});









































    }

    private void MyWalletintent() {


        Intent intent=new Intent(SendToMiner.this,MyWallet.class);
        startActivity(intent);
    }

    private void blockchainintent() {


        Intent intent=new Intent(SendToMiner.this,BlockChain2.class);
        startActivity(intent);
    }

    private void miningintent() {


        Intent intent=new Intent(SendToMiner.this,Mining2.class);
        startActivity(intent);
    }
    private void sendtominerintent() {


        Intent intent=new Intent(SendToMiner.this,SendToMiner.class);
        startActivity(intent);
    }







    public void uploadImage() {
storageRef=FirebaseStorage.getInstance().getReference();

        imageRef = storageRef.child("blockchain"+"/"+"MiningRequest"+"/"+Sender);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMax(100);
        progressDialog.setMessage("Uploading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
        progressDialog.setCancelable(false);
        //starting upload
        uploadTask = imageRef.putFile(selectedImage);
        // Observe state change events such as progress, pause, and resume
        uploadTask.addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
                //sets and increments value of progressbar
                progressDialog.incrementProgressBy((int) progress);
            }
        });
        // Register observers to listen for when the download is done or if it fails
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
                Toast.makeText(getBaseContext(),"Error in uploading!",Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                //   down = taskSnapshot.getDownloadUrl();


                Toast.makeText(getBaseContext(),"Upload successful",Toast.LENGTH_SHORT).show();


                progressDialog.dismiss();
                DownRef = storageRef.child("blockchain"+"/"+"MiningRequest"+"/"+Sender+"/");
                DownRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();

databaseReference.child("MiningRequest").child(Sender).setValue(uri.toString());






                    }
                });
            }
        });

    }

    /**
     * Fires an intent to spin up the "file chooser" UI and select an image.
     */
    public void performFileSearch() {

        // ACTION_OPEN_DOCUMENT is the intent to choose a file via the system's file
        // browser.
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);

        // Filter to only show results that can be "opened", such as a
        // file (as opposed to a list of contacts or timezones)
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        // Filter to show only images, using the image MIME data type.
        // If one wanted to search for ogg vorbis files, the type would be "audio/ogg".
        // To search for all documents available via installed storage providers,
        // it would be "*/*".
       // intent.setType("image/*");
        intent.setType("*/*");

        startActivityForResult(intent, READ_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,
                                 Intent resultData) {

        // The ACTION_OPEN_DOCUMENT intent was sent with the request code
        // READ_REQUEST_CODE. If the request code seen here doesn't match, it's the
        // response to some other intent, and the code below shouldn't run at all.

        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // The document selected by the user won't be returned in the intent.
            // Instead, a URI to that document will be contained in the return intent
            // provided to this method as a parameter.
            // Pull that URI using resultData.getData().
            Uri uri = null;
            if (resultData != null) {
                selectedImage = resultData.getData();
                uploadImage();
            }
        }
    }






    public static final String md5(final String toEncrypt) {
        try {
            final MessageDigest digest = MessageDigest.getInstance("md5");
            digest.update(toEncrypt.getBytes());
            final byte[] bytes = digest.digest();
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(String.format("%02X", bytes[i]));
            }
            return sb.toString().toLowerCase();
        } catch (Exception exc) {
            return ""; // Impossibru!
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        navDrawerOpen();
        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }


    public void   navDrawerOpen(){


        NvaisOpen++;
        if(NvaisOpen%2==0){

            findViewById(R.id.SendMoney).setVisibility(View.VISIBLE);
            findViewById(R.id.amount).setVisibility(View.VISIBLE);

        findViewById(R.id.h).setVisibility(View.VISIBLE);
        }else

        {
            findViewById(R.id.SendMoney).setVisibility(View.INVISIBLE);
            findViewById(R.id.amount).setVisibility(View.INVISIBLE);
        findViewById(R.id.h).setVisibility(View.INVISIBLE);

        }


    }

}
