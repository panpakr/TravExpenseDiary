package com.example.pkumar.travexpensesdiary;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import graphLibrary.PieGraph;
import graphLibrary.PieSlice;

/**
 * Created by pkumar on 23/9/16.
 */
public class ExpensesSummary extends Activity {

    private TextView tvCash;
    private TextView tvCredit;
    private TextView tvDebit;

    NetExpenses net;

    private int cash;
    private int credit;
    private int debit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.expenses_summary);
        initialiseViews();
        bindValues();
        intialiseGraph();

    }

    private void bindValues() {

        net = new DataOperation(this).getTotalExpenses();

        cash = net.getTotalCash();
        credit = net.getTotalCC();
        debit = net.getTotalDC();

        tvCash.setText(String.valueOf(cash));
        tvCredit.setText(String.valueOf(credit));
        tvDebit.setText(String.valueOf(debit));


    }

    private void intialiseGraph() {

        PieGraph pg = (PieGraph)findViewById(R.id.graph);
        PieSlice slice = new PieSlice();
        slice.setColor(Color.parseColor("#99CC00"));

        slice.setValue(cash);
        pg.addSlice(slice);
        slice = new PieSlice();
        slice.setColor(Color.parseColor("#FFBB33"));
        slice.setValue(debit);
        pg.addSlice(slice);
        slice = new PieSlice();
        slice.setColor(Color.parseColor("#AA66CC"));
        slice.setValue(credit);
        pg.addSlice(slice);


       pg.setInnerCircleRatio(150);



    }

    private void initialiseViews() {

        tvCash = (TextView) findViewById(R.id.tvCash);
        tvCredit = (TextView) findViewById(R.id.tvCredit);
        tvDebit = (TextView) findViewById(R.id.tvDebit);

    }


}
