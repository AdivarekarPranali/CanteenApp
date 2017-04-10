package com.vjti.canteenapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by DBS19 on 04-04-2017.
 */
public class tab2update extends Fragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.tab2update,  container, false);


        //setContentView(R.layout.tab1add);

        final Button btn_set_menu = (Button) view.findViewById(R.id.btn_set_menu);
        //et_dishname   = (EditText)view.findViewById(R.id.et_dishname);
        //et_price = (EditText)view.findViewById(R.id.et_price);

        btn_set_menu.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        //Log.v("EditText", mEdit.getText().toString());
                        //Menu menu = new Menu(et_dishname.toString(), Integer.parseInt(et_price.toString()));
                        //menu.setDishname(et_dishname.toString());
                        //menu.setPrice(Integer.parseInt(et_price.toString()));
                        //MyDBHandler dbHandler = new MyDBHandler(getContext() ,null, null,1);
                        //dbHandler.addDish(menu);
                        btn_set_menu.setText("Changed");

                    }
                });




        return view;

    }
}
