package com.example.pragya.future_concentrate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    EditText text1, text2, text3, text4, text5, text6;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main4);
        init();
    }

    protected void init() {
        text1 = (EditText) findViewById(R.id.editText);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        text4 = (EditText) findViewById(R.id.editText4);

        text5 = (EditText) findViewById(R.id.editText5);
        text6 = (EditText) findViewById(R.id.editText6);
        button1 = (Button) findViewById(R.id.button8);
    }

   public void onRegister(View view) {
        try {
            String Fname = text1.getText().toString();
            String Lname = text2.getText().toString();
            String EmailId = text3.getText().toString();
            String Password = text4.getText().toString();
            String ConfirmPassword = text5.getText().toString();
            String Number = text6.getText().toString();


            if ((Password.equals(ConfirmPassword))) {


                Toast.makeText(Main4Activity.this, "Registered", Toast.LENGTH_SHORT).show();
                UserModel u1 = new UserModel();
                u1.setFirstName(Fname);
                u1.setLastName(Lname);
                u1.setEmailAddress(EmailId);
                u1.setPassword(Password);
                u1.setMobileNumber(Number);

                DatabaseHandler d1 = DatabaseHandler.getInstance(Main4Activity.this);


                d1.addUser(u1);
                 /*
                 DatabaseHandler d1=new DatabaseHandler(this);
                 ContentValues content=new ContentValues();
                 content.put(DatabaseHandler.KEY_FIRST_NAME,Fname);
                 content.put(DatabaseHandler.KEY_LAST_NAME,Lname);
                 content.put(DatabaseHandler.KEY_EMAIL,EmailId);
                 content.put(DatabaseHandler.KEY_PASSWORD,Password);
                 content.put(DatabaseHandler.KEY_MOBILE_NUMBER,Number);
                 SQLiteDatabase d=d1.getWritableDatabase();
                 long id=d.insert(DatabaseHandler.DATABASE_NAME,null,content);
                if(id<0)
                 {
                     Toast.makeText(Main4Activity.this, "wrong indertion", Toast.LENGTH_SHORT).show();

             }
                 else
{
    Toast.makeText(Main4Activity.this, "correctinsertion", Toast.LENGTH_SHORT).show();
}*/
             }
                else{
                    Toast.makeText(Main4Activity.this, " Password doesn't match with  Confirm Password ", Toast.LENGTH_SHORT).show();
                }


        }
            catch(Exception ex)
            {
                Toast.makeText(Main4Activity.this, "error" + ex, Toast.LENGTH_SHORT).show();
            }
        }

    }
