package com.example.pragya.future_concentrate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main12Activity extends AppCompatActivity {
EditText text1,text2,text3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
    init();
    }
   public void init()
    {
        text1=(EditText)findViewById(R.id.editText7);
        text2=(EditText)findViewById(R.id.editText8);
        text3=(EditText)findViewById(R.id.editText9);
    }

   public void onBack(View view)
    {
        try{
            Intent intent=new Intent(Main12Activity.this,Main5Activity.class);
            startActivity(intent);

        }
        catch(Exception ex)
        {
            Toast.makeText(Main12Activity.this, "error"+ex, Toast.LENGTH_SHORT).show();
        }
    }
   public void onDonnate(View view)
    {
        try{
            String Name=text1.getText().toString();
            String MobileNumber=text2.getText().toString();
            String Amount=text3.getText().toString();
            DonnationModel d1=new DonnationModel();
            d1.setName(Name);
            d1.setMobileNumber(MobileNumber);
            d1.setAmount(Amount);

            DatabaseHandler d2=DatabaseHandler.getInstance(Main12Activity.this);
            d2.addDonnor(d1);
            Toast.makeText(Main12Activity.this, "Amount Donnated", Toast.LENGTH_SHORT).show();
        }
        catch(Exception ex)
        {
            Toast.makeText(Main12Activity.this, "error"+ex, Toast.LENGTH_SHORT).show();
        }
    }
}
