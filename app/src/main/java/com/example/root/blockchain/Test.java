package com.example.root.blockchain;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.downloader.Error;
import com.downloader.OnCancelListener;
import com.downloader.OnDownloadListener;
import com.downloader.OnPauseListener;
import com.downloader.OnProgressListener;
import com.downloader.OnStartOrResumeListener;
import com.downloader.PRDownloader;
import com.downloader.PRDownloaderConfig;
import com.downloader.Progress;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Test extends AppCompatActivity {
String Hash;
String me="b";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);




        DatabaseHelperTrans mydb=new DatabaseHelperTrans(this);


        int money=0;
        Cursor res = mydb.getAllData();
        if(res.getCount() == 0) {
        }
        while (res.moveToNext()) {

           if(res.getString(2).equals(me)){


               int add= Integer.parseInt(res.getString(3));
               money=money+add;

           }


/*
            Log.d("A", "Total Money" + money);
*/

            /*Position=res.getString(0);
            Sender=res.getString(1);
            Reciver=res.getString(2);
            Value=res.getString(3);
            Hash=res.getString(4);
            PrevHash=res.getString(5);
            timestamp=res.getString(6);
            nonce=res.getString(7);


            StringBuffer buffer = new StringBuffer();

            buffer.append(Position+"\n");
            buffer.append(Sender+"\n");
            buffer.append(Reciver+"\n");
            buffer.append(Value+"\n");
            buffer.append(Hash+"\n");
            buffer.append(PrevHash+"\n");
            buffer.append(timestamp+"\n");
            buffer.append(nonce+"\n");*/


        }


        Log.d("A", "Total Money"+money);

















/*

*/
/*

        PRDownloader.initialize(getApplicationContext());

        PRDownloaderConfig config = PRDownloaderConfig.newBuilder()
                .setDatabaseEnabled(true)
                .build();
        PRDownloader.initialize(getApplicationContext(), config);

// Setting timeout globally for the download network requests:
         config = PRDownloaderConfig.newBuilder()
                .setReadTimeout(30_000)
                .setConnectTimeout(30_000)
                .build();
        PRDownloader.initialize(getApplicationContext(), config);
        int downloadId = PRDownloader.download("https://firebasestorage.googleapis.com/v0/b/monk-83fbf.appspot.com/o/blockchain%2Fblockchain?alt=media&token=ef926884-44bd-4424-a49d-20ef332c528c", "/mnt/sdcard/", "bloc.db")
                .build()
                .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                    @Override
                    public void onStartOrResume() {

                    }
                })
                .setOnPauseListener(new OnPauseListener() {
                    @Override
                    public void onPause() {

                    }
                })
                .setOnCancelListener(new OnCancelListener() {
                    @Override
                    public void onCancel() {

                    }
                })
                .setOnProgressListener(new OnProgressListener() {
                    @Override
                    public void onProgress(Progress progress) {

                    }
                }).start(new OnDownloadListener() {
                    @Override
                    public void onDownloadComplete() {
                        Toast.makeText(getBaseContext(),"A",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Error error) {

                    }
                });

*//*


DatabaseHelperTrans mydb=new DatabaseHelperTrans(Test.this);
mydb.Delet();

mydb.insertData("a","b","20","aa","aa","122","12");
mydb.insertData("a","b","20","aa","aa","122","12");
mydb.insertData("a","b","20","aa","aa","122","12");
mydb.insertData("a","b","20","aa","aa","122","12");





*/
/*

        String a="fgffgffffffgnnbff776";
        int nonce=0;
       Hash=md5(a+nonce);


        while (!Hash.substring(0,3).contains("000"))
        {



            nonce++;
            Log.d("a", ""+nonce);
            Hash=md5(a+nonce);


        }

        Toast.makeText(getBaseContext(),nonce+"",Toast.LENGTH_SHORT).show();
*/









































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
    public static String SHA256 (String text) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("SHA-256");

        md.update(text.getBytes());
        byte[] digest = md.digest();

        return Base64.encodeToString(digest, Base64.DEFAULT);
    }


}
