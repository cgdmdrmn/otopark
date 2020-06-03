package DrawableMenuFragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loginapp.LoginFragment
import com.example.otopark.*
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle(
            "Hesabım",
            R.drawable.toolbar_hamburger_icon
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonBilgilerim.setOnClickListener {
            (activity as BaseActivity).changeFragment(BilgilerimFragment(), "BILGILERIM_FRAGMENT")
        }
        buttonRezervasyon.setOnClickListener {
            (activity as BaseActivity).changeFragment(
                GecmisRezervasyonlarimFragment(),
                "GECMIS_REZERVASYONLAR_FRAGMENT"
            )
        }
        buttonBildirim.setOnClickListener {
            (activity as BaseActivity).changeFragment(
                IletisimTercihlerimFragment(),
                "REZERVASYONLAR_FRAGMENT"
            )
        }

        buttonExit.setOnClickListener {

            val builder = AlertDialog.Builder(this.requireContext())
            builder.setTitle("Çıkış")
            builder.setMessage("Çıkış yapmak istediğinize emin misiniz?")
            builder.setCancelable(false)
            builder.setPositiveButton("Evet", { dialog: DialogInterface?, which: Int ->
                (activity as BaseActivity).changeFragment(
                    LoginFragment(),
                    "LOGIN_FRAGMENT"
                )
            })
            builder.setNegativeButton("Hayır", { dialog: DialogInterface?, which: Int ->

                (activity as BaseActivity).changeFragment(
                    ProfileFragment(),
                    "PROFILE_FRAGMENT"
                )
            })
            builder.show()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = ProfileFragment()
    }
}
