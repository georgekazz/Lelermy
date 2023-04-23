package com.example.lelermy.ui.home

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lelermy.R
import com.example.lelermy.databinding.FragmentHomeBinding
import java.time.Duration
import java.time.LocalDate
import java.util.Calendar

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var timeInMillis: Long = 10000

    private val levelsKsira = arrayListOf("Ψάρι","Στρατιώτης","Υποδεκανέας","Δεκανέας", "Λοχίας","Επιλοχίας","Αρχιλοχίας",
        "Ανθυπασπιστής","Δόκιμος","Ανθυπολοχαγός","Υπολοχαγός","Λοχαγός","Ταγματάρχης","Αντισυνταγματάρχης","Συνταγματάρχης",
        "Ταξίαρχος","Υποστράτηγος","Αντιστράτηγος","Στρατηγός","European citizens")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        homeViewModel.text.observe(viewLifecycleOwner) {}
        return root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onResume() {
        super.onResume()
        val choiceCounter = requireActivity().intent.getIntExtra("choiceCounter", 0)


        showLevel(choiceCounter)

        showMedal()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun CountDownTimer() {
        val daysLeftTx = view?.findViewById<TextView>(R.id.daysLeftTx)
        val ipiretisimesTx = view?.findViewById<TextView>(R.id.ipiretisimesTx)

        //get calendar values
        val sharedPref = requireContext().getSharedPreferences("secondCalendar", Context.MODE_PRIVATE)
        val sharedPref1 = requireContext().getSharedPreferences("firstCalendar", Context.MODE_PRIVATE)
        val firstCalendar = sharedPref1.getString("firstCalendar", null)
        val secondCalendar = sharedPref.getString("secondCalendar", null)

        System.out.println("Take the first day:$firstCalendar")
        System.out.println("Take the second day:$secondCalendar")

        val startDate = LocalDate.parse(firstCalendar)
        val endDate = LocalDate.parse(secondCalendar)
        val duration = Duration.between(startDate.atStartOfDay(), endDate.atStartOfDay())
        val days = duration.toDays()
        val daysSpendInArmy = 0

        daysLeftTx?.text = days.toString()
        System.out.println("To ypoloipo twn imeron sto strato einai: $days")



        val datePicker = view?.findViewById<DatePicker>(R.id.datePicker)
        datePicker?.setOnDateChangedListener { _, _, _, _ ->
            days  - 1
            daysLeftTx?.text = days.toString()
            isZero(days) // elegxos an midenistoun oi meres pou emeinan

            daysSpendInArmy + 1
            checkServiceTime(days)
        }



        ipiretisimesTx?.text = "$daysSpendInArmy"
    }

    private fun isZero(long: Long) {
        val daysLeftTx = view?.findViewById<TextView>(R.id.daysLeftTx)
        if (long <= 0) {
            daysLeftTx?.text = "European citizens"
        }
    }

    private fun checkServiceTime(long: Long) {

        val showLevelTitle = view?.findViewById<TextView>(R.id.titleLevel)
        showLevelTitle?.text = levelsKsira[0]

        if (long >= 4) {

        } else if (long >= 240) {
            //img
        }
    }

    private fun showLevel(int: Int) {

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

        val daysLeftTx = view?.findViewById<TextView>(R.id.daysLeftTx)
        var leftdays = daysLeftTx?.text.toString()
        val simboloImg = view?.findViewById<ImageView>(R.id.simboloImg) //emfanizei ton bathmo toy stratioti analoga me tis meres
        var i  = 0

        for(i in 0 until 19) {
            if(levelsKsira[i] == "Ψάρι") {
                simboloImg?.setImageResource(R.drawable.ypodekaneas)
            }
            else if(levelsKsira[i] == "Στρατιώτης") {
                //simboloImg?.setImageResource(R.drawable.ypodekaneas)
            }
            else if(levelsKsira[i] == "Υποδεκανέας") {
                simboloImg?.setImageResource(R.drawable.ypodekaneas)
            }
            else if(levelsKsira[i] == "Δεκανέας") {
                simboloImg?.setImageResource(R.drawable.dekaneas)
            }
            else if(levelsKsira[i] == "Λοχίας") {
                simboloImg?.setImageResource(R.drawable.loxias)
            }
            else if(levelsKsira[i] == "Επιλοχίας") {
                simboloImg?.setImageResource(R.drawable.epiloxias)
            }
            else if(levelsKsira[i] == "Αρχιλοχίας") {
                simboloImg?.setImageResource(R.drawable.arxiloxias)
            }
            else if(levelsKsira[i] == "Ανθυπασπιστής") {
                simboloImg?.setImageResource(R.drawable.antipaspistis)
            }
            else if(levelsKsira[i] == "Δόκιμος") {
                simboloImg?.setImageResource(R.drawable.dea)
            }
            else if(levelsKsira[i] == "Ανθυπολοχαγός") {
                simboloImg?.setImageResource(R.drawable.anthipoloxagos)
            }
            else if(levelsKsira[i] == "Υπολοχαγός") {
                simboloImg?.setImageResource(R.drawable.ypoloxagos)
            }
            else if(levelsKsira[i] == "Λοχαγός") {
                simboloImg?.setImageResource(R.drawable.loxagos)
            }
            else if(levelsKsira[i] == "Ταγματάρχης") {
                simboloImg?.setImageResource(R.drawable.tagmatarxis)
            }
            else if(levelsKsira[i] == "Αντισυνταγματάρχης") {
                simboloImg?.setImageResource(R.drawable.antisintagmatarxis)
            }
            else if(levelsKsira[i] == "Συνταγματάρχης") {
                simboloImg?.setImageResource(R.drawable.sintagmatarxis)
            }
            else if(levelsKsira[i] == "Ταξίαρχος") {
                simboloImg?.setImageResource(R.drawable.taxiarxos)
            }
            else if(levelsKsira[i] == "Υποστράτηγος") {
                simboloImg?.setImageResource(R.drawable.ypostratigos)
            }
            else if(levelsKsira[i] == "Αντιστράτηγος") {
                simboloImg?.setImageResource(R.drawable.antistratigos)
            }
            else if(levelsKsira[i] == "Στρατηγός") {
                simboloImg?.setImageResource(R.drawable.stratigos)
            }
            else if(levelsKsira[i] == "European citizens") {
                simboloImg?.setImageResource(R.drawable.europeancitizensicon)
            }
        }
    }
}