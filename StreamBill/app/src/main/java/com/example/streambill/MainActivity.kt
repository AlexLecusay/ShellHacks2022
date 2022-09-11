package com.example.streambill

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var mRecyclerView : RecyclerView
    lateinit var mRecyclerViewAdapter : RecyclerListAdapter
    private lateinit var mViewClickListener : RecyclerViewClickListener
    private lateinit var mMainSubHeader : TextView

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
        mRecyclerView = findViewById(R.id.main_recycler_view)
        mViewClickListener = object : RecyclerViewClickListener {
            override fun onItemClicked(streamingServiceInfo: StreamingServiceInfo, context : Context) {
                val intent = Intent(this@MainActivity, DifferentStreamingServices::class.java).apply {
                    putExtra("ServiceLogo", streamingServiceInfo.streamingServiceLogo)
                    putExtra("ServiceCompany", streamingServiceInfo.streamingServiceCompany)
                    putExtra("CompanyCost", streamingServiceInfo.serviceCompanyCost)
                }
                startActivity(intent)
            }
        }
        mRecyclerViewAdapter = RecyclerListAdapter(mViewClickListener)
        mRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        mRecyclerView.adapter = mRecyclerViewAdapter
        mRecyclerViewAdapter.submitList(mListOfStreamingServices)
        mMainSubHeader = findViewById(R.id.main_sub_header)
        val monthlyTotal = String.format("Monthly Total : %.2f", calculateTotalToDisplay())
        mMainSubHeader.text = monthlyTotal
    }

    private fun calculateTotalToDisplay() : Double {
        var totalCost = 0.0
        for (serviceCost in mListOfStreamingServices) {
            totalCost += serviceCost.serviceCompanyCost.toDouble()
        }
        return totalCost
    }

    interface RecyclerViewClickListener {
        fun onItemClicked(streamingServiceInfo : StreamingServiceInfo, context: Context)
    }
}