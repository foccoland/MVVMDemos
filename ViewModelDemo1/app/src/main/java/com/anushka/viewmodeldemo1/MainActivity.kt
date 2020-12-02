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
    private lateinit var viewModelFactoryMain: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactoryMain = MainActivityViewModelFactory(125)

        viewModel = ViewModelProvider(this, viewModelFactoryMain).get(MainActivityViewModel::class.java)

        // assign viewmodel to binding myViewModel
        binding.myViewModel = viewModel

        // We also need to provide datacycle ownler
        binding.lifecycleOwner = this

        // After assigning lifecycle to activity and correctly
        // used viewmodel in layout file (specifically on totaldata)
        // we can remove this observer

/*        // observe viewModel from mainActivity
        viewModel.totalData.observe(this, Observer {
            // assign observed value (it) at view by databinding
            binding.result.text = it.toString()
        })*/

        // we can remove this after onClick layout implementing
/*        binding.button.setOnClickListener {
            binding.apply {
                viewModel.setTotal(addend.text.toString().toInt())
            }
        }*/
    }

}
