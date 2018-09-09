package com.example.root.blockchain;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Environment;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
FloatingActionButton addblock;
public static ArrayList<ModelBlocks> blockchain =new ArrayList<ModelBlocks>();
RecyclerView recyclerView;
public  MyAdapter2 myAdapter;

public          int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    showDialog(this,"A");














        addblock=findViewById(R.id.add);
addblock.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        showDialog(MainActivity.this,"A");



    }
});


        generateNoteOnSD(this,"A","a");











 }


    private void NewBlock(String data) {

 if(blockchain.size()==0)
        {
            String prevHash="0";
            Long tsLong = System.currentTimeMillis()/1000;
            String ts = tsLong.toString();
            String hash=md5(data+prevHash+ts);




   ModelBlocks blocks=new ModelBlocks(data,hash,prevHash,ts);


    blockchain.add(blocks);








            Log.d("A", "NewBlock:"+data);
            Log.d("A", "NewBlock:"+ts);
            Log.d("A", "NewBlock:"+prevHash);
            Log.d("A", "NewBlock:"+hash);

       LinearLayoutManager     linearLayoutManager=new LinearLayoutManager(MainActivity.this);
            RecyclerView mMessageList= (RecyclerView) findViewById(R.id.rec);

            mMessageList.setHasFixedSize(true);
            mMessageList.setLayoutManager(linearLayoutManager);
            myAdapter=new MyAdapter2(blockchain,MainActivity.this);
            mMessageList.setAdapter(myAdapter);
            myAdapter.notifyDataSetChanged();




        }
else {



     String prevHash=blockchain.get(blockchain.size()-1).getHash();
     Long tsLong = System.currentTimeMillis()/1000;
     String ts = tsLong.toString();
     String hash=md5(data+prevHash+ts);


     ModelBlocks blocks=new ModelBlocks(data,hash,prevHash,ts);

     blockchain.add(blocks);





     Log.d("A", "NewBlock:"+data);
     Log.d("A", "NewBlock:"+ts);
     Log.d("A", "NewBlock:"+prevHash);
     Log.d("A", "NewBlock:"+hash);











 }









    final Handler handler = new Handler();

        final Runnable r = new Runnable() {
            public void run() {
          //  check();


                handler.postDelayed(this, 1000);
            }
        };

        handler.postDelayed(r, 1000);















    }

    private void check() {
        int s=blockchain.size();



        for (int i=1;i<s;i++){



            if(!blockchain.get(i).getPrevhash().equals(blockchain.get(i-1).getHash())){

            //    Toast.makeText(getBaseContext(),"A",Toast.LENGTH_SHORT).show();



                myAdapter.notifyDataSetChanged();
            }




            {

              //  Toast.makeText(getBaseContext(),"A",Toast.LENGTH_SHORT).show();

                myAdapter.notifyDataSetChanged();
            } }















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









    public void showDialog(Activity activity, String msg){

        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.addnew, null);




        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Info");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
        final EditText Tdata=alertLayout.findViewById(R.id.editText);


        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setPositiveButton("Done", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

String data=Tdata.getText().toString();

                NewBlock(data);





            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }





    public void generateNoteOnSD(Context context, String sFileName, String sBody) {
        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, sFileName);
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(sBody);
            writer.flush();
            writer.close();
            Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



















}









