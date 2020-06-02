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
import com.example.otopark.PlakalarOnClickListener
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
class PlakalarFragment : Fragment(), PlakalarOnClickListener{

    private lateinit var plakalarAdapter: PlakalarAdapter
    private val plakalarlist : MutableList<String> =
        mutableListOf("34 GA 1527", "34 CD 1527", "34 HK 2020")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        plakalarAdapter= PlakalarAdapter(plakalarlist, this)
        plakalarListRecyclerView.adapter=plakalarAdapter
        buttonPlakaEkle.setOnClickListener {
            (activity as BaseActivity).changeFragment(PlakaEkleFragment(), "PLAKA_EKLE_FRAGMENT")
        }
    }


    private fun removeItem(position: Int){
        plakalarlist.removeAt(position)
        plakalarAdapter.notifyDataSetChanged()
    }

    override fun onClick(position: Int){
        removeItem(position)
        plakalarListRecyclerView.setOnClickListener {
            (activity as BaseActivity).createAlertDialog(
                "Uyarı",
                "Plaka silme işleminiz gerçekleşti.",
                "Tamam",
                DialogInterface.OnClickListener { _, _ ->
                    (activity as BaseActivity).changeFragment(
                        PlakalarFragment(),
                        "PLAKALER_FRAGMENT"
                    )
                },
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
        (activity as BaseActivity).changeToolbarIconAndTitle(
            "Plakalarım",
            R.drawable.toolbar_hamburger_icon
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() = PlakalarFragment()
    }
}
