package com.example.lelermy

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class ChoiceActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)

        var choiceCounter = 0

        val stratosKsirasBt = findViewById<ImageButton>(R.id.stratosKsirasBt)
        val nautikoBt = findViewById<ImageButton>(R.id.nautikoBt)
        val aeroporiaBt = findViewById<ImageButton>(R.id.aeroporiaBt)


        //Alert Dialog
        val builder = AlertDialog.Builder(this)
        builder.setTitle("ΠΡΟΣΟΧΗ!!")
        builder.setMessage("Είστε σίγουρος για την επιλογή σας;")

        builder.setPositiveButton("Ναι") { dialog, which ->
            val intent = Intent(this,SetProfileActivity::class.java)
            intent.putExtra("choiceCounter", choiceCounter)
            startActivity(intent)
        }

        builder.setNegativeButton("Οχι") { dialog, which ->
            dialog.dismiss()
        }

        //Choose strato Ksiras
        stratosKsirasBt.setOnClickListener {

            choiceCounter = 1

            val alertDialog = builder.create()
            alertDialog.show()
        }

        //Choose Nautiko
        nautikoBt.setOnClickListener {

            choiceCounter = 2

            val alertDialog = builder.create()
            alertDialog.show()

        }

        aeroporiaBt.setOnClickListener {
            choiceCounter = 3

            val alertDialog = builder.create()
            alertDialog.show()
        }
    }
}