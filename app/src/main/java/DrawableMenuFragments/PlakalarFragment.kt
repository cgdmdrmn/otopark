package DrawableMenuFragments

import Adapter.PlakalarAdapter
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.otopark.BaseActivity
import com.example.otopark.PlakaEkleFragment
import com.example.otopark.R
import kotlinx.android.synthetic.main.fragment_plakalar.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PlakalarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlakalarFragment : Fragment() {



    private var plakalarAdapter: PlakalarAdapter? = null
    private val plakalarlist : List<String> =
        listOf("34 GA 1527", "34 CD 1527", "34 HK 2020")


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        plakalarAdapter= PlakalarAdapter(plakalarlist)
        plakalarListRecyclerView.adapter=plakalarAdapter

        buttonPlakaEkle.setOnClickListener {
            (activity as BaseActivity).changeFragment(PlakaEkleFragment(),"PLAKA_EKLE_FRAGMENT")}

            plakalarListRecyclerView.setOnClickListener {
                (activity as BaseActivity).createAlertDialog(
                    "Uyarı",
                    "Plaka silme işleminiz gerçekleşti.",
                    "Tamam",
                    DialogInterface.OnClickListener { _, _ ->  (activity as BaseActivity).changeFragment(PlakalarFragment(),"PLAKALER_FRAGMENT") },
                    null,
                    null
                )
            }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plakalar, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle("Plakalarım", R.drawable.toolbar_back_icon)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PlakalarFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PlakalarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
