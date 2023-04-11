package com.example.aqui_estoy

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {

    private lateinit var publicationRecyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        //Get all publications
        val publicationRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_publications)

        val publication_list = arrayListOf<Publication>(
            Publication("Jose Herrera", "@Jose2012", "Publicacion de prueba numero 1"),
            Publication("Miguel Noceda", "@MNoceda", "Publicacion de mas larga Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ac est sed nunc sodales viverra nec et dolor. Duis varius condimentum posuere. Praesent sit amet tortor sed dolor aliquet convallis quis et mauris. Proin turpis sem, pretium in tortor vitae, suscipit facilisis nunc. Nullam neque nulla, elementum sed nisl eu, "),
            Publication("Magu Rojas", "@Maguito2003", "Publicacion corta "),
            Publication("Maria Holguera", "@La_Maria", "Otra Prueba"),
        )

        val linearLayoutManager = LinearLayoutManager(container!!.context)

        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        publicationRecyclerView.layoutManager = linearLayoutManager

        val act: FragmentActivity = requireActivity()

        publicationRecyclerView.adapter = PublicationListAdapter(publication_list, act)

        // Inflate the layout for this fragment
        return view
    }

}