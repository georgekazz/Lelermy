package com.example.lelermy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val isRegistered = true
        val startButton = findViewById<Button>(R.id.startButton)
        val videoView = findViewById<VideoView>(R.id.videoView)
        val videoPath = "android.resource://" + packageName + "/" + R.raw.appgif

        if (isRegistered) {
            startActivity(Intent(this, MainNaviActivity::class.java))
        }

        videoView.setVideoPath(videoPath)
        videoView.setOnPreparedListener { mp ->
            mp.isLooping = true
            videoView.start()
        }

        startButton.setOnClickListener {

            startActivity(Intent(this, ChoiceActivity::class.java))

        }
    }
}