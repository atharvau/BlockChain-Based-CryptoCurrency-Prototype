package com.example.root.blockchain;

import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.MessageDigest;
import java.util.ArrayList;

public class BlockChain2 extends AppCompatActivity {
FloatingActionButton addblock;
public  static  ArrayList<Block>blockchain=new ArrayList<Block>();
MyAdapter3 myAdapter3;
RecyclerView Rec;
ArrayList<Integer>arrayList=new ArrayList<Integer>();


int s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block_chain2);
FirebaseApp.initializeApp(this);

        myAdapter3=new MyAdapter3(blockchain,BlockChain2.this);


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(BlockChain2.this);
        Rec= (RecyclerView) findViewById(R.id.rec);

        Rec.setHasFixedSize(true);
        Rec.scrollToPosition(blockchain.size()-1);
        Rec.setLayoutManager(linearLayoutManager);
        myAdapter3=new MyAdapter3(blockchain,BlockChain2.this);
        Rec.setAdapter(myAdapter3);


        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference();
        databaseReference.child("A").setValue("A");





         DatabaseHelper myDb=new DatabaseHelper(this);
        boolean isInserted = myDb.insertData("A",
                "C",
                "a","A","A");
        if(isInserted == true)
            Toast.makeText(BlockChain2.this,"Data Inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(BlockChain2.this,"Data not Inserted",Toast.LENGTH_LONG).show();



















findViewById(R.id.floatingActionButton3).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(getBaseContext(),"A",Toast.LENGTH_SHORT).show();

        for (int i=1;i<s;i++){


            if(!blockchain.get(i).getPrevHash().equals(blockchain.get(i-1).getHash())){
Toast.makeText(getBaseContext(),"A"+i,Toast.LENGTH_SHORT).show();
             //   Log.d("A", "onBindViewHolder: ");setTitle("A"+i);
            }



            if(!blockchain.get(i-1).getHash().equals(blockchain.get(i).getPrevHash())){

                Log.d("A", "onBindViewHolder: ");


                setTitle("A"+i);
            }





        }
















    }
});












        addblock=findViewById(R.id.floatingActionButton);







addblock.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
if(blockchain.size()==0){
        String data="a";
        Long tsLong = System.currentTimeMillis() / 1000;
        String ts = tsLong.toString();
        String prevHash="0000000000";
        int position = 0;

        int nonce=0;
        while (!md5(data+prevHash+position+ts+nonce).contains("01"))
        {



            nonce++;
            }
String Hash=md5(data+prevHash+position+ts+nonce);
    Block block=new Block(0,data,ts,nonce,Hash,prevHash,true);
    block.save();

    blockchain.add(block);

    Block book = Block.findById(Block.class, Long.valueOf(0));

Toast.makeText(getBaseContext(),block.getNonce()+"",Toast.LENGTH_SHORT).show();
    myAdapter3.notifyDataSetChanged();




}

else
{



    String data="a";
    Long tsLong = System.currentTimeMillis() / 1000;
    String ts = tsLong.toString();
    String prevHash=blockchain.get(blockchain.size()-1).getHash();
    int position = 0;

    int nonce=0;
    while (!md5(data+prevHash+position+ts+nonce).contains("01"))
    {



        nonce++;
    }
    String Hash=md5(data+prevHash+position+ts+nonce);
    Block block=new Block(0,data,ts,nonce,Hash,prevHash,true);

    blockchain.add(block);
    block.save();




myAdapter3.notifyDataSetChanged();




}










    }
});








        findViewById(R.id.floatingActionButton2).setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
             /*   blockchain.get(1).setData("A");
                String data=blockchain.get(1).getData();
                String prevHash=blockchain.get(1).getPrevHash();
                int position=1;
                String ts=blockchain.get(1).getTimeStamp();

                int nonce=0;
                while (!md5(data+prevHash+position+ts+nonce).contains("01"))
                {



                    nonce++;
                }
                String Hash=md5(data+prevHash+position+ts+nonce);
                blockchain.get(1).setHash(Hash);

*/


                Validate();




            }
        });






        final Handler handler = new Handler();

        final Runnable r = new Runnable() {
            public void run() {
           //  check();


                handler.postDelayed(this, 1000);
            }
        };

        handler.postDelayed(r, 1000);















    }

    private void Validate() {
/*




        for (int i=0;i<blockchain.size();i++){

            if (i<blockchain.size())
            {
String data=blockchain.get(i).getData();
String prevHash=blockchain.get(i).getPrevHash();
int position=i;
String ts=blockchain.get(i).getTimeStamp();

                int nonce=0;
                while (!md5(data+prevHash+position+ts+nonce).contains("01"))
                {



                    nonce++;
                }
                String Hash=md5(data+prevHash+position+ts+nonce);
                blockchain.get(i).setHash(Hash);






            }


*/




























/*


for(int i=0;i<blockchain.size();i++) {
    int nonce = 0;
    while (!md5(blockchain.get(i).getData() + blockchain.get(i).getPrevHash()+ i + blockchain.get(i).getTimeStamp()+ nonce).contains("01")) {


        nonce++;
    }
    String Hash = md5(blockchain.get(i).getData() + blockchain.get(i).getPrevHash()+ i + blockchain.get(i).getTimeStamp()+ nonce);

    blockchain.get(i).setHash(Hash);
*/

 /*  // blockchain.get(i).setTimeStamp(ts);

int k=1;


for( k=2;k<blockchain.size();k++){

    if (!blockchain.get(k).getPrevHash().equals(blockchain.get(k - 1).getHash())) {


        if(k!=blockchain.size()-1){
            for(k=0;k<blockchain.size()-1;k++){

                blockchain.get(k).setIsvalid(Boolean.FALSE);

            }




        }
    }
}


if(k!=blockchain.size()-1){
    for(k=0;k<blockchain.size()-1;k++){

        blockchain.get(k).setIsvalid(Boolean.FALSE);

    }

*/


//}



        int jk=isChainValid();
        if(jk!=99){




            for (int kl=jk;kl<blockchain.size();kl++){


                blockchain.get(kl).setIsvalid(false);



            }



            myAdapter3.notifyDataSetChanged();



} }











    private void check() {


        for (int i = 1; i < s; i++) {

            if (blockchain.get(i).getPrevHash() != null && blockchain.get(i - 1).getHash() != null) {
                if (!blockchain.get(i).getPrevHash().equals(blockchain.get(i - 1).getHash())) {

                    for (int j = i; j < s; j++) {


                        Toast.makeText(getBaseContext(),""+j,Toast.LENGTH_SHORT).show();

                    }
                }


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





    public int isChainValid() {
        Block currentBlock;
        Block previousBlock;

        //loop through blockchain to check hashes:
        for(int i=1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            //compare registered hash and calculated hash:
            if(!currentBlock.hash.equals(currentBlock.getHash()) ){


Toast.makeText(BlockChain2.this,i+"",Toast.LENGTH_SHORT).show();
                return i;
            }
            //compare previous hash and registered previous hash
            if(!previousBlock.hash.equals(currentBlock.getPrevHash()) ) {
int k=i-1;

                Toast.makeText(BlockChain2.this,k+"",Toast.LENGTH_SHORT).show();

                return i-1;
            }
        }
        return 99;
    }







}
