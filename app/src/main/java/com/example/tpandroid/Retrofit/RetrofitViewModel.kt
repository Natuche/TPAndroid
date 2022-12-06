package com.example.tpandroid.Retrofit


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RetrofitViewModel (
    private val retrofitService: RetrofitService
    ) : ViewModel() {
    private val _data = MutableLiveData<String>()
    val data: LiveData<String> =  _data

    init{
        viewModelScope.launch {
            _data.value = retrofitService.getRandomPhotos().size.toString()
        }
    }
}