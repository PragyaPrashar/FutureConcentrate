package com.example.pragya.future_concentrate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main6Activity extends AppCompatActivity {
    TextView text1,text2,text3,text4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main6);

        init();
         text1.setText(pubvar.fname);
        text2.setText(pubvar.lname);
        text3.setText(pubvar.emailid);
        text4.setText(pubvar.mobilenumber);
      //  Toast.makeText(Main6Activity.this, "first name:"+pubvar.fname, Toast.LENGTH_SHORT).show();
    }
   public void init()
    {
        text1 = (TextView) findViewById(R.id.textView16);
        text2=(TextView)findViewById(R.id.textView15);
        text3=(TextView)findViewById(R.id.textView18);
        text4=(TextView)findViewById(R.id.textView31);
    }
   public void onBack(View view)
    {
        try{
            Intent intent=new Intent(Main6Activity.this,Main5Activity.class);
            startActivity(intent);
        }
        catch(Exception ex)
        {
            Toast.makeText(Main6Activity.this, "error"+ex, Toast.LENGTH_SHORT).show();
        }
    }

   public void onLogout(View view)
    {
        try{
        Intent intent=new Intent(Main6Activity.this,Main3Activity.class);
           startActivity(intent);
    }
        catch(Exception ex)
        {
            Toast.makeText(Main6Activity.this, "error"+ex, Toast.LENGTH_SHORT).show();
        }
    }
}
