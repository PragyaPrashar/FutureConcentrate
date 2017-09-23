package com.example.pragya.future_concentrate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main14Activity extends AppCompatActivity {
    EditText text1,text2,text3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);
        init();
    }
   public void init()
    {
        text1=(EditText)findViewById(R.id.editText10);
        text2=(EditText)findViewById(R.id.editText11);
        text3=(EditText)findViewById(R.id.editText12);

    }
   public void onUpdate(View view)
    {
        try{
            String oldpass=text1.getText().toString();
            String newpass=text2.getText().toString();
            String confirmpass=text3.getText().toString();

            if(oldpass.equals(pubvar.password))
            {
                if(newpass.equals(confirmpass))
                {
                    pubvar.newpassword=newpass;

                    DatabaseHandler d1= DatabaseHandler.getInstance(Main14Activity.this);
                   boolean b= d1.onUpdate();
                    if(b==true) {
                        Toast.makeText(Main14Activity.this, "Password Updated", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(Main14Activity.this, "Confirm Password doesnt match with New Password", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(Main14Activity.this, "Invalid Password", Toast.LENGTH_SHORT).show();

            }



    }
        catch (Exception ex)
        {
            Toast.makeText(Main14Activity.this, "error"+ex, Toast.LENGTH_SHORT).show();
        }
    }
}
