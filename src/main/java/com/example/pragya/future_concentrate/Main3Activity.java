package com.example.pragya.future_concentrate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    EditText text1, text2;
    String EmailId="";
    String Password="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);

        init();

    }


    private void init()
    {


            text1 = (EditText) findViewById(R.id.tuser);
            text2 = (EditText) findViewById(R.id.t5);

    }



  public void onLogin(View view) {

                try {
                    EmailId = text1.getText().toString();
                    Password = text2.getText().toString();
                    pubvar.emailid=EmailId;
                    pubvar.password=Password;

                    if (EmailId.equals("pragyaprashar@gmail.com") && Password.equals("pragya"))

                    {
                        Intent intent = new Intent(Main3Activity.this, Main8Activity.class);
                        startActivity(intent);
                    }
                    else {
                        DatabaseHandler d1 = DatabaseHandler.getInstance(Main3Activity.this);


                        boolean b1=d1.CheckUser();
                        if (b1==true) {
                            Intent intent = new Intent(Main3Activity.this, Main5Activity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Main3Activity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                        }
                    }
            }
            catch (Exception ex)
            {
                Toast.makeText(Main3Activity.this, "error2" + ex, Toast.LENGTH_SHORT).show();
            }

        }
}



