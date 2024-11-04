package com.fadhlur.maps_wisata_mi2c.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.fadhlur.maps_wisata_mi2c.screen.ListWisataActivity
import com.fadhlur.maps_wisata_mi2c.R
import com.fadhlur.maps_wisata_mi2c.model.model_wisata
import com.fadhlur.maps_wisata_mi2c.DetailWisata

class WisataAdapter (
    val getListWisata: ListWisataActivity,
    val itemWisataList: List<model_wisata>
): RecyclerView.Adapter<WisataAdapter.MyViewHolder>(){
    class MyViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        var imgWisata : ImageView = itemView.findViewById(R.id.imgWisata)
        var txtNamaWisata : TextView = itemView.findViewById(R.id.txtNamaWisata)
        var txtLokasiWisata : TextView = itemView.findViewById(R.id.txtLokasiWisata)
        val cardWisata : CardView = itemView.findViewById(R.id.cardWisata)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_wisata, parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemWisataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemWisataList[position]
        holder.txtNamaWisata.text = currentItem.namaWisata
        holder.txtLokasiWisata.text = currentItem.lokasiWisata
        holder.imgWisata.setImageResource(currentItem.imgWisata)

        holder.cardWisata.setOnClickListener(){

            //deklarasi intent
            val intent = Intent(getListWisata, DetailWisata::class.java)
            //put Extra
            intent.putExtra("ImageWisata", itemWisataList[position].imgWisata)
            intent.putExtra("NamaWisata",itemWisataList[position].namaWisata)
            intent.putExtra("LokasiWisata",itemWisataList[position].lokasiWisata)
            intent.putExtra("Keterangan",itemWisataList[position].namaWisata)
            //intent.putExtra("judul",itemList[position].judul)

            //tambahkan latitude longitude
            intent.putExtra("latitude",itemWisataList[position].latitude)
            intent.putExtra("longitude",itemWisataList[position].longitude)



            // start pindah ke detail
            getListWisata.startActivity(intent)

            Toast.makeText(getListWisata,itemWisataList[position].namaWisata, Toast.LENGTH_SHORT).show()

        }

    }
}