package com.example.lelermy

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import androidx.fragment.app.Fragment
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
            val intent = Intent(this, SecondCalendarActivity::class.java)
            startActivity(intent)
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

        //Save Second Calendar value in secondCalendar
        val sharedPref1 = getSharedPreferences("firstCalendar", Context.MODE_PRIVATE)
        with (sharedPref1.edit()) {
            putString("firstCalendar", formatter.format(timestamp))
            apply()
        }
    }
}

class MyFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.activity_set_profile, container, false)
    }
}
