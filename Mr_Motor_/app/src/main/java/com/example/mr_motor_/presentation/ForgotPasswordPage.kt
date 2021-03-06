package com.example.mr_motor_.presentation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.mr_motor_.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForgotPasswordPage : AppCompatActivity() {

    private lateinit var email : EditText
    private lateinit var resetPassword : Button

    private val vm by viewModel<AuthorizationViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        setContentView(R.layout.forgot_password_page)

        email = findViewById(R.id.et_forgotPasswordPage_email)
        resetPassword = findViewById(R.id.btn_reset_password)

        vm.resultLive.observe(this, Observer {
            val toast : Toast
            if(it){
                toast = Toast.makeText(this@ForgotPasswordPage, "Letter is send on your email", Toast.LENGTH_LONG)
                toast.show()
                finish()
            }else{
                toast = Toast.makeText(this@ForgotPasswordPage, "No account on such email", Toast.LENGTH_LONG)
                toast.show()
            }
        })

        resetPassword.setOnClickListener {
            vm.resetPassword(email.text.toString())
        }
    }

    companion object{
        fun start(caller : Activity){
            val intent = Intent(caller, ForgotPasswordPage::class.java)
            caller.startActivity(intent)
        }
    }

}