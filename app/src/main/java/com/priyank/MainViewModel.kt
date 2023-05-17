package com.priyank

import androidx.lifecycle.ViewModel
import com.priyank.dogsapp.data.local.DogDatabase
import com.priyank.dogsapp.data.remote.DogsApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val dogsApi: DogsApi,
    val dogDb: DogDatabase
) : ViewModel() {

    private val _imageUrl = MutableStateFlow("")
    val imageUrl: StateFlow<String>
        get() = _imageUrl

    private val _state = MutableStateFlow(true)
    val state: StateFlow<Boolean>
        get() = _state

    private val _recents = MutableStateFlow<List<String>>(emptyList())
    val recents: StateFlow<List<String>>
        get() = _recents

    suspend fun getDogs() {

        _state.value = false

        val dog = dogsApi.getImages()

        _imageUrl.value = dog.message!!

        val totalEntries = dogDb.DogsDao.getTotalEntries()

        if (totalEntries > 20) {
            dogDb.DogsDao.deleteFirstEntry()
        }
        dogDb.DogsDao.insertImage(dog)
        _state.value = true
    }

    suspend fun getRecentDogs() {
        val list = dogDb.DogsDao.getAllImages()
        _recents.value = list.map { it.message!! }
    }

    suspend fun clearDogs() {
        dogDb.DogsDao.deleteAllEntries()
        _recents.value = emptyList()
    }
}
