package DrawableMenuFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.otopark.BaseActivity
import com.example.otopark.CuzdanimaAktarFragment
import com.example.otopark.R
import kotlinx.android.synthetic.main.fragment_cuzdanim.*

class CuzdanimFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle(
            "Cüzdanım",
            R.drawable.toolbar_hamburger_icon
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cuzdanim, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonCuzdanaAktar.setOnClickListener {
            (activity as BaseActivity).changeFragment(
                CuzdanimaAktarFragment(),
                "CUZDANIMA_AKTAR_FRAGMENT"
            )
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = CuzdanimFragment()
    }
}
