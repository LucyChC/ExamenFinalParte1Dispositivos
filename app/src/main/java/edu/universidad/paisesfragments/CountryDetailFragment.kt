package edu.universidad.paisesfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.widget.Button

class CountryDetailFragment : Fragment() {

    companion object {
        fun newInstance(
            name: String,
            capital: String,
            continent: String,
            description: String
        ): CountryDetailFragment {
            val fragment = CountryDetailFragment()

            val bundle = Bundle()
            bundle.putString("name", name)
            bundle.putString("capital", capital)
            bundle.putString("continent", continent)
            bundle.putString("description", description)

            fragment.arguments = bundle

            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_country_detail, container, false)

        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvCapital = view.findViewById<TextView>(R.id.tvCapital)
        val tvContinent = view.findViewById<TextView>(R.id.tvContinent)
        val tvDescription = view.findViewById<TextView>(R.id.tvDescription)

        val name = arguments?.getString("name")
        val capital = arguments?.getString("capital")
        val continent = arguments?.getString("continent")
        val description = arguments?.getString("description")

        tvName.text = name
        tvCapital.text = "Capital: $capital"
        tvContinent.text = "Continente: $continent"
        tvDescription.text = description

        val btnBack = view.findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return view
    }
}