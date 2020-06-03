package DrawableMenuFragments

import Adapter.YakinimdakiOtoparklarAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.otopark.BaseActivity
import com.example.otopark.R
import com.example.otopark.YakinimdakiOtoparklarOnClickListener
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.bottom_sheet.view.*
import kotlinx.android.synthetic.main.fragment_ana_ekran.*

class AnaEkranFragment : Fragment(), YakinimdakiOtoparklarOnClickListener {

    private lateinit var yakinimdakiOtoparklarAdapter: YakinimdakiOtoparklarAdapter
    private val yakinimdakiotoparklarList: MutableList<String> =
        mutableListOf(
            " Büyük Beşiktaş Otoparkı",
            "Beşiktaş Kapalı Otopark",
            "Beltaş Otoparkı",
            "Ulus Otoparkı")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        yakinimdakiOtoparklarAdapter = YakinimdakiOtoparklarAdapter(yakinimdakiotoparklarList, this)
        autoparkListRecyclerView.adapter = yakinimdakiOtoparklarAdapter
    }

    private fun bottomsheet(position: Int) {
        val bottomSheetDialog = BottomSheetDialog(this.requireContext())
        val view = layoutInflater.inflate(R.layout.bottom_sheet, null)
        bottomSheetDialog.setContentView(view)
            bottomSheetDialog.show()
        view.buttonYolTarifi.setOnClickListener {
            Toast.makeText(this.requireContext(), "Yol Tarifi Tıklandı", Toast.LENGTH_LONG).show()
        }
    }

    override fun onClick(position: Int) {
        bottomsheet(position)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ana_ekran, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle(
            "Anasayfa",
            R.drawable.toolbar_hamburger_icon
        )
    }

    companion object {

        @JvmStatic
        fun newInstance() = AnaEkranFragment()
    }


}
