package com.example.root.blockchain;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


import com.example.root.blockchain.ModelBlocks;
import com.example.root.blockchain.R;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Atharva on 1/16/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context ctx;


    int FinInt;
    int iLike = 0, i;


    public static String memeoftheday;
    public static String uid;


    ArrayList<ModelBlocks> RevList = new ArrayList<ModelBlocks>();

    public MyAdapter(ArrayList<ModelBlocks> RevList, Context ctx) {
        this.RevList = RevList;
        this.ctx = ctx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.block, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {


        holder.data.setText(RevList.get(position).getData());


        holder.data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                LayoutInflater inflater = LayoutInflater.from(ctx);
                View alertLayout = inflater.inflate(R.layout.blockinfo, null);

                android.support.v7.app.AlertDialog.Builder alert = new android.support.v7.app.AlertDialog.Builder(ctx);
                alert.setTitle("Info");
                // this is set the view from XML inside AlertDialog
                alert.setView(alertLayout);
                // disallow cancel of AlertDialog on click of back button and outside touch
                alert.setCancelable(false);


                TextView hash, prevhash, ts;
                final EditText data;
                data = alertLayout.findViewById(R.id.textView2);
                hash = alertLayout.findViewById(R.id.hash);
                prevhash = alertLayout.findViewById(R.id.prevhash);
                ts = alertLayout.findViewById(R.id.ts);

                data.setText(RevList.get(position).getData());
                hash.setText(RevList.get(position).getHash());
                prevhash.setText(RevList.get(position).getPrevhash());
                ts.setText(RevList.get(position).getTimestamp());


                final android.support.v7.app.AlertDialog dialog = alert.create();

                dialog.show();


                data.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                        Long tsLong = System.currentTimeMillis() / 1000;
                        String ts = tsLong.toString();


                        String hash = md5(s.toString() + RevList.get(position).getPrevhash() + ts);

                        RevList.get(position).setHash(hash);
                        RevList.get(position).setData(s.toString());

                    }
                });


                alertLayout.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();
                        int s=RevList.size();



                        for (int i=1;i<s;i++){



                            if(!RevList.get(i).getPrevhash().equals(RevList.get(i-1).getHash())){

                                Log.d("A", "onBindViewHolder: ");
                                holder.  back.setBackground(ctx.getResources().getDrawable(R.drawable.gradblue));
                            }



                            if(!RevList.get(i-1).getHash().equals(RevList.get(i).getPrevhash())){

                                holder.  back.setBackground(ctx.getResources().getDrawable(R.drawable.gradblue));
                                Log.d("A", "onBindViewHolder: ");

                            }







                            

                        }



                    }
                });


            }
        });
















    }

    @Override
    public int getItemCount() {
        return RevList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView data;
        ConstraintLayout back;

        public MyViewHolder(View itemView) {
            super(itemView);
            data = itemView.findViewById(R.id.data);
back=itemView.findViewById(R.id.back);
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



    public void check(){


    }



}
