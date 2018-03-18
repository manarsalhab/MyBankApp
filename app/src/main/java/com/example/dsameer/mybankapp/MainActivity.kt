package com.example.dsameer.mybankapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_reg.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var sp=getSharedPreferences("user_info", Context.MODE_PRIVATE)
var m=sp.getString("mobile","")

        if(!m.equals("")) {
            UserInfo.mobile=sp.getString("mobile","") //or m
            var i=Intent(this,HomeAct::class.java)
            startActivity(i)
        }
        login_reg.setOnClickListener {

            var i=Intent(this,RegAct::class.java)
            startActivity(i)
        }

        login_btn.setOnClickListener {

            var obj=BankDB(this)
            var db=obj.readableDatabase
            var cur=db.rawQuery("select * from users where mobile=? and password=?",
                    arrayOf(login_username.text.toString(),login_password.text.toString()))
            if(cur.count==0)
            {
                Toast.makeText(this,"Login Fail",Toast.LENGTH_LONG).show()
            }
            else
            {
                if (login_chk.isChecked){
                var sp=getSharedPreferences("user_info", Context.MODE_PRIVATE)
                var editor=sp.edit()
                editor.putString("mobile",login_username.text.toString())
                editor.commit() }
                UserInfo.mobile=login_username.text.toString()
                var i=Intent(this,HomeAct::class.java)
                startActivity(i)
            }

        }

    }
}
