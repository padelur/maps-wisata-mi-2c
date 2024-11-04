package com.fadhlur.maps_wisata_mi2c.screen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fadhlur.maps_wisata_mi2c.R
import com.fadhlur.maps_wisata_mi2c.adapter.WisataAdapter
import com.fadhlur.maps_wisata_mi2c.model.model_wisata

class ListWisataActivity : AppCompatActivity() {
    private var rv_wisata: RecyclerView? = null
    private var WisataAdapter: WisataAdapter? = null
    //array data doctor
    private var wisataList = mutableListOf<model_wisata>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_wisata)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        rv_wisata = findViewById(R.id.rv_wisata)
        wisataList = ArrayList()
        WisataAdapter= WisataAdapter(this,wisataList);
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this,1)
        rv_wisata!!.layoutManager = layoutManager
        rv_wisata!!.adapter = WisataAdapter

        //create dummy data
        prepareDataWisata()
    }

    private fun prepareDataWisata() {
        var itemWisata = model_wisata(
        R.drawable.gambar1,"tapian rajo",
            "ini deskripsi",
            "Bukit Tinggi",
            -0.304307,100.3398985
        )
        wisataList.add(itemWisata)
        itemWisata = model_wisata(
            R.drawable.gambar2,
            "Istana Pagaruyung",
            "deksripsi",
            "Tanah Datar",
            -0.471291,100.6167915
        )
        wisataList.add(itemWisata)
        itemWisata = model_wisata(
            R.drawable.gambar3,
            "Kampung Eropa",
            "deksripsi",
            "Harau",
            -0.1137836,100.667257
        )
        wisataList.add(itemWisata)
        itemWisata = model_wisata(
            R.drawable.gambar4,
            "Mesjid Raya Sumatera Barat",
            "deksripsi",
            "Pdang",
            -0.9242903,100.3598587
        )
        wisataList.add(itemWisata)
        itemWisata = model_wisata(
            R.drawable.gambar5,
            "Danau Maninjau",
            "deksripsi",
            "Kabupaten Agam",
            -0.328146,100.1054551
        )
        wisataList.add(itemWisata)
        WisataAdapter!!.notifyDataSetChanged()





    }
}
