package com.example.tpandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GalleryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        val data = ArrayList<UnsplashModel>()

        for (i in 1..30) {
            data.add(UnsplashModel("https://media-exp1.licdn.com/dms/image/C4D03AQHWkLIwFqnCqw/profile-displayphoto-shrink_800_800/0/1613936183652?e=2147483647&v=beta&t=dMj_VOfiJiMfmSNEGAwg2UHW2XCJ7z6h3EnqVhF05mU", "Titre", "CHD", "Salut", "Like", "BB", true))
        }

        // Configuration du layout manager
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)

        // Configuration de l'adapter
        val adapter = UnsplashAdaptater(data)
        recyclerview.adapter = adapter
    }
}