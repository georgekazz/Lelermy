package com.example.lelermy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class SetProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_profile)

        val choiceCounter = intent.getIntExtra("choiceCounter", 0)
        System.out.println(choiceCounter)

        supportFragmentManager.beginTransaction().add(R.id.fragment_container, MyFragment()).commit()

    }
}


class MyFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.activity_set_profile, container, false)
    }

}
