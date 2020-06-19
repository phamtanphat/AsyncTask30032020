package com.example.asynctask30032020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
                new MyWordAsync().execute();
            }
        });
        // Bắt đầu xử lý
            // Công việc 1
            // Công việc 2
            // Công việc 3
            // Công việc 4
            // Công việc 5
        // Hoàn tất
    }
    //1 : Params : kieu du lieu truyen vao de xu ly trong doInbackground
    //2 : Progress : kieu du lieu de cap nhat giao dien khi xu ly trong doInbackground
    //3 : Result : kieu du lieu cua gia tri sau khi xu ly logic
    class MyWordAsync extends AsyncTask<Void,String,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mTv.setText("Bắt đầu thực thi \n");
        }

        @Override
        protected String doInBackground(Void... voids) {
            for (int i = 1 ; i <= 5 ; i++){
                publishProgress("Công việc thứ " + i + "\n");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return "Hoàn tất";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            mTv.append(values[0]);
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            mTv.append(s);
        }
    }
}