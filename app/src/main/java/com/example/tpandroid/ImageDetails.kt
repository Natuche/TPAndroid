package com.example.tpandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.tpandroid.databinding.ActivityImageDetailsBinding

class ImageDetails : AppCompatActivity() {
    var isFavori:Boolean = false
    private lateinit var binding : ActivityImageDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind()

        val model : UnsplashModel = intent.getParcelableExtra("unsplashModel")!!
        binding.author.text = model.author
        binding.secondary.text = model.title
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_image_details,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when (item.itemId) {
            R.id.favorite -> {
                if (!isFavori) {
                    item.setIcon(R.drawable.ic_baseline_favorite_24)
                    Toast.makeText(this,"Favoris",Toast.LENGTH_LONG).show()
                    isFavori = true
                }
                else {
                    item.setIcon(R.drawable.ic_baseline_favorite_border_24)
                    isFavori = false
                }
            }
            else -> { Toast.makeText(this,"action inconnu",Toast.LENGTH_LONG).show() }
        }
        return true
    }

    private fun bind(){
        binding = ActivityImageDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}