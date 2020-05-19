package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.otopark.BaseActivity
import com.example.otopark.ForgetPassword
import com.example.otopark.R
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_login, container, false)!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_login.setOnClickListener {
            context?.startActivity(
                Intent(
                    context,
                    BaseActivity::class.java
                )
            )
        }
        btn_frgt.setOnClickListener {
            context?.startActivity(
                Intent(
                    context,
                    ForgetPassword::class.java
                )
            )
        }
    }
}


