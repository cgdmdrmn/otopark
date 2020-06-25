package com.example.otopark

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.bottom_sheet.view.*
import kotlinx.android.synthetic.main.fragment_ana_ekran.*
import kotlinx.android.synthetic.main.fragment_yotoparkbilgilerim.view.*

class YotoparkBilgilerimFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle(
            "Otopark Bilgileri",
            R.drawable.toolbar_hamburger_icon)
        (activity as BaseActivity).setNavViewVisibility(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_yotoparkbilgilerim, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        view.textOtoparkAdres.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(this.requireContext())
            val view = layoutInflater.inflate(R.layout.bottom_sheet, null)
            bottomSheetDialog.setContentView(view)
            bottomSheetDialog.show()
            view.otoparkTextView.text="Beşiktaş Kapalı Otopark"
            view.AdresTextView.text="Ihlamurdere Cd. No:126 D:1 Beşiktaş/İstanbul"
            view.buttonYolTarifi.setOnClickListener {
                val uri= Uri.parse("geo:41.049008, 29.002810")
                val intent = Intent(Intent.ACTION_VIEW,uri)
                startActivity(intent)
            }

        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = YotoparkBilgilerimFragment()
    }
}
