package com.example.utkarshsharma.calc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText id1;
    Button btnid1;
    Button button3;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id1=(EditText)findViewById(R.id.id1);
        btnid1=(Button) findViewById(R.id.btnid1);
        button3=(Button) findViewById(R.id.button3);
        button2=(Button) findViewById(R.id.button2);
        btnid1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=id1.getText().toString().trim();
                Intent intent=new Intent(MainActivity.this,com.example.utkarshsharma.calc.Main2Activity.class);
                intent.putExtra("username",name);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,com.example.utkarshsharma.calc.Main3Activity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,com.example.utkarshsharma.calc.Main4Activity.class);
                startActivity(intent);
            }
        });
    }
}
