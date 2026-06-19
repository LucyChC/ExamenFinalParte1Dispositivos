package edu.universidad.paisesfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CountryListFragment : Fragment() {

    private val countries = listOf(
        Country(
            "Costa Rica",
            "San José",
            "América",
            "País centroamericano conocido por su biodiversidad, playas y turismo ecológico."
        ),
        Country(
            "México",
            "Ciudad de México",
            "América",
            "País reconocido por su cultura, gastronomía, historia y sitios arqueológicos."
        ),
        Country(
            "España",
            "Madrid",
            "Europa",
            "País europeo con gran influencia histórica, cultural y lingüística."
        ),
        Country(
            "Japón",
            "Tokio",
            "Asia",
            "País asiático reconocido por su tecnología, cultura tradicional y desarrollo urbano."
        ),
        Country(
            "Brasil",
            "Brasilia",
            "América",
            "País sudamericano conocido por su extensión territorial, fútbol y diversidad natural."
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_country_list, container, false)

        val rvCountries = view.findViewById<RecyclerView>(R.id.rvCountries)

        rvCountries.layoutManager = LinearLayoutManager(requireContext())

        rvCountries.adapter = CountryAdapter(countries) { selectedCountry ->
            val detailFragment = CountryDetailFragment.newInstance(
                selectedCountry.name,
                selectedCountry.capital,
                selectedCountry.continent,
                selectedCountry.description
            )

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, detailFragment)
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}