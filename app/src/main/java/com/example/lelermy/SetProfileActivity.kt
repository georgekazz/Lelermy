package com.example.lelermy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SetProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_profile)

        val choiceCounter = intent.getIntExtra("choiceCounter", 0)
        System.out.println(choiceCounter)
    }
}