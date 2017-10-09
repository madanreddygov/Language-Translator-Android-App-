package com.example.s528132.languagetranslator;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    String choosenLanguage="en-ja";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);


    }
    public void changer(View V){

        EditText editT1=(EditText)findViewById(R.id.editText2);
        final String convertStuff=editT1.getText().toString();





            String urlForConversion = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20160307T213950Z.3c5c87c3e34aaaae.bfe9021dfa7e4b7e1ef4826c52e2e8781c8a1813&text=" + convertStuff.toString() + "&lang="+choosenLanguage.toString();
            StringBuilder jsonStrBuilder = new StringBuilder();
            try {
                URL url = new URL(urlForConversion);
                BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
                String line;
                while ((line = br.readLine()) != null)
                    jsonStrBuilder.append(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                JSONObject obj = new JSONObject(jsonStrBuilder.toString());
                String name = obj.getString("text");

                TextView set = (TextView) findViewById(R.id.textView2);
                set.setText(name.substring(2,name.length()-2));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }



    public void pav(View v){
        choosenLanguage = "en-ja";
    }
    public void sow(View v){
        choosenLanguage="en-fr";
    }
    public void sri(View v){
        choosenLanguage="en-hi";
    }

    }

