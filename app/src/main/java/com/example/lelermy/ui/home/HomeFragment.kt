package com.example.lelermy.ui.home

import android.content.Context
import android.os.Build
import android.os.Bundle
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

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        homeViewModel.text.observe(viewLifecycleOwner) {}
        return root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onResume() {
        super.onResume()
        val choiceCounter = requireActivity().intent.getIntExtra("choiceCounter", 0)
        countDaysLeft()
        showLevel(choiceCounter)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun countDaysLeft() {
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
        datePicker?.setOnDateChangedListener { view, year, monthOfYear, dayOfMonth ->
            days  - 1
            daysLeftTx?.text = days.toString()
            isZero(days)

            daysSpendInArmy + 1
            checkServiceTime(days)
        }

        ipiretisimesTx?.text = "$daysSpendInArmy"
    }

    fun isZero(long: Long) {
        val daysLeftTx = view?.findViewById<TextView>(R.id.daysLeftTx)
        if (long <= 0) {
            daysLeftTx?.text = "0"
        }
    }

    fun checkServiceTime(long: Long) {
        val levelsKsira = arrayListOf("Ψάρι","Στρατιώτης","Υποδεκανέας","Δεκανέας", "Λοχίας","Επιλοχίας","Αρχιλοχίας",
            "Ανθυπασπιστής","Δόκιμος","Ανθυπολοχαγός","Υπολοχαγός","Λοχαγός","Ταγματάρχης","Αντισυνταγματάρχης","Συνταγματάρχης",
            "Ταξίαρχος","Υποστράτηγος","Αντιστράτηγος","Στρατηγός","European citizens")

        if (long >= 260) {
            //image fish
        } else if (long >= 240) {
            //img
        }
    }

    fun showLevel(int: Int) {

        //ksira-peziko-nautiko
        val levelimg = view?.findViewById<ImageView>(R.id.levelimg)
        val sharedPref3 = requireContext().getSharedPreferences("choiceCounter", Context.MODE_PRIVATE)
        val choiceCounter = sharedPref3.getInt("choiceCounter", 0)

        if (choiceCounter == 1) {  levelimg?.setImageResource(R.drawable.ksirastratosimg)
        } else if (choiceCounter == 2) { levelimg?.setImageResource(R.drawable.hellenicnavyseal)
        } else if (choiceCounter == 3){ levelimg?.setImageResource(R.drawable.hellenicairforce) }
    }

    fun showMedal(string: String) {

    }
}