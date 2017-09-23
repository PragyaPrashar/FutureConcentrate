package com.example.pragya.future_concentrate;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main10Activity extends AppCompatActivity {
    TextView textView;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main10);
            textView = (TextView) findViewById(R.id.textView30);

            try {
                DatabaseHandler mDatabaseHandler = DatabaseHandler.getInstance(Main10Activity.this);
                ArrayList<PostModel> postmodels = mDatabaseHandler.getAllUserPost();

                String myData = "";
                String name = "";
                String mobilenumber = "";
                String status = "";
                String helptype = "";
                String userData = "";

                for (PostModel postmodel : postmodels) {
                    name = postmodel.getName();
                    mobilenumber = postmodel.getMobileNumber();
                    status = postmodel.getStatus();
                    helptype = postmodel.getHelpType();
                    int l=name.length();
                    name="Name:"+name;
                    Display display = getWindowManager().getDefaultDisplay();
                    int width = display.getWidth()/9;
                    while (l < width) {
                        name=name+" ";
                        l++;
                    }

                    l=mobilenumber.length();
                    mobilenumber="Mobile: "+mobilenumber;
                    while (l < width) {
                        mobilenumber=mobilenumber+" ";
                        l++;
                    }

                    l=status.length();
                    status="Status: "+status;
                    while (l < width) {
                        status=status+" ";
                        l++;
                    }
                    l=helptype.length();
                    helptype="HelpType: "+helptype;
                    while (l < 75) {
                        helptype=helptype+" ";
                        l++;
                    }

                    userData=name+mobilenumber+status+helptype;

                    l=0;
                    String lines="";
                    while(l<width) {
                        lines = lines + "-";
                        l++;
                    }
                    userData=lines+" "+userData;
                    myData=myData+userData;




                }
                textView.setText(myData);


            }
            catch (Exception ex) {
                Toast.makeText(Main10Activity.this, "error" + ex, Toast.LENGTH_SHORT).show();
            }
        }
}
