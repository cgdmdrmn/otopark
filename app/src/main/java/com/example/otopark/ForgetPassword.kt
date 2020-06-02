package com.example.otopark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.otopark.R.layout.activity_forget_password
import kotlinx.android.synthetic.main.activity_forget_password.*


class ForgetPassword : AppCompatActivity(){

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     setContentView(activity_forget_password)

        val btn_sfr = findViewById<Button>(R.id.btn_sfr)

          btn_sfr.setOnClickListener {
            Toast.makeText(this@ForgetPassword, "Sıfırlama e-maili gönderildi.", Toast.LENGTH_SHORT).show()
           }
}


}










//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_forget_password)

//        val btn_sfr = findViewById<Button>(R.id.btn_sfr)
// set on-click listener
 //       btn_sfr.setOnClickListener {
//            Toast.makeText(this@ForgetPassword, "Sıfırlama e-maili gönderildi.", Toast.LENGTH_SHORT).show()
 //       }

//    }

