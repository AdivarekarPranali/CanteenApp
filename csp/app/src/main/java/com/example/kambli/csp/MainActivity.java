package com.example.kambli.csp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.studioidan.httpagent.HttpAgent;
import com.studioidan.httpagent.JsonArrayCallback;
import com.studioidan.httpagent.StringCallback;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText username1 ;
    EditText password1 ;
    String username;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

         username1 = (EditText) findViewById(R.id.editText);
        password1 = (EditText) findViewById(R.id.editText2);

        abcd();
        register();
    }
    public void register()
    {
        Button b1=(Button)findViewById(R.id.register);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this,Register .class);
                // myIntent.putExtra("key", value); //Optional parameters
                startActivity(myIntent);
            }
        });



    }

    public void hpost()
    {
        username = username1.getText().toString();
        password = password1.getText().toString();

        HttpAgent.post("https://deepblueproject.000webhostapp.com/login.php")
                .queryParams("username",username,"password",password)

        .goString(new StringCallback() {
            @Override
            protected void onDone(boolean success, String results) {
            if(results!=null) {

                boolean b1 = results.contains("true");
                if (b1) {
                    Intent myIntent = new Intent(MainActivity.this, Home.class);
                    // myIntent.putExtra("key", value); //Optional parameters
                    startActivity(myIntent);
                } else {

                    Toast.makeText(getApplicationContext(),"wrong password",Toast.LENGTH_SHORT).show();
                }
            }else
            {

                Toast.makeText(getApplicationContext(),"request timed out",Toast.LENGTH_SHORT).show();
            }

            }
        });


    }


    private void makePostRequest() {


        HttpClient httpClient = new DefaultHttpClient();
        // replace with your url
        HttpPost httpPost = new HttpPost("https://www.google.com");


        //Post Data
        List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(2);
        nameValuePair.add(new BasicNameValuePair("username", "test_user"));
        nameValuePair.add(new BasicNameValuePair("password", "123456789"));


        //Encoding POST data
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
        } catch (UnsupportedEncodingException e) {
            // log exception

        }

        //making POST request.
        try {
            HttpResponse response = httpClient.execute(httpPost);
            // write response to log
            Log.d("Http Post Response:", response.toString());
        } catch (ClientProtocolException e) {
            // Log exception
            e.printStackTrace();
        } catch (IOException e) {
            // Log exception

        }

    }





    public void abcd() {
        Button b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hpost();
                /*
             //   EditText username1 = (EditText) findViewById(R.id.editText);
               // EditText password1 = (EditText) findViewById(R.id.editText2);
                String username = username1.toString();
                String password = password1.toString();

                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost("https://deepblueproject.000webhostapp.com/login.php");

                try {
                    // Add your data
                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
                    nameValuePairs.add(new BasicNameValuePair("username", username));
                    nameValuePairs.add(new BasicNameValuePair("password", password));
                    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    // Execute HTTP Post Request
                    HttpResponse response = httpclient.execute(httppost);
                    System.out.println(response.toString());



                } catch (ClientProtocolException e) {

                System.out.println("client side exception");

                    // TODO Auto-generated catch block
                } catch (IOException e) {
                    // TODO Auto-generated catch block

                    System.out.println("io side exception");
                }






*/


            }
        });


    }



}
