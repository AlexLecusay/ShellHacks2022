package com.example.streambill

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mTestingButton : Button = findViewById(R.id.main_button_id)

        mTestingButton.setOnClickListener {
            startActivity(Intent(this, DifferentStreamingServices::class.java))
        }
    }
}