package com.example.lelermy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class ConfirmFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        val yesBt = view?.findViewById<Button>(R.id.yesBt)
//        System.out.println(yesBt)
//
//        yesBt?.setOnClickListener {
//            //requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
//            System.out.println("rrrrrrr")
//        }

        return inflater.inflate(R.layout.fragment_confirm, container, false)
    }
}