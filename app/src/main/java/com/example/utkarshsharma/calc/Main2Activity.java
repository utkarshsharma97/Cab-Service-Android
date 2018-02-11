package com.example.utkarshsharma.calc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tvid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvid=(TextView)findViewById(R.id.tvid);
        String data=getIntent().getStringExtra("username");
        tvid.setText("\n" +data+"\n\nWelcome to ONLINE CAB BOOKING!");
    }

}
