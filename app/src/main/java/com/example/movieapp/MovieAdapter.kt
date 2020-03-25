package com.example.movieapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter( private var data:List<MovieModel>,
                    private var listener: (MovieModel)-> Unit)
    : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    lateinit var ContextAdapter: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):MovieViewHolder {
        // layout dari datanya
        val layoutInflater = LayoutInflater.from(parent.context)
        ContextAdapter = parent.context
        val inflatedView: View =layoutInflater.inflate(R.layout.item_movie,parent,false)
        return MovieViewHolder(inflatedView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder:MovieViewHolder, position: Int) {
        holder.binItem(data[position],listener,ContextAdapter,position)
    }

    class MovieViewHolder(view: View):RecyclerView.ViewHolder(view){

        // inisialiasai gambar dan teks
        private val tvImage:ImageView = view.findViewById(R.id.i_View)
        private val tvTeks:TextView = view.findViewById(R.id.t_View)

        // menampilkan datanya
        fun binItem(data: MovieModel, listener: (MovieModel) -> Unit, context: Context, position: Int){
            tvTeks.text = data.judul
            Glide.with(context)
                .load(data.poster)
                .into(tvImage)
            itemView.setOnClickListener {
                listener(data)
            }
        }
    }

}