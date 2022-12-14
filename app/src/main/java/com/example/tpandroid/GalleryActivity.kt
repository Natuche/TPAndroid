package com.example.tpandroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tpandroid.Retrofit.RetrofitApi
import com.example.tpandroid.Retrofit.RetrofitService
import com.example.tpandroid.Retrofit.RetrofitViewModel
import com.example.tpandroid.Retrofit.RetrofitViewModelFactory
import com.example.tpandroid.databinding.ActivityGalleryBinding
import com.example.tpandroid.models.LikedModel
import com.example.tpandroid.models.UnsplashModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GalleryActivity : AppCompatActivity(), CellClickListener, LikeClickListener{
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

        val data = ArrayList<UnsplashModel>()

        // Configuration du layout manager
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerview.layoutManager = GridLayoutManager(this, 2)

        // Configuration de l'adapter
        adapter = UnsplashAdaptater(this, this)
        recyclerview.adapter = adapter

        initObserver()
    }

    override fun onCellClickListener(data: UnsplashModel) {
        val intent = launchNextScreen(applicationContext, data)
        startActivity(intent)
    }

    override fun onLikeClickListener(data: UnsplashModel) {
        CoroutineScope(Dispatchers.IO).launch {
            val new: LikedModel = retrofitService.postLike(data.id, "btwOfVURw2GZWxG_5CY9zJRX2Nn_Qey0FrtBEdz25zg")
            displayToast(new.photo.liked_by_user.toString(), Toast.LENGTH_LONG)
        }
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

    private fun displayToast(text: String, duration: Int){
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }

}