package com.example.streambill

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView

class DifferentStreamingServices : Activity() {

    private lateinit var mStreamingServiceLogo : ImageView
    private lateinit var mStreamingServiceDescription : TextView
    private lateinit var mStreamingServiceCost : TextView
    private lateinit var mCancelStreamingService : CardView
    private lateinit var mReturnButton : Button
    private lateinit var mCancelSubListener : MainActivity.RecyclerViewClickListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_streaming_services)
        mStreamingServiceLogo = findViewById(R.id.detailed_image)
        mStreamingServiceDescription = findViewById(R.id.detailed_description)
        mStreamingServiceCost = findViewById(R.id.detailed_pricing)
        mStreamingServiceLogo.setImageResource(intent.extras!!.getInt("ServiceLogo"))
        mCancelStreamingService = findViewById(R.id.detailed_card_view_cancel)
        mReturnButton = findViewById(R.id.detailed_return_button)
        val monthlyCost = "Monthly cost: ${intent.extras!!.getString("CompanyCost")}"
        mStreamingServiceDescription.text = monthlyCost
        val yearlyCost = "Yearly cost: ${(intent.extras!!.getString("CompanyCost")?.toDouble()
            ?.times(12)).toString()}"
        mStreamingServiceCost.text = yearlyCost
        mReturnButton.setOnClickListener {
            finish()
        }
//        mCancelSubListener = object : MainActivity.RecyclerViewClickListener {
//            override fun onItemClicked(streamingServiceInfo: StreamingServiceInfo, context : Context) {
//
//            }
//        }
//        mCancelStreamingService.setOnClickListener(mCancelSubListener as View.OnClickListener)
    }
}