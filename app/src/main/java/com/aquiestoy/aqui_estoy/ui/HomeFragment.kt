package com.aquiestoy.aqui_estoy.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aquiestoy.aqui_estoy.R
import com.aquiestoy.domain.LostPublication
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var publicationRecyclerView: RecyclerView

    private val mainViewModel: MainViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        //Get all publications
        publicationRecyclerView = view.findViewById(R.id.recyclerView_publications)

        setLayoutRecyclerView(container!!.context)

        mainViewModel.model.observe(viewLifecycleOwner, Observer(::updateUi))

        mainViewModel.loadPublications()

        return view
    }

    private fun setLayoutRecyclerView(context: Context) {
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        publicationRecyclerView.layoutManager = layoutManager
    }

    private fun updateUi(uiModel: MainViewModel.UiModel?) {

        when( uiModel) {
            is MainViewModel.UiModel.Content -> showList(uiModel.lostPublications)
            else -> Toast.makeText(context, "AS", Toast.LENGTH_SHORT).show()
        }

    }
    private fun showList(list: List<LostPublication>) {
        publicationRecyclerView.adapter = LostPublicationListAdapter(list)
    }
}