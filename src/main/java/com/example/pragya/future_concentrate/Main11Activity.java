package com.example.pragya.future_concentrate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Main11Activity extends AppCompatActivity {
TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
text1=(TextView)findViewById(R.id.textView47);
        try {
            DatabaseHandler mDatabaseHandler = DatabaseHandler.getInstance(Main11Activity.this);

            List<DonnationModel> donnationModels = mDatabaseHandler.getAllUserDonnation();
            String myData = "";
            String name = "";
            String mobilenumber = "";
            String amount = "";
            String pwd;

            String userData = "";
            for ( DonnationModel donnationModels1: donnationModels) {

                name = donnationModels1.getName();
                mobilenumber = donnationModels1.getMobileNumber();
                amount = donnationModels1.getAmount();
                int l = name.length();
                name = "Name: " + name;
                Display display = getWindowManager().getDefaultDisplay();
                int width = display.getWidth() / 9;
                while (l < width) {
                    name = name + " ";
                    l++;
                }
                l = mobilenumber.length();
                mobilenumber = "Mobile: " + mobilenumber;
                while (l < width) {
                    mobilenumber = mobilenumber + " ";
                    l++;
                }
                l = amount.length();
                amount = "Amount: " + amount;
                while (l < width) {
                    amount = amount + " ";
                    l++;
                }
                userData = name + mobilenumber + amount;

                l = 0;
                String lines = "";
                while (l < width) {
                    lines = lines + "-";
                    l++;
                }
                userData = lines + " " + userData;
                myData = myData + userData;
            }

                text1.setText(myData);
            //Toast.makeText(Main11Activity.this, "name"+name, Toast.LENGTH_SHORT).show();


        }
        catch (Exception ex)
        {
            Toast.makeText(Main11Activity.this, "error"+ex, Toast.LENGTH_SHORT).show();
        }
    }
}