package com.example.twowaychat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
TextView tv;
EditText et;
Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        tv=findViewById(R.id.t);
                et=findViewById(R.id.et);
                b1=findViewById(R.id.bt);
                String s=getIntent().getStringExtra("n");
                tv.setText(""+s);
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String s=et.getText().toString();
                        if(s.isEmpty())
                        {
                            Toast.makeText(Activity2.this, "Enter Message", Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                            Intent i=new Intent();
                            i.putExtra("s",s);
                            setResult(RESULT_OK,i);
                            finish();
                        }
                    }
                });}
}