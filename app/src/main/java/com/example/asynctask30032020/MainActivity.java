package com.example.asynctask30032020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    Button mBtn;
    TextView mTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn = findViewById(R.id.button);
        mTv = findViewById(R.id.textview);


        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ReadJSON().execute();
            }
        });
    }
    //1 : Params : kieu du lieu truyen vao de xu ly trong doInbackground
    //2 : Progress : kieu du lieu de cap nhat giao dien khi xu ly trong doInbackground
    //3 : Result : kieu du lieu cua gia tri sau khi xu ly logic
    class ReadJSON extends AsyncTask<Void,Void,String>{


        @Override
        protected String doInBackground(Void... voids) {
            return docNoiDung_Tu_URL("https://khoapham.vn/KhoaPhamTraining/json/tien/demo1.json");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("BBB",s);
        }
    }

    private String docNoiDung_Tu_URL(String theUrl){
        StringBuilder content = new StringBuilder();
        try    {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null){
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)    {
            e.printStackTrace();
        }
        return content.toString();
    }


}