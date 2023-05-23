package com.example.lelermy.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lelermy.LevelAdapter
import com.example.lelermy.LevelModel
import com.example.lelermy.R
import com.example.lelermy.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    private var recyclerView: RecyclerView? = null

    private val levelsKsira = arrayListOf("Ψάρι","Στρατιώτης","Υποδεκανέας","Δεκανέας", "Λοχίας","Επιλοχίας","Αρχιλοχίας",
        "Ανθυπασπιστής","Δόκιμος","Ανθυπολοχαγός","Υπολοχαγός","Λοχαγός","Ταγματάρχης","Αντισυνταγματάρχης","Συνταγματάρχης",
        "Ταξίαρχος","Υποστράτηγος","Αντιστράτηγος","Στρατηγός","European citizens")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView = inflater.inflate(R.layout.fragment_slideshow, container, false)

        recyclerView = rootView.findViewById(R.id.recyclerView)

        val layoutManager = LinearLayoutManager(requireContext())

        recyclerView?.layoutManager = layoutManager

        // ArrayList of class ItemsViewModel
        val data = ArrayList<LevelModel>()

        for (i in 0 until levelsKsira.size) {
            data.add(LevelModel(R.drawable.anthipoloxagos, levelsKsira[i]))
        }

        val adapter = LevelAdapter(data)

        recyclerView?.adapter = adapter
        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)

        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}