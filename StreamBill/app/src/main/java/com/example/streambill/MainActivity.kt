package com.example.streambill

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    lateinit var mRecyclerView : RecyclerView
    lateinit var mRecyclerViewAdapter : RecyclerListAdapter
    private var mListOfStreamingServices : MutableList<StreamingServiceInfo> = mutableListOf(
        StreamingServiceInfo("Prime Video", "5.99"),
        StreamingServiceInfo("Hulu", "7.99"),
        StreamingServiceInfo("Netflix", "14.99"),
        StreamingServiceInfo("Disney+", "8.99"),
        StreamingServiceInfo("HBO+", "11.99"),
        StreamingServiceInfo("Paramount+", "10.99"),
        StreamingServiceInfo("ESPN+", "9.99"),
        StreamingServiceInfo("Crunchy Roll", "9.99"),
        StreamingServiceInfo("DropBox", "3.99"),
        StreamingServiceInfo("AppleTV", "9.99"),
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