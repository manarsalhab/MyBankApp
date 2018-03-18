package com.example.dsameer.mybankapp


import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView


/**
 * A simple [Fragment] subclass.
 */
class ReportFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var v=inflater!!.inflate(R.layout.fragment_report, container, false)
      var lv=v.findViewById<ListView>(R.id.report_lv)
        var list=ArrayList<String>()
        var obj=BankDB(activity)
        var db=obj.readableDatabase
        var cur=db.rawQuery("select * from trans where mobile=?", arrayOf(UserInfo.mobile))
        cur.moveToFirst()
        while (cur.isAfterLast==false) {
            list.add(cur.getString(1)+"-"+cur.getString(2))
            cur.moveToNext()
        }
        var adp=ArrayAdapter<String>(activity,R.layout.my_row,list)
        lv.adapter = adp
        return v
    }

}// Required empty public constructor
