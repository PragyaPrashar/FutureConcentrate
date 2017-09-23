package com.example.pragya.future_concentrate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Main7Activity extends AppCompatActivity {
    EditText text1,text2;
    Button button1,button2,button3;
    Spinner spinner1, spinner2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        init();
    }
    protected void init()
    {
    button1= (Button) findViewById(R.id.b1);
        button2= (Button) findViewById(R.id.b2);
        button3= (Button) findViewById(R.id.b3);
        text1=(EditText)findViewById(R.id.t5);
        text2=(EditText)findViewById(R.id.t7);
        spinner1=(Spinner)findViewById(R.id.s1);
        spinner2=(Spinner)findViewById(R.id.s2);

        String item1[]=new String[]{"Select","Donnor","HelpSeeker"};
        String item2[]=new String[]{"Select","Food","Shelter","Money"};
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,item1);
        spinner1.setAdapter(adapter);
        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,item2);
        spinner2.setAdapter(adapter1);

    }
   public void onGetLocation(View view)
    {
        try {
            Intent intent = new Intent(Main7Activity.this, Main13Activity.class);
            startActivity(intent);
        }
        catch(Exception ex) {
             Toast.makeText(Main7Activity.this, "error"+ex, Toast.LENGTH_SHORT).show();

        }
    }
   public void onCancel(View view)
    {
        try{
            Intent intent=new Intent(Main7Activity.this,Main5Activity.class);
            startActivity(intent);
        }
        catch(Exception ex)
        {
            Toast.makeText(Main7Activity.this, "error"+ex, Toast.LENGTH_SHORT).show();
        }
    }
   public void onPostInformation(View view)
    {
try{
    Toast.makeText(Main7Activity.this, "Information Posted", Toast.LENGTH_SHORT).show();
           String Name =text1.getText().toString();
    String MobileNumber=text2.getText().toString();
    String Status=(String) spinner1.getSelectedItem();
    String HelpType=(String)spinner2.getSelectedItem();


    PostModel p1=new PostModel();
    p1.setName(Name);
    p1.setMobileNumber(MobileNumber);
    p1.setStatus(Status);
    p1.setHelpType(HelpType);
DatabaseHandler d1=DatabaseHandler.getInstance(Main7Activity.this);
    d1.postUser(p1);
    }
catch(Exception ex)
{
    Toast.makeText(Main7Activity.this, "error"+ex, Toast.LENGTH_SHORT).show();
}
    }
}
