package com.example.pkumar.travexpensesdiary;

/**
 * Created by pkumar on 23/9/16.
 */
public class NetExpenses {

    private static final String NEWLINE = "\n" ;

    int totalCash;
    int totalCC;
    int totalDC;


    public int getTotalCC() {
        return totalCC;
    }

    public void setTotalCC(int totalCC) {
        this.totalCC = totalCC;
    }

    public int getTotalCash() {
        return totalCash;
    }

    public void setTotalCash(int totalCash) {
        this.totalCash = totalCash;
    }

    public int getTotalDC() {
        return totalDC;
    }

    public void setTotalDC(int totalDC) {
        this.totalDC = totalDC;
    }


    @Override
    public String toString() {
        return "Cash : " + getTotalCash() + NEWLINE +
                "Credit : "  + getTotalCC() + NEWLINE +
                "Debit : " + getTotalDC()+"";
    }
}
