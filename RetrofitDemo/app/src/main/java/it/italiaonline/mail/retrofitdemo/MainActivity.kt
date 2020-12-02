package it.italiaonline.mail.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import it.italiaonline.mail.retrofitdemo.databinding.ActivityMainBinding
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var retService: AlbumService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        getRequestWithQueryParameters()
        //getRequestWithPathParameters()
        uploadAlbum()


    }

    private fun getRequestWithQueryParameters() {
        // We need now a instance of Service Interface
        retService = RetrofitInstance
                .getRetrofitInstance()
                .create(AlbumService::class.java)

        val responseLiveData: LiveData<Response<Albums>> = liveData {
            val response = retService.getSortedAlbums(3)
            emit(response)
        }

        // Now let's observe that livedata
        responseLiveData.observe(this, Observer {
            val albumsList = it.body()?.listIterator()
            if (albumsList!=null) {
                while (albumsList.hasNext()) {
                    val albumsItem = albumsList.next()
                    Log.i("MYTAG", albumsItem.title)
                    val result = "Album title: ${albumsItem.title}\n" +
                            "Album id: ${albumsItem.id}\n" +
                            "User id: ${albumsItem.userId}\n\n\n"
                    binding.apply {
                        textView.append(result)
                    }

                }
            }
        })
    }

    private fun getRequestWithPathParameters() {
        retService = RetrofitInstance
                .getRetrofitInstance()
                .create(AlbumService::class.java)

        val pathResponseLiveData: LiveData<Response<AlbumsItem>> = liveData {
            val response = retService.getAlbum(3)
            emit(response)
        }

        pathResponseLiveData.observe(this, Observer {
            val title = it.body()?.title
            Toast.makeText(applicationContext, title, Toast.LENGTH_LONG).show()
        })
    }

    private fun uploadAlbum() {
        val album = AlbumsItem(0, "NewAlbum!!", 1)
        val postResponse: LiveData<Response<AlbumsItem>> = liveData {
            val response = retService.uploadAlbum(album)
            emit(response)
        }

        postResponse.observe(this, Observer {
            val receivedAlbumsItem = it.body()
            val result = "Album title: ${receivedAlbumsItem?.title}\n" +
                    "Album id: ${receivedAlbumsItem?.id}\n" +
                    "User id: ${receivedAlbumsItem?.userId}\n\n\n"
            binding.textView.text = result
        })
    }
}