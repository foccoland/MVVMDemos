package it.italiaonline.mail.lifecycledemo.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import it.italiaonline.mail.lifecycledemo.MainActivity
import java.lang.IllegalArgumentException

class MainViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}