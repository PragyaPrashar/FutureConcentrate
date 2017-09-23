package com.example.pragya.future_concentrate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
   public void onLogin(View view)
    {
        try{
            Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
            startActivity(intent);
        }
        catch(Exception ex)
        {
            Toast.makeText(Main2Activity.this, "error"+ex, Toast.LENGTH_SHORT).show();
        }
    }
  public void onRegister(View view)
    {
        try{
            Intent intent=new Intent(Main2Activity.this,Main4Activity.class);
            startActivity(intent);
        }
        catch(Exception ex)
        {
            Toast.makeText(Main2Activity.this, "error"+ex, Toast.LENGTH_SHORT).show();
        }
    }

}
