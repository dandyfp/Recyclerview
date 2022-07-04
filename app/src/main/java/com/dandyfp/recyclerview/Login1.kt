package com.dandyfp.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dandyfp.recyclerview.databinding.ActivityLogin1Binding
import com.dandyfp.recyclerview.login.ModelLogin

private lateinit var binding : ActivityLogin1Binding

class Login1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val dataLogin = ModelLogin(binding.TxtPUsername.text.toString(),binding.TxtPPassword.text.toString())
            val intent = Intent(this,halamanMenu::class.java)
            intent.putExtra("data",dataLogin)
            startActivity(intent)
        }
    }
}