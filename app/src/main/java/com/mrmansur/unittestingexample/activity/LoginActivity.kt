package com.mrmansur.unittestingexample.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.mrmansur.unittestingexample.R
import com.mrmansur.unittestingexample.utils.Utils

class LoginActivity : AppCompatActivity() {

    lateinit var et_email: EditText
    lateinit var et_password: EditText
    lateinit var b_login: Button
    lateinit var tv_message: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initViews()
    }

    private fun initViews() {
        et_email = findViewById(R.id.et_email)
        et_password = findViewById(R.id.et_password)
        b_login = findViewById(R.id.b_login)
        tv_message = findViewById(R.id.tv_message)

        et_password.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val email = et_email.text.toString().trim()
                b_login.isEnabled = email.isNotEmpty() && s!!.isNotEmpty()
            }
        })

        b_login.setOnClickListener {
            loginUserToApp()
        }
    }

    private fun loginUserToApp() {
        val email = et_email.text.toString()
        val password = et_password.text.toString()
        if (email.equals(Utils.USER_NAME) && password.equals(Utils.VALID_PASSWORD)) {
            tv_message.text = getString(R.string.str_success)
        } else {
            tv_message.text = getString(R.string.str_failure)
        }
    }
}