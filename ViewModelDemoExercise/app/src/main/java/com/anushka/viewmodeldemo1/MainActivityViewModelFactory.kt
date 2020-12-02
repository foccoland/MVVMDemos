package com.anushka.viewmodeldemo1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class MainActivityViewModelFactory(private val startingCount: Int): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        // Here I have to consider the object that have power to assign ViewModel,
        // and so it is ViewModel
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(startingCount) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}