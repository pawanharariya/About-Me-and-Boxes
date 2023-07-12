package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myInfo = MyInfo(
        name = "Pawan Singh Harariya",
        bio = "I am an experienced Software Developer with a demonstrated history of working in the computer software industry. I have solid foundation in Java, Android SDK, XML and SQL. I am also familiar with AWS CDK, Alexa Skills Kit(ASK), Alexa Presentation Language(APL) and Git. I also have strong understanding of Data Structures and Algorithms and love to solve problems on Leetcode.\n\n" +
                "I have completed my engineering with an Integrated Dual Degree focused in Electronics and Communications Engineering from National Institute of Technology, Hamirpur in 2023. I have done internship at Amazon, and during a period of 6-months I worked on the cloud infrastructure of the Clock Service of Alexa Multimodal Devices and aided in successful launch of Echo Show 5 3rd Gen.\n\n" +
                "Apart from programming, I love playing table tennis and doing cardistry."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myInfo
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {

        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            view.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }
        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}