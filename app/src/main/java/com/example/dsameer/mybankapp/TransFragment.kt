package com.example.dsameer.mybankapp


import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_trans.*


/**
 * A simple [Fragment] subclass.
 */
class TransFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var v=inflater!!.inflate(R.layout.fragment_trans, container, false)

        var btn=v.findViewById<TextView>(R.id.trans_btn)
        btn.setOnClickListener {
         var obj=BankDB(activity)
            var db=obj.writableDatabase
            if (trans_d.isChecked) {
                db.execSQL("insert into trans values(?,?,?)", arrayOf(UserInfo.mobile,trans_amount.text.toString()
                ,"D"))
                db.execSQL("update users set credit=credit+? where mobile=?", arrayOf(
                        trans_amount.text.toString(),UserInfo.mobile ))
                Toast.makeText(activity, "d operation sucsess",Toast.LENGTH_LONG).show()


            }else {
                var cur=db.rawQuery("select credit from users where mobile=?",
                        arrayOf(UserInfo.mobile))
                cur.moveToFirst()
                var myCredit :Int=cur.getInt(0)
                var rq:Int=trans_amount.text.toString().toInt()
if (rq>myCredit)  Toast.makeText(activity, "Amount not valid",Toast.LENGTH_LONG).show()
                else {

    db.execSQL("insert into trans values(?,?,?)", arrayOf(UserInfo.mobile, trans_amount.text.toString()
            , "C"))
    db.execSQL("update users set credit=credit-? where mobile=?", arrayOf(
            trans_amount.text.toString(), UserInfo.mobile))
    Toast.makeText(activity, "c operation sucsess", Toast.LENGTH_LONG).show()
}


            }


        }
        return  v
    }

}// Required empty public constructor
