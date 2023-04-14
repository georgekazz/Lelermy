package com.example.lelermy

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class SignUpActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextLastname = findViewById<EditText>(R.id.editTextLastname)
        val edittextSeira = findViewById<EditText>(R.id.editTextSeira)
        val editTextEsso = findViewById<EditText>(R.id.editTextEsso)

        val completeRegisterBt = findViewById<Button>(R.id.completeRegisterBt)
        val errortx = findViewById<TextView>(R.id.errortx)

        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPref.edit()


        // We make button non clickable until all texts are not empty
        completeRegisterBt?.isClickable

        //when button pressed we transfer the use to main
        completeRegisterBt.setOnClickListener {

            //an einai keno
            if(isEditTextEmpty(editTextName)) run {

                errortx.text = "Πρέπει να συμπληρώσεις το όνομα σου"

            } else if (isEditTextEmpty(editTextLastname)) {

                errortx.text = "Πρέπει να συμπληρώσεις το επίθετο σου"

            } else if (isEditTextEmpty(edittextSeira)) {

                errortx.text = "Πρέπει να συμπληρώσεις την σειρά σου"

            } else if (isEditTextEmpty(editTextEsso)) {

                errortx.text = "Πρέπει να συμπληρώσεις την ΕΣΣΟ σου"

            } else  {

                editor.putString("username", editTextName.text.toString())
                editor.apply()
                editor.putString("lastname", editTextLastname.text.toString())
                editor.apply()
                editor.putString("seira", edittextSeira.text.toString())
                editor.apply()
                editor.putString("esso", editTextEsso.text.toString())
                editor.apply()

                completeRegisterBt.isClickable = true
                val intent = Intent(this, MainNaviActivity::class.java)
                startActivity(intent)
            }
        }
    }
    fun isEditTextEmpty(editText: EditText): Boolean {
        val text = editText.text.toString().trim()
        return text.isEmpty()
    }
}