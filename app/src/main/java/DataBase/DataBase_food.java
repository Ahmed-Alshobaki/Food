package DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.Food;

public class DataBase_food extends SQLiteOpenHelper {

    final public static String ADMIKNUSER ="a";
    final public static String ADMINPASSWORD ="a";

    final public static String Database ="Data_Food";
    final public static Integer VERSION =6;
    final public static String Table_User_Name ="Data_Food";
    final public static String COLUMN_Id ="id";
    final public static String COLUMN_name ="name";
    final public static String COLUMN_Email ="email";
    final public static String COLUMN_Password ="Password";

    final public static String COLUMN_FOOD_NAME ="foodname";
    final public static String COLUMN_FOOD_ID ="foodid";
    final public static String COLUMN_FOOD_DESCRIPTION ="fooddescrip";
    final public static String COLUMN_FOOD_RATE ="foodrate";
    final public static String COLUMN_FOOD_PRICE ="foodprice";
    final public static String TABLE_FOOD ="Table_food";





    public DataBase_food(@Nullable Context context) {
        super(context, Database, null , VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table_user =
                "create table "
                +Table_User_Name+"(" +
                COLUMN_Id + " integer primary key autoincrement, "+
                COLUMN_name + " text not null, "
                + COLUMN_Email + " text not null, " +
                COLUMN_Password +" text not null "+" ) ";


        String table_food =
                "create table "
                        +TABLE_FOOD+"(" +
                        COLUMN_FOOD_ID + " TEXT primary key, "+
                        COLUMN_FOOD_NAME + " text not null, "
                        + COLUMN_FOOD_RATE + " text not null, "
                        + COLUMN_FOOD_DESCRIPTION + " text not null, " +
                        COLUMN_FOOD_PRICE +" text not null "+" ) ";


       db.execSQL(table_user);
       db.execSQL(table_food);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" drop table  if exists "+Table_User_Name);
        db.execSQL(" drop table  if exists "+TABLE_FOOD);
        onCreate(db);
    }
    public boolean insertUser(user user){
        SQLiteDatabase liteDatabase = this.getWritableDatabase();
        ContentValues values =new ContentValues();

        values.put(COLUMN_name,user.getName());
        values.put(COLUMN_Email,user.getEmail());
        values.put(COLUMN_Password,user.getPassword());
        values.put(COLUMN_name,user.getName());
      long Result =  liteDatabase.insert(Table_User_Name,null,values);
        return Result != -1;
    }
    public boolean UpdateUser(user user){
        SQLiteDatabase liteDatabase = this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(COLUMN_name,user.getName());
        values.put(COLUMN_Email,user.getEmail());
        values.put(COLUMN_Password,user.getPassword());
        values.put(COLUMN_name,user.getName());
        String [] strings ={user.getId()+""};
        int Result =  liteDatabase.update(Table_User_Name,values,"id=?",strings);
        return Result > -1;
    }
    public boolean deleteUser(user user){
        SQLiteDatabase liteDatabase = this.getWritableDatabase();

        String [] strings ={user.getId()+""};
        int Result =  liteDatabase.delete(Table_User_Name,"id=?",strings);
        return Result > -1;
    }
    public Cursor getCursor(){
        SQLiteDatabase liteDatabase = this.getReadableDatabase();
        Cursor cursor=liteDatabase.rawQuery(" select * from "+Table_User_Name ,null);
        return cursor;

    }




    public boolean insertFood(Food food){
        SQLiteDatabase liteDatabase = this.getWritableDatabase();
        ContentValues values =new ContentValues();

        values.put(COLUMN_FOOD_NAME,food.getName());
        values.put(COLUMN_FOOD_ID,food.getId());
        values.put(COLUMN_FOOD_RATE,food.getRate());
        values.put(COLUMN_FOOD_PRICE,food.getPrice());
        values.put(COLUMN_FOOD_DESCRIPTION,food.getDescription());

        long Result =  liteDatabase.insert(TABLE_FOOD,null,values);
        return Result != -1;
    }










}
