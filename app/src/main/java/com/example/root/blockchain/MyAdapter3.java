package com.example.root.blockchain;


import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;
import java.util.ArrayList;


/**
 * Created by Atharva on 1/16/2018.
 */

public class MyAdapter3 extends RecyclerView.Adapter<MyAdapter3.MyViewHolder> {
    Context ctx;


    ArrayList<Block> Blockchain = new ArrayList<Block>();

    public MyAdapter3(ArrayList<Block> Blockchain, Context ctx) {
        this.Blockchain = Blockchain;
        this.ctx = ctx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.blockwithindfo, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {




            if (Blockchain.get(position).getIsvalid() == false) {

              holder.linearLayout.setBackground(ctx.getResources().getDrawable(R.drawable.gradcherry));
            }

else { holder.linearLayout.setBackground(ctx.getResources().getDrawable(R.drawable.gradblue));


            }







        holder.Count.setText(position+"");
        holder.Data.setText(Blockchain.get(position).data);
        holder.hash.setText(Blockchain.get(position).hash);
        holder.prevHash.setText(Blockchain.get(position).prevHash);
        holder.Nonce.setText(Blockchain.get(position).nonce+"");




holder.Mine.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Blockchain.get(position).setData(holder.Data.getText().toString());
        String data=Blockchain.get(position).getData();
        String prevHash=Blockchain.get(position).getPrevHash();
        String ts=Blockchain.get(position).getTimeStamp();

        int nonce=0;
        while (!md5(data+prevHash+position+ts+nonce).contains("01"))
        {



            nonce++;
        }
        String Hash=md5(data+prevHash+position+ts+nonce);
        Blockchain.get(position).setHash(Hash);



    }
});














/*


        holder.Mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             if(position==0){
                 String data=holder.Data.getText().toString();

                Long tsLong = System.currentTimeMillis() / 1000;
                String ts = tsLong.toString();
                String prevHash="000000000000000000";

int nonce=0;
                while (!md5(data+prevHash+position+ts+nonce).contains("01"))
                {



                    nonce++;

                }


String Hash=md5(data+prevHash+position+ts+nonce);


                Blockchain.get(position).setData(data);
                Blockchain.get(position).setHash(md5(data+prevHash+position+ts+nonce));
                Blockchain.get(position).setId(position);
                Blockchain.get(position).setNonce(nonce);
                Blockchain.get(position).setPrevHash(prevHash);




                holder.Count.setText(position+"");
                holder.Data.setText(data);
                holder.hash.setText(Hash);
                holder.prevHash.setText(prevHash);
                holder.Nonce.setText(nonce+"");












        }else {


                 String data=holder.Data.getText().toString();

                 Long tsLong = System.currentTimeMillis() / 1000;
                 String ts = tsLong.toString();
                 String prevHash=Blockchain.get(position-1).hash;

                 int nonce=0;
                 while (!md5(data+prevHash+position+ts+nonce).contains("01"))
                 {



                     nonce++;

                 }


                 String Hash=md5(data+prevHash+position+ts+nonce);


                 Blockchain.get(position).setData(data);
                 Blockchain.get(position).setHash(md5(data+prevHash+position+ts+nonce));
                 Blockchain.get(position).setId(position);
                 Blockchain.get(position).setNonce(nonce);
                 Blockchain.get(position).setPrevHash(prevHash);

                 holder.Count.setText(position+"");
                 holder.Data.setText(data);
                 holder.hash.setText(Hash);
                 holder.prevHash.setText(prevHash);
                 holder.Nonce.setText(nonce+"");





             }







            }


*/











//        });





























    }

    @Override
    public int getItemCount() {
        return Blockchain.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        EditText Data;
        TextView hash;
        TextView prevHash;
        TextView Count;
        ConstraintLayout back;
FloatingActionButton Mine;
LinearLayout linearLayout;

TextView Nonce;
        public MyViewHolder(View itemView) {
            super(itemView);
            Data=itemView.findViewById(R.id.data);
            hash=itemView.findViewById(R.id.hash);
            prevHash=itemView.findViewById(R.id.prevhash);
            Count=itemView.findViewById(R.id.count);

            back=itemView.findViewById(R.id.back);
Mine=itemView.findViewById(R.id.Mine);

linearLayout=itemView.findViewById(R.id.lin);
Nonce=itemView.findViewById(R.id.Nonce);



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




}













