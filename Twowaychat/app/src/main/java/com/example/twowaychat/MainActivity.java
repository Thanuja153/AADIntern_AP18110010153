package com.example.twowaychat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView t1,t2;
    EditText e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.a);
                t2=findViewById(R.id.b);
                e=findViewById(R.id.c);
    }

    public void send(View view) {
        String s=e.getText().toString();
        if(s.isEmpty())
        {
            Toast.makeText(this, "Enter Message", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent i=new Intent(MainActivity.this,Activity2.class);
            i.putExtra("n",s);
            e.setText("");
            startActivityForResult(i,1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            if(resultCode==RESULT_OK)
            {
                String result=data.getStringExtra("s");
                t2.setText(result);
                t1.setVisibility(View.VISIBLE);
            }
        }
    }
}