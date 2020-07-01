package com.example.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView tv1,tv2;
Button b1,b2,b3,b4,b5,b6,b7;
int t1,t2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=findViewById(R.id.a);
        tv2=findViewById(R.id.b);
        b1=findViewById(R.id.c);
        b2=findViewById(R.id.d);
        b3=findViewById(R.id.e);
        b4=findViewById(R.id.f);
        b5=findViewById(R.id.g);
        b6=findViewById(R.id.h);
        b7=findViewById(R.id.r);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1+=3;
                tv1.setText(""+t1);


            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1+=2;
                tv1.setText(""+t1);


            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1+=1;
                tv1.setText(""+t1);


            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2+=3;
                tv2.setText(""+t2);


            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2+=2;
                tv2.setText(""+t2);


            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2+=1;
                tv2.setText(""+t2);


            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1=t2=0;
               tv1.setText(""+t1);
                tv2.setText(""+t2);


            }
        });

       if(savedInstanceState!=null)
       {
           String s1,s2;
           s1=savedInstanceState.getString("Val1");
           s2=savedInstanceState.getString("Val2");
           tv1.setText(s1);
           tv2.setText(s2);
           t1=Integer.parseInt(s1);
           t2=Integer.parseInt(s2);


       }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Val1",tv1.getText().toString());
        outState.putString("Val2",tv2.getText().toString());

    }
}