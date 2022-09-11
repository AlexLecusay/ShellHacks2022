package com.example.streambill

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView

class DifferentStreamingServices : Activity() {

    private lateinit var mStreamingServiceLogo : ImageView
    private lateinit var mStreamingServiceDescription : TextView
    private lateinit var mStreamingServiceCost : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_streaming_services)
        mStreamingServiceLogo = findViewById(R.id.detailed_image)
        mStreamingServiceDescription = findViewById(R.id.detailed_description)
        mStreamingServiceCost = findViewById(R.id.detailed_pricing)
        mStreamingServiceLogo.setImageResource(intent.extras!!.getInt("ServiceLogo"))
        mStreamingServiceDescription.text = intent.extras!!.getString("ServiceCompany")
        mStreamingServiceCost.text = intent.extras!!.getString("CompanyCost")
    }
}