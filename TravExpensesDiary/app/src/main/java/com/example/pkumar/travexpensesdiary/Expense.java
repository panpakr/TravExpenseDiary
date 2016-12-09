package com.example.pkumar.travexpensesdiary;

/**
 * Created by pkumar on 7/9/16.
 */
public class Expense
{

    private static final String TAB = "\t";
    private String id;
    private String amount;
    private String notes;
    private String paymentOption;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(String paymentOption) {
        this.paymentOption = paymentOption;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }




    @Override
    public String toString() {
        return "" +getId() + TAB
                  +getAmount() + TAB
                   +getPaymentOption()+ TAB
                   +getNotes() +"";
    }
}
