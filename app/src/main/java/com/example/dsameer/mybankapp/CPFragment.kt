package com.example.dsameer.mybankapp


import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_c.*


/**
 * A simple [Fragment] subclass.
 */
class CPFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var v= inflater!!.inflate(R.layout.fragment_c, container, false)
        var btn=v.findViewById<TextView>(R.id.cp_btn)

        btn.setOnClickListener {

            var obj=BankDB(activity)
            var db=obj.writableDatabase
            var cur=db.rawQuery("select * from users where mobile=? and password=?",
                    arrayOf(UserInfo.mobile,cp_password.text.toString()))
            if(cur.count==0)
                Toast.makeText(activity,"Wrong Password",Toast.LENGTH_LONG).show()
            else
            {
                if(cp_new.text.toString().equals(cp_confirm.text.toString()))
                {
                    db.execSQL("update users set password=? where mobile=?",
                            arrayOf(cp_new.text.toString(),UserInfo.mobile))
                    Toast.makeText(activity,"Done",Toast.LENGTH_LONG).show()
                }
            }
        }

        return v

    }

}// Required empty public constructor
