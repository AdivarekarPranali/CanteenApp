package com.vjti.canteenapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn_reg = (Button) findViewById(R.id.btn_reg);

        btn_reg.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                next_page(v);
            }
        });
    }
    public void next_page(View v) {
        Intent intent = new Intent(this, UpdateAmtActivity.class);
        startActivity(intent);
    }

}
