package com.example.testrv

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testrv.databinding.ActivityMainBinding
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        fetchData()
    }

    @SuppressLint("NotifyDataSetChanged")
        fun fetchData() {
        lifecycleScope.launch {
            val response = retrofit.service.getFeelings()
            if (response.success) {
                val feelings = response.data
                adapter = MyAdapter(feelings)
                adapter.notifyDataSetChanged()
                recyclerView.adapter = adapter
            } else {
                Log.d("My Error","Ошибка при получении данных Feeling.")
            }
        }
    }
}