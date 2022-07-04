package com.dandyfp.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dandyfp.recyclerview.databinding.ActivityHalamanMenuBinding
import com.dandyfp.recyclerview.login.ModelLogin

private lateinit var binding: ActivityHalamanMenuBinding

class halamanMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHalamanMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getData = intent.getParcelableExtra<ModelLogin>("data")
        binding.txtUserNamE.text = getData?.username.toString()
        binding.txtPasswOrd.text = getData?.password.toString()

        binding.btnMenu.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}