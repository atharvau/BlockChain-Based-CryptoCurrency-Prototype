package com.example.root.blockchain;


import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.security.MessageDigest;
import java.util.ArrayList;


/**
 * Created by Atharva on 1/16/2018.
 */

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {
    Context ctx;


    ArrayList<ModelBlocks> RevList = new ArrayList<ModelBlocks>();

    public MyAdapter2(ArrayList<ModelBlocks> RevList, Context ctx) {
        this.RevList = RevList;
        this.ctx = ctx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.blockwithindfo, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {


holder.Data.setText(RevList.get(position).getData());

holder.Count.setText("#"+position);

holder.hash.setText(RevList.get(position).getHash());
holder.prevHash.setText(RevList.get(position).getPrevhash());


holder.Data.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {





    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

RevList.get(position).setData(s.toString());
        Long tsLong = System.currentTimeMillis() / 1000;
        String ts = tsLong.toString();
 String hash = md5(s.toString() + RevList.get(position).getPrevhash() + ts);

        RevList.get(position).setHash(hash);




        holder.hash.setText(RevList.get(position).getHash());



















    }
});



if(position!=0) {

    if (!RevList.get(position).getPrevhash().equals(RevList.get(position - 1).getHash())) {

        Log.d("A", "onBindViewHolder: ");
        holder.back.setBackground(ctx.getResources().getDrawable(R.drawable.shadowred));
    }


    if (!RevList.get(position - 1).getHash().equals(RevList.get(position).getPrevhash())) {

        holder.back.setBackground(ctx.getResources().getDrawable(R.drawable.shadowred));
        Log.d("A", "onBindViewHolder: ");

    }


}








    }

    @Override
    public int getItemCount() {
        return RevList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
      EditText Data;
      TextView hash;
      TextView prevHash;
      TextView Count;
      ConstraintLayout back;


        public MyViewHolder(View itemView) {
            super(itemView);
          Data=itemView.findViewById(R.id.data);
          hash=itemView.findViewById(R.id.hash);
          prevHash=itemView.findViewById(R.id.prevhash);
          Count=itemView.findViewById(R.id.count);

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


















}

