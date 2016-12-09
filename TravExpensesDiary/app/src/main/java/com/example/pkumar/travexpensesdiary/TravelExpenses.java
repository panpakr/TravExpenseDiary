package com.example.pkumar.travexpensesdiary;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by pkumar on 22/11/16.
 */

public class TravelExpenses extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);


    }
}
