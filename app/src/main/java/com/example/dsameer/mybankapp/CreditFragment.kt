package com.example.dsameer.mybankapp


import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_credit.*


/**
 * A simple [Fragment] subclass.
 */
class CreditFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {



       var v= inflater!!.inflate(R.layout.fragment_credit, container, false)
        var tv=v.findViewById<TextView>(R.id.credit_tv)

        var obj=BankDB(activity)
        var db=obj.readableDatabase
        var cur=db.rawQuery("select credit from users where mobile=?",
                arrayOf(UserInfo.mobile))
        cur.moveToFirst()
        tv.text=cur.getString(0)


        return v
    }

}// Required empty public constructor
