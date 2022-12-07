package com.example.tpandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import androidx.lifecycle.ViewModelProvider
import com.example.tpandroid.Retrofit.RetrofitApi
import com.example.tpandroid.Retrofit.RetrofitService
import com.example.tpandroid.Retrofit.RetrofitViewModel
import com.example.tpandroid.Retrofit.RetrofitViewModelFactory
import com.example.tpandroid.databinding.ActivityMainBinding
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)



        val fab: View = findViewById(R.id.newButton)
        fab.setOnClickListener {
            val intent = Intent(applicationContext, GalleryActivity::class.java)
            startActivity(intent)
        }


    }
}