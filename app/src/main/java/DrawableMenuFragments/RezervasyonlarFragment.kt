package DrawableMenuFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.otopark.*
import kotlinx.android.synthetic.main.fragment_rezervasyonlar.*

class RezervasyonlarFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle(
            "Rezervasyonlarım",
            R.drawable.toolbar_hamburger_icon
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rezervasyonlar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonRezervasyonlarim.setOnClickListener {
            (activity as BaseActivity).changeFragment(
                GecmisRezervasyonlarimFragment(),
                "GECMİS_REZERVASYON_FRAGMENT"
            )
        }
        buttonRezervasyonEkle.setOnClickListener {
            (activity as BaseActivity).changeFragment(
                RezervasyonEkleFragment(),
                "GECMİS_REZERVASYON_FRAGMENT"
            )
        }
        buttonParkUzat.setOnClickListener {
            (activity as BaseActivity).changeFragment(ParkSureUzatFragment(), "PARK_SURE_FRAGMENT")
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = RezervasyonlarFragment()
    }
}
