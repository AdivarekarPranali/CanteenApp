package com.vjti.canteenapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.studioidan.httpagent.HttpAgent;
import com.studioidan.httpagent.StringCallback;

/**
 * Created by DBS19 on 02-04-2017.
 */
public class tab1add extends Fragment {

    private  static final String TAG= "tab1add";
    private Button btn_add;
    private EditText et_dishname, et_price;
    Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.tab1add,  container, false);


        //setContentView(R.layout.tab1add);

        btn_add = (Button) view.findViewById(R.id.btn_add);
        et_dishname   = (EditText)view.findViewById(R.id.et_dishname);
        et_price = (EditText)view.findViewById(R.id.et_price);


    final String dishname="dsx";
       final  String price="54";

       // dishname=et_dishname.getText().toString();
       // price= et_price.getText().toString();

       btn_add.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        //Log.v("EditText", mEdit.getText().toString());
                      //  Menu menu = new Menu(et_dishname.toString(), Integer.parseInt(et_price.toString()));
                        //menu.setDishname(et_dishname.toString());
                        //menu.setPrice(Integer.parseInt(et_price.toString()));

                    //     MyDBHandler dbHandler = new MyDBHandler(context,null, null,1);
                    //   dbHandler.addDish(menu);


            HttpAgent.post("http://192.168.1.102:3306/insertdish.php")
                    .queryParams("dishname", dishname, "price", price)


                    .goString(new StringCallback() {
                        @Override


                        protected void onDone(boolean success, String results) {
                            if (results != null) {

                                if (results.contains("true")) {
                                    //Intent myIntent = new Intent(tab1add.this, add.class);
                                    // myIntent.putExtra("key", value); //Optional parameters
                                    //startActivity(myIntent);
                                    btn_add.setText(results.toString());
                                } else {
                                    btn_add.setText(results.toString());

                                    //Toast.makeText(getApplicationContext(),"Not  registered",Toast.LENGTH_SHORT).show();

                                }

                            } else {

                                //Toast.makeText(getApplicationContext(),"request timed out", Toast.LENGTH_SHORT).show();
                                btn_add.setText(dishname);


                            }

                        }
                    });


        }



                    }

       );

        return view;

    }
/*
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }*/

}
