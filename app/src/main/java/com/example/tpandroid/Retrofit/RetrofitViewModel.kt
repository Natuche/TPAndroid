package com.example.tpandroid.Retrofit


import androidx.lifecycle.*
import com.example.tpandroid.UnsplashModel
import kotlinx.coroutines.launch

class RetrofitViewModel (
    private val retrofitService: RetrofitService
    ) : ViewModel() {
    val accessKey = "guPcKSHWkeiqvKPLU9e30lQ9j32Xcojfa_7CGlVfQIw"

    private val _data = MutableLiveData<List<UnsplashModel>>()
    val data: LiveData<List<UnsplashModel>> =  _data

    init{
        viewModelScope.launch {
            _data.value = retrofitService.getRandomPhotos(accessKey,10)
            println("!0!0!0!0!0!0!0!0!0!0!0!0!0 --- CA SOIRT DE L API"+_data.value)
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