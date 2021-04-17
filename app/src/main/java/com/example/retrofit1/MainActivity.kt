package com.example.retrofit1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit1.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val recycler = findViewById<RecyclerView>(R.id.recycler)
        GlobalScope.launch(Dispatchers.IO) {
            val call = UserRetrofitService.retrofit.create(UserApi::class.java).getProducts()
            val response = call.execute().body()
            withContext(Dispatchers.Main){
                val adapter = RecyclerAdapter(this@MainActivity, response!!.data)
                recycler.adapter = adapter
                recycler.layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }
}