package com.example.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView tv;
Button f,g,h,i;
int add=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.a);
        f=findViewById(R.id.b);
        g=findViewById(R.id.c);
        h=findViewById(R.id.d);
        i=findViewById(R.id.e);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add++;
                tv.setText(""+add);

            }
        });
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add--;
                tv.setText(""+add);

            }
        });

        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add=0;
                tv.setText(""+add);

            }
        });

        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, ""+add, Toast.LENGTH_SHORT).show();

            }
        });
        if(savedInstanceState!=null)
        {
            String s=savedInstanceState.getString("Val");
            tv.setText(s);
            add=Integer.parseInt(s);
        }







    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Val",tv.getText().toString());
    }
}
