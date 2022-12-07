package com.example.tpandroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tpandroid.Retrofit.RetrofitApi
import com.example.tpandroid.Retrofit.RetrofitService
import com.example.tpandroid.Retrofit.RetrofitViewModel
import com.example.tpandroid.Retrofit.RetrofitViewModelFactory
import com.example.tpandroid.databinding.ActivityGalleryBinding

class GalleryActivity : AppCompatActivity(), CellClickListener{
    private lateinit var viewModel: RetrofitViewModel
    private lateinit var retrofitService: RetrofitService
    private lateinit var adapter: UnsplashAdaptater
    private lateinit var binding : ActivityGalleryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind()

        retrofitService = RetrofitApi.getService()
        viewModel = ViewModelProvider(
            this,
            RetrofitViewModelFactory(retrofitService)
        )[RetrofitViewModel::class.java]


        // Configuration du layout manager
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerview.layoutManager = GridLayoutManager(this, 2)

        // Configuration de l'adapter
        adapter = UnsplashAdaptater(this)
        recyclerview.adapter = adapter

        initObserver()
    }

    override fun onCellClickListener(data: UnsplashModel) {
        val intent = launchNextScreen(applicationContext, data)
        startActivity(intent)
    }

    private fun initObserver(){
        println("!!------- ON EST DANS initObserver --------!!")
        viewModel.data.observe(this){
            adapter.mList= it
            println("?? ---- dans it" + it)
        }
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