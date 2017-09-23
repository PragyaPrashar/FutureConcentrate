package com.example.pragya.future_concentrate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.TextView;
import java.util.*;
import java.util.jar.Attributes;

import  android.widget.Toast;

public class Main9Activity extends AppCompatActivity {



    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        textView = (TextView) findViewById(R.id.textView29);



        try {
            DatabaseHandler mDatabaseHandler = DatabaseHandler.getInstance(Main9Activity.this);

            List<UserModel> userModels = mDatabaseHandler.getAllUserProfile();
            String myData = "";
            String firstname="";
            String lastname="";
            String emailid="";
            String mobilenumber="";
            String pwd;

            String userData="";
            String name="";
            for (UserModel usermodel : userModels) {

                firstname = usermodel.getFirstName();
                lastname = usermodel.getLastName();
                name=firstname+" "+lastname;
                emailid = usermodel.getEmailAddress();
                mobilenumber = usermodel.getMobileNumber();
                int l=name.length();
                name="Name:"+name;

                Display display = getWindowManager().getDefaultDisplay();
                int width = display.getWidth()/9;


                while (l < width) {
                   name=name+" ";
                    l++;
                }

                l=emailid.length();
                emailid="Email: "+emailid;
                while (l < width) {
                    emailid=emailid+" ";
                    l++;
                }

                l=mobilenumber.length();
                mobilenumber="Mobile: "+mobilenumber;
                while (l < width) {
                    mobilenumber=mobilenumber+" ";
                    l++;
                }

                userData=name+emailid+mobilenumber;


                l=0;
                String lines="";
                while(l<width) {
                    lines = lines + "-";
                    l++;
                }
                userData=lines+" "+userData;
                myData=myData+userData;


            }
            int k=0;
            //textView.setText(myData);
            textView.setText(""+k);


        }
        catch(Exception ex)
        {
           Toast.makeText(Main9Activity.this, "error"+ex, Toast.LENGTH_SHORT).show();
        }



    }
}

