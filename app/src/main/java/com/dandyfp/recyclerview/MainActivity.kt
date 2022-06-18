package com.dandyfp.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dandyfp.recyclerview.adapter.adapterTeamBola
import com.dandyfp.recyclerview.databinding.ActivityMainBinding
import com.dandyfp.recyclerview.model.pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listpemain = ArrayList<pemain>()
        listpemain.add(pemain("ronaldo",R.drawable.ronaldo,"Striker","180","portugal","13 Mei 1880"))
        listpemain.add(pemain("modric",R.drawable.modric,"delandang","170","spanyol","13 Mei 1881"))
        listpemain.add(pemain("marcelo",R.drawable.marcelo,"wing beck","179","portugal","13 Mei 1880"))
        listpemain.add(pemain("bale",R.drawable.bale,"wing","180","wales","13 Mei 1880"))

        binding.List.adapter = adapterTeamBola(this,listpemain,object : adapterTeamBola.OnClickListener{
            override fun detailData(item: pemain?) {

            }
        })


    }

}