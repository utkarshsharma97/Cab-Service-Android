package com.example.utkarshsharma.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity implements ListFrag.ActionListener{
    TextView tvdetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tvdetails=(TextView)findViewById(R.id.tvdetails);
    }

    @Override
    public void onActionSelected(int index) {
        String [] descriptions=getResources().getStringArray(R.array.Description);
    tvdetails.setText((descriptions[index]));
    }
}
