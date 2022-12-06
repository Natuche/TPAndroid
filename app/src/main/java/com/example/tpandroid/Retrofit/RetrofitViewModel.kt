package com.example.tpandroid.Retrofit


import androidx.lifecycle.*
import kotlinx.coroutines.launch

class RetrofitViewModel (
    private val retrofitService: RetrofitService
    ) : ViewModel() {
    val accessKey = "guPcKSHWkeiqvKPLU9e30lQ9j32Xcojfa_7CGlVfQIw"

    private val _data = MutableLiveData<String>()
    val data: LiveData<String> =  _data

    init{
        viewModelScope.launch {
            _data.value = retrofitService.getRandomPhotos(accessKey,10).size.toString()
        }
    }
}

class RetrofitViewModelFactory(
    private val retrofitService: RetrofitService
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(RetrofitViewModel::class.java)) {
            RetrofitViewModel(retrofitService) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}