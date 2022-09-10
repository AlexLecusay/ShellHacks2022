package com.example.streambill

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var mRecyclerView : RecyclerView
    private lateinit var mRecyclerViewAdapter : RecyclerListAdapter
    private var mListOfStreamingServices : MutableList<StreamingServiceInfo> = mutableListOf(
        StreamingServiceInfo(R.drawable.pvlogo, "Prime Video", "5.99"),
        StreamingServiceInfo(R.drawable.netflixlogo,"Netflix", "14.99"),
        StreamingServiceInfo(R.drawable.disneypluslogo,"Disney+", "8.99"),
        StreamingServiceInfo(R.drawable.hululogo,"Hulu", "7.99"),
        StreamingServiceInfo(R.drawable.appletvlogo,"AppleTV", "9.99"),
        StreamingServiceInfo(R.drawable.hbomaxlogo,"HBO Max", "11.99"),
        StreamingServiceInfo(R.drawable.paramountpluslogo,"Paramount+", "10.99"),
        StreamingServiceInfo(R.drawable.espnpluslogo,"ESPN+", "9.99"),
        StreamingServiceInfo(R.drawable.crunchyrolllogo,"Crunchy Roll", "9.99"),
        StreamingServiceInfo(R.drawable.dropboxlogo,"DropBox", "3.99")
        )

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mTestingButton : Button = findViewById(R.id.main_button_id)
        mTestingButton.setOnClickListener {
            startActivity(Intent(this, DifferentStreamingServices::class.java))
        }
        mRecyclerView = findViewById(R.id.main_recycler_view)
        mRecyclerViewAdapter = RecyclerListAdapter()
        mRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        mRecyclerView.adapter = mRecyclerViewAdapter


        mRecyclerViewAdapter.submitList(mListOfStreamingServices)
    }
}