package com.example.otopark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class ForgetPassword : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        val btn_sfr = findViewById<Button>(R.id.btn_sfr)
// set on-click listener
        btn_sfr.setOnClickListener {
            Toast.makeText(this@ForgetPassword, "Sıfırlama e-maili gönderildi.", Toast.LENGTH_SHORT).show()
        }

    }
}
