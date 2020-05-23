package com.example.otopark

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_register.*

/**
 * A simple [Fragment] subclass.
 */
class RegisterFragment : Fragment() {


    

    private fun validate() :Boolean{
        if (et_name.text.toString().isEmpty()){

            et_name.error = "Lütfen isim ve soyisminizi ekleyiniz"
            return false
        }else if (et_email.text.toString().isEmpty()){
            et_email.error = "Lütfen e-mailinizi ekleyiniz"
            return false
        }

        return true

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btn_register.setOnClickListener{if(validate()){


            Toast.makeText(context, "Hesap oluşturuldu",Toast.LENGTH_LONG).show()
        }}
    }









}



