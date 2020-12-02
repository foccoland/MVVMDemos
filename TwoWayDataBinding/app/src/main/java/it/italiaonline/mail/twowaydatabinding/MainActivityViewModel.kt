package it.italiaonline.mail.twowaydatabinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    val username = MutableLiveData<String>()

    init {
        username.value = "Frank"
    }
}