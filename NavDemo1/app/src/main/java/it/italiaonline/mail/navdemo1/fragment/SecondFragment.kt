package it.italiaonline.mail.navdemo1.fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import it.italiaonline.mail.navdemo1.R
import it.italiaonline.mail.navdemo1.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)
        var input = arguments?.getString("user_input")
        binding.textView.text = input
        return binding.root
    }
}