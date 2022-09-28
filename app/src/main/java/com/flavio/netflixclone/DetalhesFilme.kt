package com.flavio.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.flavio.netflixclone.Adapter.FilmesAdapter
import com.flavio.netflixclone.Model.addFilmes
import com.flavio.netflixclone.databinding.ActivityDetalhesFilmeBinding
import com.squareup.picasso.Picasso

class DetalhesFilme : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesFilmeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesFilmeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        Toolbar()

        val recycler_outros_filmes = binding.recyclerOutrosFilmes
        recycler_outros_filmes.adapter = FilmesAdapter(addFilmes())
        recycler_outros_filmes.layoutManager = GridLayoutManager(applicationContext,3)

        val capaTheWitcher = "https://firebasestorage.googleapis.com/v0/b/netflix-clone-92c05.appspot.com/o/video.jpg?alt=media&token=c6367c43-de5c-4d0c-a55a-394a3ad80b5b"
        Picasso.get().load(capaTheWitcher).fit().into(binding.capa)

        binding.playVideo.setOnClickListener {
            val intent = Intent(this,Video::class.java)
            startActivity(intent)
        }
    }

    private fun Toolbar(){
        val toolbar_detalhes = binding.toolbarDetalhes
        toolbar_detalhes.setNavigationIcon(getDrawable(R.drawable.ic_voltar))
        toolbar_detalhes.setNavigationOnClickListener {
            val intent = Intent(this,ListaFilmes::class.java)
            startActivity(intent)
            finish()
        }
    }
}