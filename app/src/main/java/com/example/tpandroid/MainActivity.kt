package com.example.tpandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    private lateinit var viewModel: RetrofitViewModel
    private lateinit var retrofitService: RetrofitService

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        retrofitService = RetrofitApi.getService()
        viewModel = ViewModelProvider(
            this,
            RetrofitViewModelFactory(retrofitService)
        )[RetrofitViewModel::class.java]
        //a

    }
}