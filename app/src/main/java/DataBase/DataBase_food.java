package DataBase;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import adapter.Food_Edit_item;

public class DataBase_food extends SQLiteOpenHelper {

    final public static String ADMIKNUSER = "a";
    final public static String ADMINPASSWORD = "a";

    final public static String Database = "Data_Food";
    final public static Integer VERSION = 23;
    final public static String Table_User_Name = "Data_Food";
    final public static String COLUMN_Id = "id";
    final public static String COLUMN_name = "name";
    final public static String COLUMN_Email = "email";
    final public static String COLUMN_Password = "Password";

    final public static String COLUMN_FOOD_NAME = "foodname";
    final public static String COLUMN_FOOD_ID = "foodid";
    final public static String COLUMN_FOOD_DESCRIPTION = "fooddescrip";
    final public static String COLUMN_FOOD_Qty = "Qty";
    final public static String COLUMN_type = "type";
    final public static String COLUMN_sell = "sell";
    final public static String COLUMN_like = "likee";

    final public static String COLUMN_FOOD_RATE = "foodrate";
    final public static String COLUMN_FOOD_PRICE = "foodprice";
    final public static String COLUMN_Image = "imagee";
    final public static String COLUMN_Image_user = "imageuser";
    final public static String TABLE_FOOD = "Table_food";


    public DataBase_food(@Nullable Context context) {
        super(context, Database, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table_user =
                "create table "
                        + Table_User_Name + "(" +
                        COLUMN_Id + " integer primary key autoincrement, " +
                        COLUMN_name + " text not null, "
                        + COLUMN_Email + " text not null, " +
                        COLUMN_Image_user +" blob  ,"  +
                        COLUMN_Password + " text not null " + " ) ";


        String table_food =
                "create table "
                        + TABLE_FOOD + "(" +
                        COLUMN_FOOD_ID + " TEXT primary key, " +
                        COLUMN_FOOD_NAME + " text not null, "
                        + COLUMN_FOOD_RATE + " text not null, "
                        + COLUMN_like + " text , "
                        + COLUMN_sell + " text , "
                        + COLUMN_FOOD_Qty + " text not null, "
                        + COLUMN_type + " text not null, "
                        + COLUMN_Image + " blob not null, "

                        + COLUMN_FOOD_DESCRIPTION + " text not null, " +

                        COLUMN_FOOD_PRICE + " text not null " + " ) ";


        db.execSQL(table_user);
        db.execSQL(table_food);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" drop table  if exists " + Table_User_Name);
        db.execSQL(" drop table  if exists " + TABLE_FOOD);
        onCreate(db);
    }

    public boolean insertUser(user user) {
        SQLiteDatabase liteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_name, user.getName());
        values.put(COLUMN_Email, user.getEmail());
        values.put(COLUMN_Password, user.getPassword());
        values.put(COLUMN_name, user.getName());

        long Result = liteDatabase.insert(Table_User_Name, null, values);
        return Result != -1;
    }

    public boolean UpdateUser(user user) {
        SQLiteDatabase liteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_name, user.getName());
        values.put(COLUMN_Email, user.getEmail());
        values.put(COLUMN_Password, user.getPassword());
        //Erorr
        values.put(COLUMN_name, user.getName());
        String[] strings = {user.getId() + ""};
        int Result = liteDatabase.update(Table_User_Name, values, "id=?", strings);
        return Result > -1;
    }

    public boolean Updatefoosssssd(Food Food) {
        SQLiteDatabase liteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        Food food = new Food();
        // values.put(COLUMN_name,food.getName());
        values.put(COLUMN_FOOD_ID, food.getId());
        values.put(COLUMN_FOOD_DESCRIPTION, food.getDescription());
        values.put(COLUMN_FOOD_RATE, food.getRate());
        values.put(COLUMN_FOOD_Qty, food.getQty());
        values.put(COLUMN_FOOD_NAME, Food.getName());
        values.put(COLUMN_FOOD_PRICE, Food.getPrice());

        String[] strings = {food.getId() + ""};
        int Result = liteDatabase.update(TABLE_FOOD, values, "foodid=?", strings);
        return Result >= 0;
    }

    public boolean Updatefood(Food Food) {
        SQLiteDatabase liteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        Food editItem = new Food();
        // values.put(COLUMN_name,food.getName());
        values.put(COLUMN_FOOD_ID, Food.getId());
        values.put(COLUMN_FOOD_DESCRIPTION, Food.getDescription());
        values.put(COLUMN_FOOD_RATE, Food.getRate());
        values.put(COLUMN_FOOD_Qty, Food.getQty());
        values.put(COLUMN_FOOD_PRICE, Food.getPrice());

        String[] strings = {editItem.getId() + ""};
        int Result = liteDatabase.update(TABLE_FOOD, values, "foodid=?", strings);
        return Result > 0;
    }

    public boolean Updatefood(String id, String name, String qtyy, String des, String price, String rate, String type,Bitmap bitmap ) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FOOD_DESCRIPTION, des);
        values.put(COLUMN_FOOD_RATE, rate);
        values.put(COLUMN_FOOD_Qty, qtyy);
        values.put(COLUMN_FOOD_PRICE, price);
        values.put(COLUMN_FOOD_NAME, name);

        values.put(COLUMN_type, type);

        values.put(COLUMN_Image,getbyteArray(bitmap));
        String[] strings = {String.valueOf(id)};
        int result = sqLiteDatabase.update(TABLE_FOOD, values, " " + COLUMN_FOOD_ID + " =? ", strings);
        return result > 0;


//        values.put(COLUMN_FOOD_ID,Food.getId());
//        values.put(COLUMN_FOOD_DESCRIPTION,Food.getDescription());
//        values.put(COLUMN_FOOD_RATE,Food.getRate());
//        values.put(COLUMN_FOOD_Qty,Food.getQty());
//        values.put(COLUMN_FOOD_PRICE,Food.getPrice());
//        values.put(COLUMN_FOOD_NAME,Food.getName());
//
//        String[] array = { id+""};
//        long result = sqLiteDatabase.update(TABLE_FOOD,values,
//                " " +COLUMN_FOOD_ID + "=? ",array);


    }

    public boolean deleteUser(user user) {
        SQLiteDatabase liteDatabase = this.getWritableDatabase();

        String[] strings = {user.getId() + ""};
        int Result = liteDatabase.delete(Table_User_Name, "id=?", strings);
        return Result > -1;
    }

    public Cursor getCursor() {
        SQLiteDatabase liteDatabase = this.getReadableDatabase();
        Cursor cursor = liteDatabase.rawQuery(" select * from " + Table_User_Name, null);
        return cursor;

    }

    public Cursor getCursorFood() {
        SQLiteDatabase liteDatabase = this.getReadableDatabase();
        Cursor cursor = liteDatabase.rawQuery(" select * from " + TABLE_FOOD, null);
        return cursor;

    }


    public boolean insertFood(Food food) {
        SQLiteDatabase liteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_FOOD_NAME, food.getName());
        values.put(COLUMN_FOOD_ID, food.getId());
        values.put(COLUMN_FOOD_RATE, food.getRate());
        values.put(COLUMN_FOOD_PRICE, food.getPrice());
        values.put(COLUMN_FOOD_DESCRIPTION, food.getDescription());
        values.put(COLUMN_FOOD_Qty, food.getQty());
        values.put(COLUMN_type, food.getType());
        values.put(COLUMN_like, food.getLike());
        values.put(COLUMN_sell, food.getSell());
        values.put(COLUMN_Image,getbyteArray(food.getImage()));

        long Result = liteDatabase.insert(TABLE_FOOD, null, values);
        return Result != -1;
    }

    @SuppressLint("Range")
    public ArrayList<Food> getDoodList() {
        SQLiteDatabase liteDatabase = this.getReadableDatabase();
        Cursor cursor = liteDatabase.rawQuery(" select * from " + TABLE_FOOD, null);
        ArrayList<Food> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            Food Food = new Food();
            Food.setName(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_NAME)));
            Food.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_DESCRIPTION)));
            Food.setPrice(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_PRICE)));
            Food.setRate(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_RATE)));
            Food.setQty(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_Qty)));
            Food.setId(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_ID)));
            Food.setLike(cursor.getString(cursor.getColumnIndex(COLUMN_like)));
            byte[]blob =cursor.getBlob(cursor.getColumnIndex(COLUMN_Image));
            Food.setImage(getbyteBitmap(blob));

            list.add(Food);
        }
        return list;

    }

    @SuppressLint("Range")
    public ArrayList<Food> getDoodList_Edit() {
        SQLiteDatabase liteDatabase = this.getReadableDatabase();
        Cursor cursor = liteDatabase.rawQuery(" select * from " + TABLE_FOOD, null);
        ArrayList<Food> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            Food Food = new Food();
            Food.setName(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_NAME)));
            Food.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_DESCRIPTION)));
            Food.setPrice(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_PRICE)));
            Food.setRate(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_RATE)));
            Food.setQty(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_Qty)));
            Food.setId(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_ID)));
            Food.setLike(cursor.getString(cursor.getColumnIndex(COLUMN_like)));
            byte[]blob =cursor.getBlob(cursor.getColumnIndex(COLUMN_Image));
            Food.setImage(getbyteBitmap(blob));


            list.add(Food);
        }
        return list;

    }


    @SuppressLint("Range")
    public ArrayList<user> getDooduser() {
        SQLiteDatabase liteDatabase = this.getReadableDatabase();
        Cursor cursor = liteDatabase.rawQuery(" select * from " + Table_User_Name, null);
        ArrayList<user> listt = new ArrayList<>();
        while (cursor.moveToNext()) {
            user user_add = new user();
            user_add.setName(cursor.getString(cursor.getColumnIndex(COLUMN_name)));
            user_add.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_Email)));
            user_add.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_Id)));
            user_add.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_Password)));


            listt.add(user_add);
        }
        return listt;

    }

    @SuppressLint("Range")
    public ArrayList<Food> SearchFood(String name) {

        SQLiteDatabase db = getReadableDatabase();
        String[] condetion = {name + ""};

        Cursor cursor = db.rawQuery(" select * from " + TABLE_FOOD + " where " + COLUMN_FOOD_NAME + " like '%" + name + "%'", null);
        ArrayList<Food> list = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Food Food = new Food();
                Food.setName(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_NAME)));
                Food.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_DESCRIPTION)));
                Food.setPrice(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_PRICE)));
                Food.setRate(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_RATE)));
                Food.setQty(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_Qty)));
                Food.setId(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_ID)));
                Food.setLike(cursor.getString(cursor.getColumnIndex(COLUMN_like)));

                byte[]blob =cursor.getBlob(cursor.getColumnIndex(COLUMN_Image));
                Food.setImage(getbyteBitmap(blob));
                list.add(Food);
                cursor.moveToNext();
            }
        }


        return list;
    }

    ;

    @SuppressLint("Range")
    public ArrayList<Food> SearchFood_type_Pizza() {

        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_FOOD + " WHERE " + COLUMN_type + " = 'Pizza'";

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_FOOD + " WHERE " + COLUMN_type + " = 'Pizza'", null);
        ArrayList<Food> list = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Food Food = new Food();
                Food.setName(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_NAME)));
                Food.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_DESCRIPTION)));
                Food.setPrice(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_PRICE)));
                Food.setRate(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_RATE)));
                Food.setQty(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_Qty)));
                Food.setId(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_ID)));
                Food.setLike(cursor.getString(cursor.getColumnIndex(COLUMN_like)));
                byte[]blob =cursor.getBlob(cursor.getColumnIndex(COLUMN_Image));
                Food.setImage(getbyteBitmap(blob));

                list.add(Food);
                cursor.moveToNext();
            }
        }


        return list;
    }

    ;

    @SuppressLint("Range")
    public ArrayList<Food> SearchFood_type_Burger() {

        SQLiteDatabase db = getReadableDatabase();


        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_FOOD + " WHERE " + COLUMN_type + " = 'Burger'", null);
        ArrayList<Food> list = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Food Food = new Food();
                Food.setName(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_NAME)));
                Food.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_DESCRIPTION)));
                Food.setPrice(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_PRICE)));
                Food.setRate(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_RATE)));
                Food.setQty(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_Qty)));
                Food.setId(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_ID)));
                Food.setLike(cursor.getString(cursor.getColumnIndex(COLUMN_like)));

                byte[]blob =cursor.getBlob(cursor.getColumnIndex(COLUMN_Image));
                Food.setImage(getbyteBitmap(blob));

                list.add(Food);
                cursor.moveToNext();
            }
        }


        return list;
    }

    ;

    @SuppressLint("Range")
    public ArrayList<Food> SearchFood_type_Sandwich() {

        SQLiteDatabase db = getReadableDatabase();


        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_FOOD + " WHERE " + COLUMN_type + " = 'Sandwich'", null);
        ArrayList<Food> list = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Food Food = new Food();
                Food.setName(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_NAME)));
                Food.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_DESCRIPTION)));
                Food.setPrice(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_PRICE)));
                Food.setRate(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_RATE)));
                Food.setQty(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_Qty)));
                Food.setId(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_ID)));
                Food.setLike(cursor.getString(cursor.getColumnIndex(COLUMN_like)));

                byte[]blob =cursor.getBlob(cursor.getColumnIndex(COLUMN_Image));
                Food.setImage(getbyteBitmap(blob));
                list.add(Food);
                cursor.moveToNext();
            }
        }


        return list;
    }

    ;

    @SuppressLint("Range")
    public ArrayList<Food> SearchFood_like() {

        SQLiteDatabase db = getReadableDatabase();


        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_FOOD + " WHERE " + COLUMN_like + " = 'true'", null);
        ArrayList<Food> list = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Food Food = new Food();
                Food.setName(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_NAME)));
                Food.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_DESCRIPTION)));
                Food.setPrice(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_PRICE)));
                Food.setRate(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_RATE)));
                Food.setQty(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_Qty)));
                Food.setId(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_ID)));
                Food.setLike(cursor.getString(cursor.getColumnIndex(COLUMN_like)));
                byte[]blob =cursor.getBlob(cursor.getColumnIndex(COLUMN_Image));
                Food.setImage(getbyteBitmap(blob));

                list.add(Food);
                cursor.moveToNext();
            }
        }


        return list;
    }



    public void updateFoodLike(String id, String likeValue) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_like, likeValue);

        String whereClause = COLUMN_FOOD_ID + " = ?";
        String[] whereArgs = {id};

        int rowsAffected = db.update(TABLE_FOOD, values, whereClause, whereArgs);

        if (rowsAffected > 0) {
            Log.d("Update Success", "Food like value updated successfully.");
        } else {
            Log.d("Update Failed", "Failed to update food like value.");
        }

        db.close();
    }

    public void deleteFoodById(String id) {
        SQLiteDatabase db = this.getWritableDatabase();

        String whereClause = COLUMN_FOOD_ID + " = ?";
        String[] whereArgs = {id};

        int rowsAffected = db.delete(TABLE_FOOD, whereClause, whereArgs);

        if (rowsAffected > 0) {
            Log.d("Delete Success", "Food record deleted successfully.");
        } else {
            Log.d("Delete Failed", "Failed to delete food record.");
        }

        db.close();
    }

    public void updateFoodSell(String id, String Sell) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_sell, Sell);

        String whereClause = COLUMN_FOOD_ID + " = ?";
        String[] whereArgs = {id};

        int rowsAffected = db.update(TABLE_FOOD, values, whereClause, whereArgs);

        if (rowsAffected > 0) {
            Log.d("Update Success", "Food like value updated successfully.");
        } else {
            Log.d("Update Failed", "Failed to update food like value.");
        }

        db.close();
    }

    @SuppressLint("Range")
    public ArrayList<Food> SearchFood_sell() {

        SQLiteDatabase db = getReadableDatabase();


        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_FOOD + " WHERE " + COLUMN_sell + " = 'true'", null);
        ArrayList<Food> list = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Food Food = new Food();
                Food.setName(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_NAME)));
                Food.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_DESCRIPTION)));
                Food.setPrice(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_PRICE)));
                Food.setRate(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_RATE)));
                Food.setQty(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_Qty)));
                Food.setId(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_ID)));
                Food.setLike(cursor.getString(cursor.getColumnIndex(COLUMN_like)));

                byte[]blob =cursor.getBlob(cursor.getColumnIndex(COLUMN_Image));
                Food.setImage(getbyteBitmap(blob));
                list.add(Food);
                cursor.moveToNext();
            }
        }


        return list;
    }
    @SuppressLint("Range")
    public double sumPriceWhenSellTrue() {
        SQLiteDatabase db = this.getReadableDatabase();
        double totalPrice = 0;

        String[] columns = {COLUMN_FOOD_PRICE};
        String selection = COLUMN_sell + " = ?";
        String[] selectionArgs = {"true"};

        Cursor cursor = db.query(TABLE_FOOD, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                double price = cursor.getDouble(cursor.getColumnIndex(COLUMN_FOOD_PRICE));
                totalPrice += price;
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return totalPrice;
    }
    public int countItemsWhenSellTrue() {
        SQLiteDatabase db = this.getReadableDatabase();
        int itemCount = 0;

        String[] columns = {"COUNT(*)"};
        String selection = COLUMN_sell + " = ?";
        String[] selectionArgs = {"true"};

        Cursor cursor = db.query(TABLE_FOOD, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            itemCount = cursor.getInt(0);
        }

        cursor.close();
        db.close();

        return itemCount;
    }
    public byte[] getImageById(String id) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT " + COLUMN_Image + " FROM " + TABLE_FOOD + " WHERE " + COLUMN_FOOD_ID + " = ?", new String[]{id});

        byte[] imageBytes = null;
        if (cursor.moveToFirst()) {
            imageBytes = cursor.getBlob(0);
        }

        cursor.close();
        return imageBytes;
    }

    public byte[] getbyteArray(Bitmap bitmap){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    };
    public Bitmap getbyteBitmap(byte[] bytes){
       return  BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    };
    @SuppressLint("Range")
    public Food getFoodById(String id) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_FOOD + " WHERE " + COLUMN_FOOD_ID + " = ?", new String[]{id});

        Food food = null;
        if (cursor.moveToFirst()) {
            food = new Food();
            food.setName(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_NAME)));
            food.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_DESCRIPTION)));
            food.setPrice(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_PRICE)));
            food.setRate(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_RATE)));
            food.setQty(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_Qty)));
            food.setId(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_ID)));
            food.setLike(cursor.getString(cursor.getColumnIndex(COLUMN_like)));
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(COLUMN_Image));
            food.setImage(getbyteBitmap(blob));
        }

        cursor.close();
        return food;
    }
    @SuppressLint("Range")
    public user getUserById(int userId) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Table_User_Name + " WHERE " + COLUMN_Id + " = ?", new String[]{String.valueOf(userId)});

        user user = null;
        if (cursor.moveToFirst()) {
            user = new user();
            user.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_Id)));
            user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_name)));
            user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_Email)));
            user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_Password)));
            user.setImag(getbyteBitmap(cursor.getBlob(cursor.getColumnIndex(COLUMN_Image_user))));

        }

        cursor.close();
        return user;
    }
    public void updateUserById(String userId, String name, String email, Bitmap bitmap, String password) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_name, name);
        values.put(COLUMN_Email, email);
        values.put(COLUMN_Password, password);
        values.put(COLUMN_Image_user,getbyteArray(bitmap));

        String whereClause = COLUMN_Id + " = ?";
        String[] whereArgs = new String[]{String.valueOf(userId)};

        db.update(Table_User_Name, values, whereClause, whereArgs);
    }
    @SuppressLint("Range")
    public user getUserByEmailAndPassword(String email, String password) {
        SQLiteDatabase db = getReadableDatabase();

        String selection = COLUMN_Email + " = ? AND " + COLUMN_Password + " = ?";
        String[] selectionArgs = new String[]{email, password};

        Cursor cursor = db.query(Table_User_Name, null, selection, selectionArgs, null, null, null);

        user user = null;
        if (cursor.moveToFirst()) {
            user = new user();
            user.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_Id)));
            user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_name)));
            user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_Email)));
            user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_Password)));
            user.setImag(getbyteBitmap(cursor.getBlob(cursor.getColumnIndex(COLUMN_Image_user))));
        }

        cursor.close();
        return user;
    }

}
