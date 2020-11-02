package com.example.white.ui.list

import androidx.lifecycle.ViewModel
import com.example.white.data.Repository

class ListViewModel(private val repository: Repository) : ViewModel(

) {
    val liveData = repository.getLocalLive()
    init {
        refresh()
    }
    fun refresh(){
        repository.getRemote()
    }

}