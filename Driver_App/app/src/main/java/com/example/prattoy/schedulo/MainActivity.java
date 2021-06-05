package com.example.prattoy.schedulo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private int p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progress);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                proceed();
            }


        });
        thread.start();
    }
    public void doWork(){
        for (p=20; p<=100; p+=20) {
            try {
                Thread.sleep(500);
                progressBar.setProgress(p);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void proceed() {
        Intent intent = new Intent(MainActivity.this, LocationActivity.class);
        startActivity(intent);
        finish();
    }

}