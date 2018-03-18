package com.example.dsameer.mybankapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class HomeAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.bank_menu,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var tr=fragmentManager.beginTransaction()
        if (item.itemId==R.id.item_cp)
        {
            var obj=CPFragment()
            tr.replace(R.id.container,obj)
            tr.commit()
        }
        else if (item.itemId==R.id.item_credit)
        {
            var obj=CreditFragment()
            tr.replace(R.id.container,obj)
            tr.commit()
        }

        else if (item.itemId==R.id.item_trans)
        {
            var obj=TransFragment()
            tr.replace(R.id.container,obj)
            tr.commit()
        }

        else if (item.itemId==R.id.item_report)
        {
            var obj=ReportFragment()
            tr.replace(R.id.container,obj)
            tr.commit()
        }

        else if (item.itemId==R.id.item_logout)
        {
            var sp=getSharedPreferences("user_info", Context.MODE_PRIVATE)
            var editor=sp.edit()
            editor.clear()
            editor.commit()
            UserInfo.mobile=""
            finish()
            var i=Intent(this,MainActivity::class.java)
            startActivity(i)
        }


        return super.onOptionsItemSelected(item)
    }
}
