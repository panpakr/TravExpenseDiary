package com.example.pkumar.travexpensesdiary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pkumar on 7/9/16.
 */
public class DataOperation {


    private Context mContext;
    private List expenses;

    public DataOperation(Context mContext) {
        this.mContext = mContext;
    }


    public long insertValues(String amount, String paymentOption, String notes) {
        ExpensesDbHelper expensesDbHelper = new ExpensesDbHelper(mContext);

        SQLiteDatabase sqLiteDatabase = expensesDbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(ExpensesDbHelper.Expense.AMOUNT, amount);
        cv.put(ExpensesDbHelper.Expense.PAYMENT_OPTION, paymentOption);
        cv.put(ExpensesDbHelper.Expense.NOTES, notes);

        return sqLiteDatabase.insert(ExpensesDbHelper.Expense.TABLE, null, cv);

    }

    ArrayList<Expense> getTripexpenses() {

        ExpensesDbHelper mDbHelper = new ExpensesDbHelper(mContext);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                ExpensesDbHelper.Expense.ID,
                ExpensesDbHelper.Expense.AMOUNT,
                ExpensesDbHelper.Expense.PAYMENT_OPTION,
                ExpensesDbHelper.Expense.NOTES};


        Cursor c = db.query(
                ExpensesDbHelper.Expense.TABLE,                    // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        expenses = new ArrayList<Expense>();

        c.moveToFirst();

        while (!c.isAfterLast()) {
            Expense e = new Expense();


            String exid = c.getString(c.getColumnIndexOrThrow(ExpensesDbHelper.Expense.ID));
            String amount = c.getString(c.getColumnIndexOrThrow(ExpensesDbHelper.Expense.AMOUNT));
            String payOption = c.getString(c.getColumnIndexOrThrow(ExpensesDbHelper.Expense.PAYMENT_OPTION));
            String notes = c.getString(c.getColumnIndexOrThrow(ExpensesDbHelper.Expense.NOTES));

            e.setId(exid);
            e.setAmount(amount);
            e.setPaymentOption(payOption);
            e.setNotes(notes);
            System.out.println(e.toString());

            expenses.add(e);
            c.moveToNext();
        }

        return (ArrayList<Expense>) expenses;
    }


    public NetExpenses getTotalExpenses(){

        ExpensesDbHelper mDbHelper = new ExpensesDbHelper(mContext);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();


        String totalQuery = "SELECT  SUM(amount),pay_option FROM expense GROUP BY pay_option";

        Cursor cursor = db.rawQuery(totalQuery,null);

        NetExpenses net = new NetExpenses();


        if(cursor != null){

            cursor.moveToFirst();

            while (!cursor.isAfterLast()){
                int amt = Integer.parseInt(cursor.getString(0));

                switch (cursor.getString(1)){
                    case "Cash" :
                        net.setTotalCash(amt);
                        break;
                    case "Debit" :
                        net.setTotalDC(amt);
                        break;
                    case "Credit":
                        net.setTotalCC(amt);
                        break;

                    default:

                }

                cursor.moveToNext();
            }
        }
            cursor.close();
        System.out.println(net.toString());
        return net;


    }
}
