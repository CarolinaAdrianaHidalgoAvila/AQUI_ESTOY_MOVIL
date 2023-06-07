package com.aquiestoy.aqui_estoy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.aquiestoy.domain.Publication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*
import com.aquiestoy.aqui_estoy.RestApiAdapterPublication as RestApiAdapterPublication

class PostPage : AppCompatActivity() {
    private lateinit var viewModel: GetPublicationViewModel
    lateinit var tvNamePet: TextView
    lateinit var tvSpecies: TextView
    lateinit var tvDatePublication: TextView
    lateinit var tvEmail: TextView
    lateinit var tvDescription: TextView
    lateinit var tvreward: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_page)

        viewModel = ViewModelProvider(this).get(GetPublicationViewModel::class.java)


        tvNamePet = findViewById(R.id.tv_namePet)
        tvSpecies = findViewById(R.id.textEspecie)
        tvDatePublication = findViewById(R.id.tv_datePublication)
        tvEmail = findViewById(R.id.textEmail)
        tvDescription = findViewById(R.id.textDescription)
        tvreward = findViewById(R.id.textReward)

        val idUser = "632333ceca137c2c4b95168c"
        val idPublication = "6388d999441e804fc380f4f5"

        viewModel.publication.observe(this, { publication ->
            publication?.let {
                updateUI(it)
            }
        })

        viewModel.fetchPublication(idUser, idPublication)
    }

        private fun updateUI(publication: Publication) {
            runOnUiThread {
                tvNamePet.text = publication.namePet
                tvSpecies.text = publication.species
                tvDatePublication.text = formatDate(publication.datePublication)
                tvEmail.text = publication.email
                tvDescription.text = publication.description
                tvreward.text= publication.reward.toString()
            }
        }

        private fun formatDate(date: String): String {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val parsedDate = dateFormat.parse(date)
            val formattedDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            return formattedDate.format(parsedDate)
        }
    }
