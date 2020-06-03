package DrawableMenuFragments

import Adapter.PlakalarAdapter
import android.app.AlertDialog
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

class PlakalarFragment : Fragment(), PlakalarOnClickListener {

    private lateinit var plakalarAdapter: PlakalarAdapter
    private val plakalarlist: MutableList<String> =
        mutableListOf("34 GA 1527", "34 CD 1527", "34 HK 2020")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        plakalarAdapter = PlakalarAdapter(plakalarlist, this)
        plakalarListRecyclerView.adapter = plakalarAdapter
        buttonPlakaEkle.setOnClickListener {
            (activity as BaseActivity).changeFragment(PlakaEkleFragment(), "PLAKA_EKLE_FRAGMENT")
        }
    }

    private fun removeItem(position: Int) {
        plakalarlist.removeAt(position)
        plakalarAdapter.notifyDataSetChanged()
    }

    override fun onClick(position: Int) {

        val builder = AlertDialog.Builder(this.requireContext())
        builder.setTitle("Uyarı")
        builder.setMessage("Silmek istediğinize emin misiniz?")
        builder.setCancelable(false)
        builder.setPositiveButton("Evet", { dialog: DialogInterface?, which: Int ->
            removeItem(position)
        })
        builder.setNegativeButton("Hayır", { dialog: DialogInterface?, which: Int -> })
        builder.show()
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
