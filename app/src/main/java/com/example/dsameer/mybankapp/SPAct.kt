package com.example.dsameer.mybankapp

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sp.*

class SPAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sp)
        var sp=getSharedPreferences("my_info", Context.MODE_PRIVATE)

        button.setOnClickListener {
            var editor=sp.edit()
            editor.putString("name",editText.text.toString())
            editor.commit()
            Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show()

        }

        button2.setOnClickListener {
           textView.text=sp.getString("name","")



        }
    }
}
