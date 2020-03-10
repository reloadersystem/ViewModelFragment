package ar.reloadersystem.viewmodelfragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_bottom.*

/**
 * A simple [Fragment] subclass.
 */
class BottomFragment : Fragment() {

    private lateinit var viewModel: ColorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //viewmodel se comunica con  view model provider
        viewModel = activity?.run {
            ViewModelProviders.of(this).get(ColorViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    //envia
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnBox0.setOnClickListener{
            selectedColor(1)
        }
        btnBox1.setOnClickListener{
            selectedColor(2)
        }

        btnBox2.setOnClickListener{
            selectedColor(3)
        }
    }

    private fun selectedColor(color: Int) {
        Log.v("CONSOLE", "bottomBarFragment $color")
        viewModel.selectedColor(color)


    }
}
