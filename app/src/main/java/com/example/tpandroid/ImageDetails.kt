package com.example.tpandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.tpandroid.databinding.ActivityImageDetailsBinding
import com.example.tpandroid.models.UnsplashModel

class ImageDetails : AppCompatActivity() {
    private lateinit var binding : ActivityImageDetailsBinding
    private var model : UnsplashModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind()

        model = intent.getParcelableExtra("unsplashModel")
        binding.author.text = model?.user?.username ?: ""
        binding.secondary.text = "model.user.bio"
        binding.like.text = model?.likes.toString() + " likes"
        binding.download.text = model?.downloads.toString() + " téléchargements"

        Glide.with(applicationContext)
            .load(model?.urls?.regular)
            .fitCenter()
            .into(binding.imageView)

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
                if (model?.liked_by_user == true) {
                    item.setIcon(R.drawable.favorite_red)
                    Toast.makeText(this,"Favoris",Toast.LENGTH_LONG).show()
                    model?.liked_by_user = true
                }
                else {
                    item.setIcon(R.drawable.favorite_red_outlined)
                    model?.liked_by_user = false
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