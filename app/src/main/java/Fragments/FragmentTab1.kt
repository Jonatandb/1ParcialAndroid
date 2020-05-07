package Fragments

import Entities.Sport
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso

import com.utn.tp3.R
import database.appDatabase
import database.sportDao

class FragmentTab1 : Fragment() {

    lateinit var view_tab1: View

    lateinit var imagen: ImageView
    lateinit var texto: TextView

    companion object {
        fun newInstance() = FragmentTab1()
    }

    private val viewModel: FragmentTab1ViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        view_tab1 = inflater.inflate(R.layout.fragment_tab1, container, false)

        imagen = view_tab1.findViewById(R.id.img_sport)
        texto = view_tab1.findViewById(R.id.txt_sport)

        return view_tab1
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
        viewModel.ItemClicked.observe(viewLifecycleOwner, Observer { result ->
            texto.text = result.descripcion
            Picasso.get()
                    .load(result.urlImage)
                    .into(imagen)
        })
    }

    override fun onStart() {
        super.onStart()

        //Log.d("Test", SportClicked.descripcion)

    }

}
