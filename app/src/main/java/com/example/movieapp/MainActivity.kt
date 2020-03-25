package com.example.movieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //variabel untuk menampung nya
    private var dataList =ArrayList<MovieModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        IsiData()

        // inten pada setiap data di rv
        rv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv.adapter = MovieAdapter(dataList){
            val inten = Intent(this,DetailActivity::class.java)
                .putExtra("data", it)
            startActivity(inten)
        }
    }

    fun IsiData (){
        dataList.add(
            MovieModel(
                "1",
                "Avangers",
                "ini film ku",
                "serem",
                R.drawable.ic_bloodshot,
                R.raw.video_a_rainy_day,
                3.0F
            )
        )
        dataList.add(
            MovieModel(
                "1",
                "Avangers",
                "ini film ku",
                "serem",
                R.drawable.ic_star_wars,
                R.raw.video_a_rainy_day,
                3.0F
            )
        )
    }
}
