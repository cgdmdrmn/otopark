package DrawableMenuFragments

import Adapter.OdemeAraclarimAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.otopark.BaseActivity
import com.example.otopark.CardsOnClickListener
import com.example.otopark.R
import kotlinx.android.synthetic.main.fragment_odeme_araclarim.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OdemeAraclarimFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OdemeAraclarimFragment : Fragment(), CardsOnClickListener {

    private var odemeAraclarimAdapter: OdemeAraclarimAdapter? = null
    private val odemearaclarimlist : MutableList<String> =
        mutableListOf("4926 **** **** **11", "1527 **** **** **89", "2222 **** **** **15")


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        odemeAraclarimAdapter= OdemeAraclarimAdapter(odemearaclarimlist, this)
        cardListRecyclerView.adapter=odemeAraclarimAdapter
        odemeAraclarimAdapter = OdemeAraclarimAdapter(odemearaclarimlist)
        cardListRecyclerView.adapter = odemeAraclarimAdapter

        buttonKartEkle.setOnClickListener {
            (activity as BaseActivity).changeFragment(KartEkleFragment(), "KART_EKLE_FRAGMENT")
        }
    }

    private fun removeItem(position: Int){
        odemearaclarimlist.removeAt(position)
        odemeAraclarimAdapter?.notifyDataSetChanged()
    }

    override fun onClick(position: Int) {
        removeItem(position)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle(
            "Ödeme Araçlarım",
            R.drawable.toolbar_hamburger_icon
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_odeme_araclarim, container, false)
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OdemeAraclarimFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OdemeAraclarimFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
