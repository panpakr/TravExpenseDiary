package com.example.pkumar.travexpensesdiary;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pkumar on 7/9/16.
 */
public class ExpensesDbHelper extends SQLiteOpenHelper {



    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "tripexpenses.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Expense.TABLE + " (" +
                    Expense.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    Expense.AMOUNT + TEXT_TYPE + COMMA_SEP +
                    Expense.PAYMENT_OPTION + TEXT_TYPE + COMMA_SEP +
                    Expense.NOTES + TEXT_TYPE +") ";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Expense.TABLE;

    public ExpensesDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }







private static final class Trip {

    private Trip() {

    }

    public static final String TABLE = "Trip";
    public static final String ID = "_id";
    public static final String DESTINATION = "destination";


}

public static final class Expense {

    private Expense() {

    }

    public static final String TABLE = "expense";
    public static final String ID = "_id";
    public static final String AMOUNT = "amount";
    public static final String PAYMENT_OPTION = "pay_option";
    public static final String NOTES = "notes";
}
}
