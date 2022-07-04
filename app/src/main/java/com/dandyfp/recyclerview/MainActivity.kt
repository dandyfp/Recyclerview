package com.dandyfp.recyclerview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.dandyfp.recyclerview.adapter.adapterBuah
import com.dandyfp.recyclerview.databinding.ActivityMainBinding
import com.dandyfp.recyclerview.model.buah

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listbuah = ArrayList<buah>()
        listbuah.add(buah("Pisang", R.drawable.pisang4, "Kuning"))
        listbuah.add(buah("Mangga", R.drawable.mangga2, "Hijau"))
        listbuah.add(buah("Apel", R.drawable.apel1, "Merah"))
        listbuah.add(buah("Jeruk", R.drawable.jeruk5, "Oren"))
        listbuah.add(buah("Manggis", R.drawable.manggis9, "Ungu ke biru ke hitaman"))
        listbuah.add(buah("Semangka", R.drawable.semangka7, "Hijau"))
        listbuah.add(buah("Melon", R.drawable.melon6, "Hijau "))
        listbuah.add(buah("Jambu", R.drawable.jambu10, "Hijau muda"))
        listbuah.add(buah("Alpukat", R.drawable.alpukat8, "Hijau tua"))
        listbuah.add(buah("Anggur", R.drawable.anggur3, "Ungu ke hitaman"))

        binding.List.adapter = adapterBuah(this,listbuah,object : adapterBuah.OnClickListener{
            override fun detailData(item: buah?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_buah)

                    val image = this.findViewById<ImageView>(R.id.image_buah)
                    val nama = this.findViewById<TextView>(R.id.txtNamaBuah)
                    val posisi = this.findViewById<TextView>(R.id.txtwarnaKulit)
                   // val tinggi = this.findViewById<TextView>(R.id.txtTinggi)//
                   // val tempatLahir = this.findViewById<TextView>(R.id.txtTempatLahir)//
                    //val tanggalLahir = this.findViewById<TextView>(R.id.txtTanggalLahir)//
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.warnaKulit}"
                    //tinggi.text = "${item?.tinggi}"//
                    //tempatLahir.text = "${item?.temaprlhr}"//
                    //tanggalLahir.text = "${item?.tgllahir}"//
                    btn.setOnClickListener { this.dismiss() }

                }.show()

            }
        })


    }

}