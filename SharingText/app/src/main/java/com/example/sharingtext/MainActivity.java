package com.example.sharingtext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.a);

    }

    public void share(View view) {
        String c,d;
        c=b.getText().toString();
        d="text/plain";
        ShareCompat.IntentBuilder.from(this).setType(d).setChooserTitle("Share Text").setText(c).startChooser();
    }
}