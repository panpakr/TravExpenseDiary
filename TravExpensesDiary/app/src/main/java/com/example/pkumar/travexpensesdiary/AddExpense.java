package com.example.pkumar.travexpensesdiary;

        import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by pkumar on 7/9/16.
 */
public class AddExpense extends Activity implements View.OnClickListener{


    private Button add;
    private EditText trip;
    private EditText amount;
    private EditText notes;
    private RadioGroup payoption;

    private String amountVal;
    private String payoptionVal;

    private String notesVal;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_new_expense);

        intitialseViews();

    }

    private void intitialseViews() {

        add = (Button) findViewById(R.id.addAmount);
        add.setOnClickListener(this);

        payoption = (RadioGroup) findViewById(R.id.rgPay);

        trip = (EditText) findViewById(R.id.editTripDetail);
        amount = (EditText) findViewById(R.id.amount);

        notes = (EditText) findViewById(R.id.notes);


    }


    @Override
    public void onClick(View v) {




        if(v.getId()==R.id.addAmount)
        {
            Expense expense = new Expense();

            if(amount!=null&&amount.getText()!=null)
                expense.setAmount(String.valueOf(amount.getText()));

            if(notes!=null&&notes.getText()!=null)
                expense.setNotes(String.valueOf(notes.getText()));

            int rId= payoption.getCheckedRadioButtonId();
            String option = null;

            switch (rId){

                case R.id.rCash:
                    option = "Cash";
                    break;

                case R.id.rCC:
                    option = "Credit";
                    break;

                case R.id.rDC:
                    option = "Debit";
                    break;

                default:


            }


             if(option!= null)
                 expense.setPaymentOption(option);




            DataOperation dataOperation = new DataOperation(this);

            dataOperation.insertValues(expense.getAmount(),expense.getPaymentOption(),expense.getNotes());


            Toast t = Toast.makeText(this, "Expense added", Toast.LENGTH_SHORT);
            t.show();


        }

    }



}

