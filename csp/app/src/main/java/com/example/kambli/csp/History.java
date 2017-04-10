package com.example.kambli.csp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        TextView t16=(TextView)findViewById(R.id.textView16);
        t16.setMovementMethod(new ScrollingMovementMethod());


    }
}
