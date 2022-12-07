package com.example.tpandroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tpandroid.databinding.ActivityGalleryBinding

class GalleryActivity : AppCompatActivity(), CellClickListener {
    private lateinit var binding : ActivityGalleryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind()

        val data = ArrayList<UnsplashModel>()


        for (i in 1..30) {
            data.add(UnsplashModel("https://media-exp1.licdn.com/dms/image/C4D03AQHWkLIwFqnCqw/profile-displayphoto-shrink_800_800/0/1613936183652?e=2147483647&v=beta&t=dMj_VOfiJiMfmSNEGAwg2UHW2XCJ7z6h3EnqVhF05mU", "Titre $i", "CHD", "Salut", "Voir", "BB", true))
        }

        // Configuration du layout manager
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerview.layoutManager = GridLayoutManager(this, 2)

        // Configuration de l'adapter
        recyclerview.adapter = UnsplashAdaptater(data, this)
    }

    override fun onCellClickListener(data: UnsplashModel) {
        val intent = launchNextScreen(applicationContext, data)
        startActivity(intent)
    }

    private fun bind(){
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun launchNextScreen(context: Context, model: UnsplashModel): Intent {
        val intent = Intent(context, ImageDetails::class.java)
        intent.putExtra("unsplashModel", model)
        return intent
    }

}