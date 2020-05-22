package DrawableMenuFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.otopark.*
import kotlinx.android.synthetic.main.fragment_rezervasyonlar.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RezervasyonlarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RezervasyonlarFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle("Rezervasyonlarım", R.drawable.toolbar_back_icon)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
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
            (activity as BaseActivity).changeFragment(GecmisRezervasyonlarimFragment(),"GECMİS_REZERVASYON_FRAGMENT")
        }
        buttonRezervasyonEkle.setOnClickListener {
            (activity as BaseActivity).changeFragment(RezervasyonEkleFragment(),"GECMİS_REZERVASYON_FRAGMENT")
        }
        buttonParkUzat.setOnClickListener {
            (activity as BaseActivity).changeFragment(ParkSureUzatFragment(),"PARK_SURE_FRAGMENT")
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RezervasyonlarFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RezervasyonlarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
