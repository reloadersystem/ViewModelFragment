package ar.reloadersystem.viewmodelfragment


import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_box.*


/**
 * A simple [Fragment] subclass.
 */
class BoxFragment : Fragment() {

    private lateinit var viewModel: ColorViewModel

    //recibe
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_box, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = activity?.run {
            ViewModelProviders.of(this).get(ColorViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.colorSelected.observe(this, colorSeletedObsrver)
    }

    private val colorSeletedObsrver = Observer<Int> {
        Log.v("CONSOLE", "BoxFragment colorSelectedObserver $it")
        paintColor(it)
    }

    private fun paintColor(position: Int?) {
        val color = when (position) {
            1 -> Color.parseColor("#CC2EFA")
            2 -> Color.parseColor("#FE2E2E")
            3 -> Color.parseColor("#F7FE2E")
            else -> 0
        }
        flayBox.setBackgroundColor(color)
    }


}
