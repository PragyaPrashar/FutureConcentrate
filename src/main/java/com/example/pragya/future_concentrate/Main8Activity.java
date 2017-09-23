package com.example.pragya.future_concentrate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Main8Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
    }
   public void onRegistrationList(View view)
    {
        try{
            Intent intent=new Intent(Main8Activity.this,Main9Activity.class);
            startActivity(intent);
        }
        catch(Exception ex)
        {
            Toast.makeText(Main8Activity.this, "error"+ex, Toast.LENGTH_SHORT).show();
        }
    }
   public void onPostData(View view)
    {
        try{
            Intent intent=new Intent(Main8Activity.this,Main10Activity.class);
            startActivity(intent);
        }
        catch(Exception ex)
        {
            Toast.makeText(Main8Activity.this, "error"+ex, Toast.LENGTH_SHORT).show();
        }
    }
   public void onDonationList(View view)
    {
        try{
            Intent intent=new Intent(Main8Activity.this,Main11Activity.class);
            startActivity(intent);
        }
        catch(Exception ex)
        {
            Toast.makeText(Main8Activity.this, "error"+ex, Toast.LENGTH_SHORT).show();
        }
    }

}
