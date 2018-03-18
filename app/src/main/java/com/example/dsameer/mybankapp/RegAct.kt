package com.example.dsameer.mybankapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_reg.*

class RegAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

        reg_reg.setOnClickListener {

            if(reg_password.text.toString().equals(reg_confirm.text.toString()))
            {
                var obj=BankDB(this)
                var db=obj.writableDatabase
                var cur=db.rawQuery("select * from users where mobile=?",
                        arrayOf(reg_username.text.toString()))
                if(cur.count==0)
                {
                    db.execSQL("insert into users values(?,?,?,?)",
                            arrayOf(reg_username.text.toString(),reg_password.text.toString(),
                                    reg_name.text.toString(),0))

                    UserInfo.mobile=reg_username.text.toString()
                    var i=Intent(this,HomeAct::class.java)
                    startActivity(i)
                }
                else
                    Toast.makeText(this,"Mobile already exist",Toast.LENGTH_LONG).show()

            }
            else
            {
                Toast.makeText(this,"Password not match",Toast.LENGTH_LONG).show()
            }

        }
    }
}
