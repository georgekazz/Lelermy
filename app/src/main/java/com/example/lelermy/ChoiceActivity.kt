package com.example.lelermy

import android.annotation.SuppressLint
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class ChoiceActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)

        var choiceCounter = 0

        val stratosKsirasBt = findViewById<ImageButton>(R.id.stratosKsirasBt)
        val nautikoBt = findViewById<ImageButton>(R.id.nautikoBt)
        val aeroporiaBt = findViewById<ImageButton>(R.id.aeroporiaBt)

        stratosKsirasBt.setOnClickListener {

            choiceCounter = 1
            setContentView(R.layout.fragment_confirm)
        }
    }
}