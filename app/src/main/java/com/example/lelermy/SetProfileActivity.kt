package com.example.lelermy

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import org.w3c.dom.Text
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

class SetProfileActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {

    private val calendar = Calendar.getInstance()
    private val formatter = SimpleDateFormat ("MMM. dd, yyyy", Locale.US)

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_profile)

        val choiceCounter = intent.getIntExtra("choiceCounter", 0)
        val show_calendar_bt = findViewById<Button>(R.id.show_calendar_bt)
        val nextbt = findViewById<Button>(R.id.nextBt)

        System.out.println("User choose: $choiceCounter")
       // supportFragmentManager.beginTransaction().add(R.id.fragment_container, MyFragment()).commit()

        show_calendar_bt.setOnClickListener {
            nextbt.visibility = View.VISIBLE
            DatePickerDialog (
                this,
                this,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        //invisible next button
        nextbt.setOnClickListener {

        }
    }

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        calendar.set(year,month,dayOfMonth)
        displayFormattedDate(calendar.timeInMillis)
    }
    private fun displayFormattedDate(timestamp: Long) {
        val show_calendar_bt = findViewById<Button>(R.id.show_calendar_bt)
        show_calendar_bt.text = formatter.format(timestamp)

        Log.i("Formating", formatter.format(timestamp).toString())

    }
}

class MyFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.activity_set_profile, container, false)
    }
}
