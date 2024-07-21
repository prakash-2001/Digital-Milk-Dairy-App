package mad.mini.digitaldairyapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1 ="create table admin_signup(admin_id text, admin_name text, admin_email text, admin_phoneno text, admin_password text)";
        sqLiteDatabase.execSQL(qry1);
        String qry2 ="create table user_signup(user_id text, user_name text, user_email text, user_phoneno text, user_password text)";
        sqLiteDatabase.execSQL(qry2);
        String qry3 ="create table data_entry(entry_d_id text, entry_d_date text, entry_d_time text, entry_d_ltr text, entry_d_fat text, entry_d_deg text, entry_d_price text)";
        sqLiteDatabase.execSQL(qry3);
        String qry4 = "UPDATE data_entry SET entry_d_date = 'edit_d_date', entry_d_time = 'edit_d_time', entry_d_ltr = 'edit_d_ltr', entry_d_fat = 'edit_d_fat', entry_d_deg = 'edit_d_deg', entry_d_price = 'edit_d_price' WHERE entry_d_id = 'edit_d_id' AND entry_d_date = 'edit_d_date' AND entry_d_time = 'edit_d_time'";
        sqLiteDatabase.execSQL(qry4);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void admin_signup(String admin_id, String admin_name, String admin_email, String admin_phoneno, String admin_password){
        ContentValues cv = new ContentValues();
        cv.put("admin_id",admin_id);
        cv.put("admin_name",admin_name);
        cv.put("admin_email",admin_email);
        cv.put("admin_phoneno",admin_phoneno);
        cv.put("admin_password",admin_password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("admin_signup",null,cv);
        db.close();
    }
    public void user_signup(String user_id, String user_name, String user_email, String user_phoneno, String user_password) {
        ContentValues cv = new ContentValues();
        cv.put("user_id",user_id);
        cv.put("user_name",user_name);
        cv.put("user_email",user_email);
        cv.put("user_phoneno",user_phoneno);
        cv.put("user_password",user_password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("user_signup",null,cv);
        db.close();
    }

    public int login(String admin_id,String admin_password){
        int result=0;
        String str[]= new String[2];
        str[0] = admin_id;
        str[1]= admin_password;
        SQLiteDatabase db= getReadableDatabase();
        Cursor c =db.rawQuery("select * from admin_signup where admin_id=? and admin_password=?",str);
        if(c.moveToFirst()){
            result=1;
        }

        return result;
    }

    public int user_login(String user_id, String user_password) {
        int result=0;
        String str[]= new String[2];
        str[0] = user_id;
        str[1]= user_password;
        SQLiteDatabase db= getReadableDatabase();
        Cursor c =db.rawQuery("select * from user_signup where user_id=? and user_password=?",str);
        if(c.moveToFirst()){
            result=1;
        }

        return result;

    }
    public void daily_entry_data(String entry_d_id, String entry_d_date, String entry_d_time, String entry_d_ltr, String entry_d_fat, String entry_d_deg, String entry_d_price) {
        ContentValues cv = new ContentValues();
        cv.put("entry_d_id",entry_d_id);
        cv.put("entry_d_date",entry_d_date);
        cv.put("entry_d_time",entry_d_time);
        cv.put("entry_d_ltr",entry_d_ltr);
        cv.put("entry_d_fat",entry_d_fat);
        cv.put("entry_d_deg",entry_d_deg);
        cv.put("entry_d_price",entry_d_price);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("data_entry",null,cv);
        db.close();
    }


    public void edit_daily_entry(String edit_d_id, String edit_d_date, String edit_d_time, String edit_d_ltr, String edit_d_fat, String edit_d_deg, String edit_d_price) {
        ContentValues cv = new ContentValues();
        cv.put("entry_d_id",edit_d_id);
        cv.put("entry_d_date",edit_d_date);
        cv.put("entry_d_time",edit_d_time);
        cv.put("entry_d_ltr",edit_d_ltr);
        cv.put("entry_d_fat",edit_d_fat);
        cv.put("entry_d_deg",edit_d_deg);
        cv.put("entry_d_price",edit_d_price);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("data_entry",null,cv);
        db.close();
    }
}
