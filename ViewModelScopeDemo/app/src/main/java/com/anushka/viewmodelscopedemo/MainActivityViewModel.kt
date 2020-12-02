package com.anushka.viewmodelscopedemo

import androidx.lifecycle.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO


class MainActivityViewModel : ViewModel() {

    private var userRepository = UserRepository()
//    var users: MutableLiveData<List<User>> = MutableLiveData()

//    private val myJob = Job()
//    private val myScope = CoroutineScope(IO + myJob)
    val users = liveData<List<User>> {
        val result = userRepository.getUsers()
        emit(result)
    }

//    fun getUserData() {
//        viewModelScope.launch {
//            var result: List<User>? = null
//            withContext(IO) {
//                result = userRepository.getUsers()
//            }
//            users.value = result
//        }
//    }

    // Just before viewModels clears itself from the memory, we can invoke
    // onCleared() callback for define actions before clearing.
//    override fun onCleared() {
//        super.onCleared()
//        myJob.cancel()
//    }
    // but if i got a lot of viewModels in my project
    // doing that would be adding a lot of boilerplate code
    // Instead, use extension function viewModelScope, that is
    // a CoroutineScope tied to a viewModel
}