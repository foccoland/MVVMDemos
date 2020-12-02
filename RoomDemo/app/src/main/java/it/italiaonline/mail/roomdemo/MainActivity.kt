package it.italiaonline.mail.roomdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import it.italiaonline.mail.roomdemo.databinding.ActivityMainBinding
import it.italiaonline.mail.roomdemo.db.Subscriber
import it.italiaonline.mail.roomdemo.db.SubscriberDatabase
import it.italiaonline.mail.roomdemo.db.SubscriberRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var subscriberViewModel: SubscriberViewModel
    private val TAG = MainActivity::class.simpleName
    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao = SubscriberDatabase.getInstance(application).subscriberDAO
        val repository = SubscriberRepository(dao)

        val factory = SubscriberViewModelFactory(repository)

        subscriberViewModel = ViewModelProvider(this, factory).get(SubscriberViewModel::class.java)

        binding.myViewModel = subscriberViewModel

        binding.lifecycleOwner = this

        initRecyclerView()

    }

    private fun initRecyclerView() {
        binding.subscriberRecyclerView.layoutManager = LinearLayoutManager(this)
        displaySubscribersList()
    }

    private fun displaySubscribersList() {
        subscriberViewModel.subscribers.observe(this, Observer {
            Log.i(TAG, it.toString())
            binding.subscriberRecyclerView.adapter = MyRecyclerViewAdapter(it, {selectedItem: Subscriber -> listItemClicked(selectedItem)})
        })
    }

    private fun listItemClicked(subscriber: Subscriber) {
        Toast.makeText(this, "Selected name is ${subscriber.name}", Toast.LENGTH_LONG).show()
        subscriberViewModel.initUpdateAndDelete(subscriber)
    }
}