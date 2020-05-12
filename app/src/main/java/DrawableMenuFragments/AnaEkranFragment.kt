package DrawableMenuFragments

import Adapter.YakinimdakiOtoparklarAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.otopark.R
import kotlinx.android.synthetic.main.fragment_ana_ekran.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"



class AnaEkranFragment : Fragment() {
    var fragment: Fragment? = null




    private var yakinimdakiOtoparklarAdapter: YakinimdakiOtoparklarAdapter? = null
    private val yakinimdakiotoparklarList : List<String> =
    listOf(" Büyük Beşiktaş Otoparkı", "Beşiktaş Kapalı Otopark", "Beltaş Otoparkı", "Ulus Otoparkı")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        yakinimdakiOtoparklarAdapter= YakinimdakiOtoparklarAdapter(yakinimdakiotoparklarList)
        autoparkListRecyclerView.adapter=yakinimdakiOtoparklarAdapter


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ana_ekran, container, false)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AnaEkranFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AnaEkranFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
