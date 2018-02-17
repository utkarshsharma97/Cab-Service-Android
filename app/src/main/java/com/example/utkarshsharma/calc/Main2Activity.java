package com.example.utkarshsharma.calc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity {

    TextView tvid;
    EditText email;
    EditText first;
    EditText last;
    EditText password;
    Button btnSignup;
    TextView abc;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setupUIviews();
        String data=getIntent().getStringExtra("username");
        tvid.setText("\n" +data+"\n\nWelcome to ONLINE CAB BOOKING!");
        mAuth = FirebaseAuth.getInstance();
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    //data stored here
                    String mail=email.getText().toString().trim();
                    String pass=password.getText().toString().trim();
                    mAuth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            //addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(Main2Activity.this, "unregistered",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                    else{
                                    Toast.makeText(Main2Activity.this, "registered",
                                            Toast.LENGTH_SHORT).show();
                                }}
                            });
                }
            }
        });

        abc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main2Activity.this,com.example.utkarshsharma.calc.Main4Activity.class);
                startActivity(intent);
            }
        });


    }
    private void setupUIviews(){
        first=(EditText)findViewById(R.id.first);
        last=(EditText)findViewById(R.id.last);
        password=(EditText)findViewById(R.id.password);
        email=(EditText)findViewById(R.id.email);
        tvid=(TextView)findViewById(R.id.tvid);
        abc=(TextView)findViewById(R.id.abc);
        btnSignup=(Button)findViewById(R.id.btnSignup);
    }

    private Boolean validate(){
        Boolean result=false;
        String fname= first.getText().toString();
        String lname= last.getText().toString();
        String mail= email.getText().toString();
        String pass= password.getText().toString();
        if(fname.isEmpty() && lname.isEmpty() && mail.isEmpty() && pass.isEmpty()){
            Toast.makeText(this, "Please fill the details first", Toast.LENGTH_SHORT).show();
        }
        else{
            result=true;
        }
        return result;

    }

}
