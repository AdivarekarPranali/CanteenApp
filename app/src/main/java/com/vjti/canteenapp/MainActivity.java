package com.vjti.canteenapp;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
/*
    public void init() {
        TableLayout tl = (TableLayout) findViewById(R.id.menu_table);

        for (int i = 0; i < 2; i++) {
            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            CheckBox checkBox = new CheckBox(this);
            TextView tv = new TextView(this);
            TextView qty = new TextView(this);
            checkBox.setText("hello");
            qty.setText("10");
            row.addView(checkBox);
            row.addView(qty);
            tl.addView(row,i);

        }
    }*/
}