package com.example.lelermy

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ChoiceActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)

        val stratosksirasbt = findViewById<Button>(R.id.stratosKsirasBt)
        val nautikoBt = findViewById<Button>(R.id.nautikoBt)
        val aeroporiaBt = findViewById<Button>(R.id.aeroporiaBt)

        stratosksirasbt.setOnClickListener {

        }

    }
}