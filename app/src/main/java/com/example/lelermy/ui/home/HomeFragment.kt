package com.example.lelermy.ui.home

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.lelermy.R
import com.example.lelermy.databinding.FragmentHomeBinding
import java.time.Duration
import java.time.LocalDate
import java.util.Calendar
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    var previousDay: Int = -1
    private val daysSpendInArmy =+ 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onResume() {
        super.onResume()

        val sharedPref = requireContext().getSharedPreferences("secondCalendar", Context.MODE_PRIVATE)
        val sharedPref1 = requireContext().getSharedPreferences("firstCalendar", Context.MODE_PRIVATE)
        val firstCalendar = sharedPref1.getString("firstCalendar", null)
        val secondCalendar = sharedPref.getString("secondCalendar", null)

        System.out.println("Take the first day:$firstCalendar")
        System.out.println("Take the second day:$secondCalendar")

        val startDate = LocalDate.parse(firstCalendar)
        val endDate = LocalDate.parse(secondCalendar)
        val duration = Duration.between(startDate.atStartOfDay(), endDate.atStartOfDay())
        var days = duration.toDays()

        showLevel()
        showMedal()
        checkServiceTime(days)

        val ipiretisimesTx = view?.findViewById<TextView>(R.id.ipiretisimesTx)
        val daysLeftTx = view?.findViewById<TextView>(R.id.daysLeftTx)

        daysLeftTx?.text = days.toString()

        val calendar = Calendar.getInstance()
        val currentDay = calendar.get(Calendar.DAY_OF_MONTH)

        if (currentDay != previousDay && days >=0) {

            // Έχει αλλάξει η ημέρα
            previousDay = currentDay
            days -= 1
            daysSpendInArmy + 1

            daysLeftTx?.text = days.toString()
            ipiretisimesTx?.text = "$daysSpendInArmy"

        } else {

//            val daysLeftTx = view?.findViewById<TextView>(R.id.daysLeftTx)
//            daysLeftTx?.text = "European citizens"
        }


        ipiretisimesTx?.text = "$daysSpendInArmy"

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun checkServiceTime(days: Long) {

        val showLevelTitle = view?.findViewById<TextView>(R.id.titleLevel) //onoma bathmou
        //showLevelTitle?.text = levelsKsira[0]

        if (days in 265..275) {

            showLevelTitle?.text = "Ψάρι"
            showMedal()

        } else if (days in 255..264) {
            showLevelTitle?.text = "Στρατιώτης"
        } else if (days in 252..264) {
            showLevelTitle?.text = "Υποδεκανέας"
        } else if (days in 240..251) {
            showLevelTitle?.text = "Δεκανέας"
        } else if (days in 229..239) {
            showLevelTitle?.text = "Λοχίας"
        } else if (days in 221..228) {
            showLevelTitle?.text = "Επιλοχίας"
        } else if (days in 210..220) {
            showLevelTitle?.text = "Αρχιλοχίας"
        } else if (days in 200..209) {
            showLevelTitle?.text = "Ανθυπασπιστής"
        }else if (days in 180..199) {
            showLevelTitle?.text = "Δόκιμος"
        }else if (days in 158..179) {
            showLevelTitle?.text = "Ανθυπολοχαγός"
        }else if (days in 130..157) {
            showLevelTitle?.text = "Υπολοχαγός"
        }else if (days in 110..129) {
            showLevelTitle?.text = "Λοχαγός"
        }else if (days in 95..109) {
            showLevelTitle?.text = "Ταγματάρχης"
        }else if (days in 81..94) {
            showLevelTitle?.text = "Αντισυνταγματάρχης"
        }else if (days in 65..80) {
            showLevelTitle?.text = "Συνταγματάρχης"
        }else if (days in 40..64) {
            showLevelTitle?.text = "Ταξίαρχος"
        }else if (days in 25..39) {
            showLevelTitle?.text = "Υποστράτηγος"
        }else if (days in 8..24) {
            showLevelTitle?.text = "Αντιστράτηγος"
        }else if (days in 1..7) {
            showLevelTitle?.text = "Στρατηγός"
        }
    }

    private fun showLevel() {

        //ksira-peziko-nautiko
        val levelimg = view?.findViewById<ImageView>(R.id.levelimg)
        val sharedPref3 = requireContext().getSharedPreferences("choiceCounter", Context.MODE_PRIVATE)
        val choiceCounter = sharedPref3.getInt("choiceCounter", 0)

        when (choiceCounter) {
            1 -> {  levelimg?.setImageResource(R.drawable.ksirastratosimg)
            }
            2 -> { levelimg?.setImageResource(R.drawable.hellenicnavyseal)
            }
            3 -> { levelimg?.setImageResource(R.drawable.hellenicairforce) }
        }
    }

    private fun showMedal() {

        val simboloImg = view?.findViewById<ImageView>(R.id.simboloImg) //emfanizei ton bathmo toy stratioti analoga me tis meres
        val showLevelTitle = view?.findViewById<TextView>(R.id.titleLevel)
        if(showLevelTitle?.text.toString().contains("Ψάρι")) {
            simboloImg?.setImageResource(R.drawable.ypodekaneas)
        }
        else if(showLevelTitle?.text.toString().contains("Στρατιώτης")) {
                simboloImg?.setImageResource(R.drawable.soldierlevelicon)
        }
        else if(showLevelTitle?.text.toString().contains("Υποδεκανέας")) {
            simboloImg?.setImageResource(R.drawable.ypodekaneas)
        }
    else if(showLevelTitle?.text.toString().contains("Δεκανέας")) {
                simboloImg?.setImageResource(R.drawable.dekaneas)
        }
    else if(showLevelTitle?.text.toString().contains("Λοχίας")) {
            simboloImg?.setImageResource(R.drawable.loxias)
        }
    else if(showLevelTitle?.text.toString().contains("Επιλοχίας")) {
            simboloImg?.setImageResource(R.drawable.epiloxias)
        }
    else if(showLevelTitle?.text.toString().contains("Αρχιλοχίας")) {
            simboloImg?.setImageResource(R.drawable.arxiloxias)
        }
    else if(showLevelTitle?.text.toString().contains( "Ανθυπασπιστής")) {
                simboloImg?.setImageResource(R.drawable.antipaspistis)
        }
    else if(showLevelTitle?.text.toString().contains("Δόκιμος")) {
                simboloImg?.setImageResource(R.drawable.dea)
        }
    else if(showLevelTitle?.text.toString().contains("Ανθυπολοχαγός")) {
                simboloImg?.setImageResource(R.drawable.anthipoloxagos)
        }
    else if(showLevelTitle?.text.toString().contains("Υπολοχαγός")){
                simboloImg?.setImageResource(R.drawable.ypoloxagos)
        }
    else if(showLevelTitle?.text.toString().contains("Λοχαγός")) {
                simboloImg?.setImageResource(R.drawable.loxagos)
        }
    else if(showLevelTitle?.text.toString().contains("Ταγματάρχης")) {
            simboloImg?.setImageResource(R.drawable.tagmatarxis)
        }
    else if(showLevelTitle?.text.toString().contains("Αντισυνταγματάρχης")) {
                simboloImg?.setImageResource(R.drawable.antisintagmatarxis)
        }
    else if(showLevelTitle?.text.toString().contains("Συνταγματάρχης")) {
            simboloImg?.setImageResource(R.drawable.sintagmatarxis)
        }
    else if(showLevelTitle?.text.toString().contains("Ταξίαρχος")) {
            simboloImg?.setImageResource(R.drawable.taxiarxos)
        }
    else if(showLevelTitle?.text.toString().contains("Υποστράτηγος")) {
            simboloImg?.setImageResource(R.drawable.ypostratigos)
        }
    else if(showLevelTitle?.text.toString().contains("Αντιστράτηγος")) {
            simboloImg?.setImageResource(R.drawable.antistratigos)
        }
    else if(showLevelTitle?.text.toString().contains("Στρατηγός")) {
            simboloImg?.setImageResource(R.drawable.stratigos)
        }
    else if(showLevelTitle?.text.toString().contains("European citizens")) {
            simboloImg?.setImageResource(R.drawable.europeancitizensicon)
        }
    }
}