package com.anushka.viewmodeldemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.anushka.viewmodeldemo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    val viewModelFactory = MainActivityViewModelFactory(0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)

        //LiveData is binded with lifecycle of activity/fragment,
        // so we have to provide the lifecycle owner
        binding.lifecycleOwner = this

        //binded viewModel object declared in layout is assigned here
        binding.myViewModel = viewModel

    }
}
