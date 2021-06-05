package com.example.prattoy.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class ScheduleActivity extends AppCompatActivity implements View.OnClickListener {

    public Button buttonr, buttont, buttonf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        buttonr = (Button) findViewById(R.id.button1);
        buttont = (Button) findViewById(R.id.button2);
        buttonf = (Button) findViewById(R.id.button3);

    }

    @Override
    public void onClick(View v) {
        if (v == buttonr)
        {
            Intent intent = new Intent(ScheduleActivity.this, RegularDays.class);
            startActivity(intent);
        }
        else if (v==buttont || v == buttonf)
        {
            Toast.makeText(this, "Still not added", Toast.LENGTH_LONG).show();
        }

    }
}
