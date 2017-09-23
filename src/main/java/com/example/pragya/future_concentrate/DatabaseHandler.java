package com.example.pragya.future_concentrate;


import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;  //Package for database connectivity

import android.util.Log;
import android.widget.Toast;

import static android.widget.Toast.*;


public class DatabaseHandler  extends SQLiteOpenHelper{



        // Database version
        private static final int DATABASE_VERSION = 2;
     //Database Instance

        private static DatabaseHandler mDatabaseHandlerInstance;

private Context context;
    // Database name
    public static final String DATABASE_NAME = "ngo.sqlite";
    //RegistrationList
    private static final String TABLE_users = "UserList";          //Tablename
  //PostList
    private static  final String table_name="PostList";
private static final String Tablename="DonnationList";

    //FieldsName
    //For RegistrationList.
    public static final String KEY_ID = "volunteer_id";
    public static final String KEY_FIRST_NAME = "first_name";
    public static final String KEY_LAST_NAME = "last_name";
    public static final String KEY_MOBILE_NUMBER = "mobile_number";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";

    /*
        public static final String KEY_ID = "volunteer_id";
        public static final String KEY_FIRST_NAME = "first_name";
        public static final String KEY_LAST_NAME = "last_name";
        public static final String KEY_MOBILE_NUMBER = "mobile_number";
        public static final String KEY_EMAIL = "email";
        public static final String KEY_PASSWORD = "password";
        */
    //For PostList.
    private static final  String key_id="post_id";
    private static final  String key_name="post_name";
 private static final String key_mobilenumber="mobile_number";
    private static final  String key_status="status1";
    private static final  String key_helptype="help_type";
//For DonnationList
    private static final String keyid="donnorid";
    private static final String keyname="Name";
    private static final String keymobilenumber="MobileNumber";
    private static final String keyamount="Amount";



    //  method checks whether the table is created or not
    // getinstance is a method that has  class as a return type and takes arguement as context.
    // For RegistrationList.
        public static DatabaseHandler getInstance(Context context) {



            if (mDatabaseHandlerInstance == null) {
                mDatabaseHandlerInstance = new DatabaseHandler(context.getApplicationContext()); //getapplicationcontext() returns address
            }
            return mDatabaseHandlerInstance;
        }
//constructor
        public DatabaseHandler(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context=context;
            SQLiteDatabase db=this.getWritableDatabase();;
            onCreate(db);
        }

        @Override
//For creating fields
 //Registartic  reateList
        public void onCreate(SQLiteDatabase db) {


           try {

               Log.d("hello","tables created");
               String CREATE_TABLE_USERS = "CREATE TABLE " + TABLE_users + "("
                       + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,"
                       + KEY_FIRST_NAME + " TEXT ,"
                       + KEY_LAST_NAME + " TEXT ,"
                       + KEY_EMAIL + " TEXT ,"
                       + KEY_PASSWORD + " TEXT ,"
                       + KEY_MOBILE_NUMBER + " TEXT )";
               db = this.getWritableDatabase();
               db.execSQL(CREATE_TABLE_USERS);//execute fields in a table
               String Create_Table_post_data = "CREATE TABLE " + table_name+ "("
                       + key_id + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,"
                       + key_name + " TEXT ,"
                       + key_mobilenumber + " TEXT ,"
                       + key_status + " TEXT ,"
                       + key_helptype+ " TEXT )";


              // db.execSQL(Create_Table_post_data);
               String CreateTableDonnation="CREATE TABLE " +Tablename+ "("
                       + keyid + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,"
                       + keyname + " TEXT ,"
                       + keymobilenumber + " TEXT ,"
                       + keyamount + " TEXT )";
               db = this.getWritableDatabase();
               db.execSQL(CreateTableDonnation);

                db = this.getWritableDatabase();
              db.execSQL(Create_Table_post_data);

   /*
               SQLiteDatabase db2 = this.getWritableDatabase();
              String deleteUser="delete from "+Create_Table_post_data;
               String args[]={};
               db2.delete(Create_Table_post_data,"",args);
*/



               Log.d("hello","tables created");
           }
           catch(Exception ex) {
               Log.d("pragya Error","pragya Error"+ex);
           }



        }

     //method for adding user
    //RegistrationList
    public void addUser(UserModel mUserModel) {
    //class used to add values
        ContentValues values = new ContentValues();
        values.put(KEY_FIRST_NAME, mUserModel.getFirstName());
        values.put(KEY_LAST_NAME, mUserModel.getLastName());
        values.put(KEY_MOBILE_NUMBER, mUserModel.getMobileNumber());
        values.put(KEY_EMAIL, mUserModel.getEmailAddress());
        values.put(KEY_PASSWORD, mUserModel.getPassword());
        // Inserting Row
       //getwritabledatabase() put database in writable from.
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_users, null, values);
        // Closing database connection
        db.close();
    }
    public void postUser(PostModel mPostModel)
    {

       try {
           ContentValues values = new ContentValues();
           values.put(key_name, mPostModel.getName());
           values.put(key_mobilenumber ,mPostModel.getMobileNumber());

           Log.d("Hello","Value"+mPostModel.getMobileNumber());
           values.put(key_status, mPostModel.getStatus());
           values.put(key_helptype, mPostModel.getHelpType());
           SQLiteDatabase db = this.getWritableDatabase();
           db.insert(table_name, null, values);
           db.close();
       }

       catch(Exception ex)
        {
            Log.d("Hello","Value"+ex);
        }
    }
public void addDonnor(DonnationModel mDonnationModel)
{
    try {
        ContentValues values = new ContentValues();
       // values.put(keyid, mDonnationModel.getName());
        values.put(keyname, mDonnationModel.getName());
        values.put(keymobilenumber, mDonnationModel.getMobileNumber());
        values.put(keyamount,mDonnationModel.getAmount());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(Tablename, null, values);
        db.close();
    }
    catch(Exception ex)
    {
        Log.d("Hello","error"+ex);
    }

}

    public ArrayList<UserModel>  getAllUserProfile() {

        ArrayList<UserModel> userModelArrayList = null;
        try {
            String selectQuery = "SELECT  * FROM " + TABLE_users;
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {
                userModelArrayList = new ArrayList<UserModel>();
                do {

                    UserModel userModel = new UserModel();
                    // 	get  the  data into array,or class variable
                    userModel.setFirstName(cursor.getString(1));
                    userModel.setLastName(cursor.getString(2));
                    userModel.setMobileNumber(cursor.getString(5));
                    userModel.setEmailAddress(cursor.getString(3));
                    userModel.setPassword(cursor.getString(4));
                    Log.d("hello", "Value: " + userModel.getMobileNumber());

                    userModelArrayList.add(userModel);
                } while (cursor.moveToNext());
            }
            db.close();
        } catch (Exception ex) {
            Log.d("hello", "Value: " + ex);
        }
        return userModelArrayList;
    }
//Selecet Query for PostModel.

        ArrayList<PostModel> getAllUserPost()
        {
            ArrayList<PostModel> postmodelarraylist=null;
            try {
                String PostUser = "SELECT * FROM " + table_name;
                SQLiteDatabase db = this.getWritableDatabase();
                Cursor cursor = db.rawQuery(PostUser, null);
                if (cursor.moveToFirst()) {
                    postmodelarraylist = new ArrayList<PostModel>();
                    do {
                        PostModel postmodel = new PostModel();
                        postmodel.setName(cursor.getString(1));
                        postmodel.setMobileNumber(cursor.getString(2));
                        postmodel.setStatus(cursor.getString(3));
                        postmodel.setHelpType(cursor.getString(4));
                        Log.d("post information ", "Value: " + postmodel.getMobileNumber());
                        postmodelarraylist.add(postmodel);
                    }while (cursor.moveToNext());
                }
                db.close();

            }
            catch(Exception ex)
            {
                Log.d("Hello","Value"+ex);
            }
            return postmodelarraylist;

        }

    public ArrayList<DonnationModel>  getAllUserDonnation() {


        ArrayList<DonnationModel> donnorModelArrayList = null;
        try {
            String selectQuery = "SELECT  * FROM " + Tablename;
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {
                donnorModelArrayList = new ArrayList<DonnationModel>();
                do {

                    DonnationModel donnorModel = new DonnationModel();
                    // 	get  the  data into array,or class variable
                    donnorModel.setName(cursor.getString(1));
                    donnorModel.setMobileNumber(cursor.getString(2));
                    donnorModel.setAmount(cursor.getString(3));

                    donnorModelArrayList.add(donnorModel);
                } while (cursor.moveToNext());
            }
            db.close();
        } catch (Exception ex) {
            Log.d("hello", "Value: " + ex);
        }
        return donnorModelArrayList;
    }
    //Function to check whether user exist or not.
    Boolean CheckUser() {

/*
try {
    SQLiteDatabase db2 = this.getWritableDatabase();
    String deleteUser = "delete from " + TABLE_users;
    String args[] = {};
    db2.delete(TABLE_users, "", args);
}
catch(Exception ex) {
    Log.d("error", "deletion" + ex);
}
*/




          //code of table creation only for once
/*
        try {

            Log.d("hello", "tables created");
            SQLiteDatabase db;
            String CREATE_TABLE_USERS = "CREATE TABLE " + TABLE_users + "("
                    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,"
                    + KEY_FIRST_NAME + " TEXT ,"
                    + KEY_LAST_NAME + " TEXT ,"
                    + KEY_EMAIL + " TEXT ,"
                    + KEY_PASSWORD + " TEXT ,"
                    + KEY_MOBILE_NUMBER + " TEXT )";
            db = this.getWritableDatabase();
            db.execSQL(CREATE_TABLE_USERS);//execute fields in a table
            String Create_Table_post_data = "CREATE TABLE " + table_name + "("
                    + key_id + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,"
                    + key_name + " TEXT ,"
                    + key_mobilenumber + " TEXT ,"
                    + key_status + " TEXT ,"
                    + key_helptype + " TEXT )";


            // db.execSQL(Create_Table_post_data);
            String CreateTableDonnation = "CREATE TABLE " + Tablename + "("
                    + keyid + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,"
                    + keyname + " TEXT ,"
                    + keymobilenumber + " TEXT ,"
                    + keyamount + " TEXT )";
            db = this.getWritableDatabase();
            db.execSQL(CreateTableDonnation);

            db = this.getWritableDatabase();
            db.execSQL(Create_Table_post_data);
        }
        catch (Exception ex)
        {
            Log.d("error", "CheckUser: "+ex);
        }
*/
   /*
               SQLiteDatabase db2 = this.getWritableDatabase();
              String deleteUser="delete from "+Create_Table_post_data;
               String args[]={};
               db2.delete(Create_Table_post_data,"",args);
*/




// end of table creation code










        Boolean status = false;
        try {
            String PostUser = "SELECT * FROM " +TABLE_users  + " WHERE email='"+pubvar.emailid+"'";
             SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(PostUser, null);

            String dpass = "";
            if (cursor.moveToFirst())
                do {
                    pubvar.fname=cursor.getString(1);
                    pubvar.lname=cursor.getString(2);
                    pubvar.emailid=cursor.getString(3);
                    dpass = cursor.getString(4);
                    Log.d("Hello","Value"+dpass);
                    pubvar.mobilenumber=cursor.getString(5);
                } while (cursor.moveToNext());

            if (pubvar.password.equals(dpass)) {
                status=true;
            } else {
                status= false;
            }
        } catch (Exception ex) {
            //Toast.makeText(DatabaseHandler.this, "error"+ex, Toast.LENGTH_SHORT).show();
        }
        return status;

    }
    //update Password
    public boolean onUpdate()
    {
        boolean b=false;

        try {
           // String updateQuery = "update  " + TABLE_users + " set " + KEY_PASSWORD + "= " + pubvar.newpassword + " where " + KEY_EMAIL + "=" + pubvar.emailid;

            String updateQuery="update  UserList set password= '"+pubvar.newpassword+"' where email='"+pubvar.emailid+"'";

            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL(updateQuery);
            b=true;
        }
        catch(Exception ex)
        {
            Log.d("update error"," error "+ex);
        }
       return b;

    }
    @Override
    //DropTable
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        try {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_users);
            db.execSQL("DROP TABLE IF EXISTS" + table_name);
            db.execSQL("DROP TABLE IF EXISTS" + Tablename);
            onCreate(db);
        }
        catch(Exception ex)
        {
            Log.d("Hello","Value"+ex);
        }
    }


}