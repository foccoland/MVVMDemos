package it.italiaonline.mail.navdemo1.fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigator
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import it.italiaonline.mail.navdemo1.R
import it.italiaonline.mail.navdemo1.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.button.setOnClickListener {
            if(!TextUtils.isEmpty(binding.editTextTextPersonName.text.toString())) {
                val bundle = bundleOf("user_input" to binding.editTextTextPersonName.text.toString())
                val action = HomeFragmentDirections
                        .actionHomeFragmentToSecondFragment()
                it.findNavController().navigate(R.id.action_homeFragment_to_secondFragment, bundle)
            } else {
                Snackbar.make(it, "Fill with your name", Snackbar.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
}