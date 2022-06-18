package com.dandyfp.recyclerview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
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
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPemain)
                    val posisi = this.findViewById<TextView>(R.id.txtPosisi)
                    val tinggi = this.findViewById<TextView>(R.id.txtTinggi)
                    val tempatLahir = this.findViewById<TextView>(R.id.txtTempatLahir)
                    val tanggalLahir = this.findViewById<TextView>(R.id.txtTanggalLahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatLahir.text = "${item?.temaprlhr}"
                    tanggalLahir.text = "${item?.tgllahir}"
                    btn.setOnClickListener { this.dismiss() }

                }.show()

            }
        })


    }

}