package com.example.pragya.future_concentrate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {


    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main5);
    }
   public void onMyProfile(View view)
    {
        try{
            Intent intent=new Intent(Main5Activity.this,Main6Activity.class);
            startActivity(intent);
        }
        catch(Exception ex)
        {
            Toast.makeText(Main5Activity.this, "error"+ex, Toast.LENGTH_SHORT).show();
        }
    }
   public void onPostInformation(View view)
    {
        try{
            Intent intent=new Intent(Main5Activity.this,Main7Activity.class);
            startActivity(intent);
        }
        catch(Exception ex)
        {
            Toast.makeText(Main5Activity.this, "error"+ex, Toast.LENGTH_SHORT).show();
        }
    }
   public void onUpdatePassword(View view)
    {
        try{
        Intent intent=new Intent(Main5Activity.this,Main14Activity.class);
        startActivity(intent);
    }
    catch(Exception ex)
    {
        Toast.makeText(Main5Activity.this, "error"+ex, Toast.LENGTH_SHORT).show();
    }

    }
   public void onLogout(View view)
    {
        try{
            Intent intent=new Intent(Main5Activity.this,MainActivity.class);
            startActivity(intent);
        }
        catch(Exception ex)
        {
            Toast.makeText(Main5Activity.this, "error"+ex, Toast.LENGTH_SHORT).show();
        }
    }
   public void onDonnate(View view)
    {
      try{
       Intent intent =new Intent(Main5Activity.this,Main12Activity.class);
          startActivity(intent);
      }
      catch(Exception ex)
      {
          Toast.makeText(Main5Activity.this, "error"+ex, Toast.LENGTH_SHORT).show();
      }
    }
}
