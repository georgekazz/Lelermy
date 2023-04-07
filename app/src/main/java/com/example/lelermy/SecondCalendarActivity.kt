package com.example.lelermy

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import java.text.SimpleDateFormat
import java.util.*

class SecondCalendarActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {

    private val calendar = Calendar.getInstance()
    private val formatter = SimpleDateFormat ("MMM. dd, yyyy", Locale.US)

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_calendar)

        var terminationBt = findViewById<Button>(R.id.show_calendar_termination_bt)
        var finishBt = findViewById<Button>(R.id.finishBt)

        terminationBt.setOnClickListener {
            finishBt.visibility = View.VISIBLE

            DatePickerDialog (
                this,
                this,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        calendar.set(year,month,dayOfMonth)
        displayFormattedDate(calendar.timeInMillis)
    }

    private fun displayFormattedDate(timestamp: Long) {
        val show_calendar_termination_bt = findViewById<Button>(R.id.show_calendar_termination_bt)
        show_calendar_termination_bt.text = formatter.format(timestamp)

        Log.i("Formating the Second Calendar", formatter.format(timestamp).toString())

    }
}