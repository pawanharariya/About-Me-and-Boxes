package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val doneButton: Button = findViewById(R.id.done_button)
        doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        val nicknameEdit: EditText = findViewById(R.id.nickname_edit)
        val nicknameText: TextView = findViewById(R.id.nickname_text)
        nicknameText.text = nicknameEdit.text
        nicknameEdit.visibility = View.GONE
        view.visibility = View.GONE
        nicknameText.visibility = View.VISIBLE

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}