package com.example.practise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private val dataList = List(20) { index -> "About Remit $index" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView1: TextView = findViewById(R.id.textView1)
        val button1: Button = findViewById<Button>(R.id.button1)

        // You can manipulate the stacked views in the code
        button1.setOnClickListener {
            textView1.text = "Text changed after button click!"
        }
        listView = findViewById(R.id.listView)
        listView.adapter = CustomAdapter(dataList)
    }

    class CustomAdapter(private val items: List<String>) : BaseAdapter() {
        override fun getCount(): Int {
           return items.size;
        }

        override fun getItem(position: Int): Any {
           return  items[position];
        }

        override fun getItemId(position: Int): Long {
            return  position.toLong()
        }
//        override fun getCount(): Int = items.size
//        override fun getItem(position: Int): Any = items[position]
//        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view = convertView ?: LayoutInflater.from(parent?.context)
                .inflate(R.layout.list_item, parent, false)

            val titleText = view.findViewById<TextView>(R.id.titleText)
            val subtitleText = view.findViewById<TextView>(R.id.subtitleText)

            titleText.text = items[position]
            subtitleText.text = "Know more about us"

            return view
        }
    }
}
