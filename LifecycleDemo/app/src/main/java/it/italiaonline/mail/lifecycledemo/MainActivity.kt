package it.italiaonline.mail.lifecycledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import it.italiaonline.mail.lifecycledemo.databinding.MainActivityBinding
import it.italiaonline.mail.lifecycledemo.ui.main.MainFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }

        lifecycleScope.launch {
            delay(5000)
            binding.apply {
                progressBar.visibility = View.VISIBLE
                delay(10000)
                progressBar.visibility = View.GONE
            }
        }
    }
}