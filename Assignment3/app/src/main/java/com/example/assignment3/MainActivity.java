package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText e1,e2;
Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.a);
        e2=findViewById(R.id.b);
        b1=findViewById(R.id.c);
        b2=findViewById(R.id.d);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1,s2;
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                if(s1.isEmpty()&& s2.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Enter User Name and password", Toast.LENGTH_SHORT).show();
                }
                else if (s1.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter User Name", Toast.LENGTH_SHORT).show();
                }
                else if(s2.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent i=new Intent(MainActivity.this,Activity2.class);
                    i.putExtra("Val",s1);
                    startActivity(i);
                }


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Activity3.class);
                startActivity(i);
            }
        });
    }
}