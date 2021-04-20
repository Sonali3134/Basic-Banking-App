package com.sonali.banksystemapp;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserContract.UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserContract.UserEntry.TABLE_NAME + " ("
                + UserContract.UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserContract.UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserContract.UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserContract.UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserContract.UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserContract.UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(1000,'Sonali Sankpal', 'sonali@gmail.com','2000','9898641238', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1001,'Neha Mahajan', 'neha@gmail.com','2001','7885641238', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1002,'Vasim Gadkari', 'vashu@gmail.com','2002','7595645896', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1003,'Vaishanavi Mankapure', 'vaish@gmail.com','2003','9995640038', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1004,'Shreya Patil', 'shivani@gmail.com','2004','9095648962', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(1005,'Sumati Murgunde', 'sumo@gmail.com','2005','8855640238', 6500)");
        db.execSQL("insert into " + TABLE_NAME + " values(1006,'Vrushali Magdum', 'vrush@gmail.com','2006','8895640215', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(1007,'Pravin Prasad', 'pravin@gmail.com','2007','9985021539', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(1008,'Swanand Patil', 'swanny@gmail.com','2008','9309565238', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(1009,'Pranav Powar', 'pranav@gmail.com','2009','8292591201', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(1010,'Abhijit Mahadik', 'abhi@gmail.com','2010','9015641200', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(1011,'Shivani Bhavdhankar', 'shivani@gmail.com','2011','9995641999', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1012,'Shweta Bhavdhankar', 'shwetu@gmail.com','2012','9119541001', 5800)");
        db.execSQL("insert into " + TABLE_NAME + " values(1013,'Shailesh Sankpal', 'shailesh@gmail.com','2013','7584642205', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(1014,'Sakshi Sankpal', 'sakshi@gmail.com','2014','6893641266', 1010)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserContract.UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserContract.UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserContract.UserEntry.TABLE_NAME + " where " +
                        UserContract.UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo,
                null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserContract.UserEntry.TABLE_NAME + " set " + UserContract.UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserContract.UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}