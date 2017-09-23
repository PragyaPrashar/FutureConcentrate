package com.example.pragya.future_concentrate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.Button;
import android.widget.*;
import android.view.View;
import android.graphics.*;
public class MainActivity extends AppCompatActivity {
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button button1 = (Button) findViewById(R.id.b1);


        setContentView(R.layout.activity_main);

    }


    public void onNext(View view) {

        try {


            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
            //  DatabaseHandler D=new DatabaseHandler();
            //  String S= D.database();
            // Toast.makeText(MainActivity.this, ""+S, Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            Toast.makeText(MainActivity.this, "error:" + ex, Toast.LENGTH_SHORT).show();
        }


    }


}
