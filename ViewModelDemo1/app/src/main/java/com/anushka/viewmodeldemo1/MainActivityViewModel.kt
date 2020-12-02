package com.anushka.viewmodeldemo1

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Int): ViewModel() {
    // no private because had to be observed by activity
    // Diff between LiveData and MutableLiveData?
    // Data in liveData can't be edited, only red.
    // Instead MutableLiveData extends LiveData and data can be changed.
    // var total = MutableLiveData<Int>()

    // But now it's visible to everyone! What should we do?
    // Let's make this private, cause is dangerous to permit someone change this value...
    private var total = MutableLiveData<Int>()

    val inputText = MutableLiveData<String>()

    // ...let's instead wrap it into LiveData! (not changeable)
    val totalData: LiveData<Int>
        get() = total

    init {
        total.value = startingTotal
    }

    // Now get function is not needed anymore, because total will be observed by MainACtivity
    fun setTotal() {
        inputText.value?.let {
            total.value = (total.value)?.plus(Integer.valueOf(it))
        }
    }
}