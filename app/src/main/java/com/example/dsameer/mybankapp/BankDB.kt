package com.example.dsameer.mybankapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BankDB(con:Context) : SQLiteOpenHelper(con,"bank.db",null,1) {

    override fun onCreate(p0: SQLiteDatabase) {

        p0.execSQL("create table users(mobile text,password text,name text,credit integer)")
        p0.execSQL("create table trans(mobile text,amount integer,dw text)")

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}