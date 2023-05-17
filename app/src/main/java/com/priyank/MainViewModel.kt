package com.priyank

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.priyank.dogsapp.data.model.DogInfo
import com.priyank.dogsapp.data.remote.DogsApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val dogsApi: DogsApi
) : ViewModel() {

    var imageUrl = mutableStateOf("")
        private set

    fun getDogs() {
        var dog = DogInfo(0, "", "")
        viewModelScope.launch(Dispatchers.IO) {
            dog = dogsApi.getImages()
        }
        imageUrl.value = dog.message!!
    }
}
