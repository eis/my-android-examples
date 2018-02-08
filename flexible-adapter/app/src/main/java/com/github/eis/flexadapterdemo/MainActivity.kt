package com.github.eis.flexadapterdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.IFlexible
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.LinearLayoutManager


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Optional but strongly recommended: Compose the initial list
        val myItems = getDatabaseList()

        // Initialize the Adapter
        val adapter = FlexibleAdapter<IFlexible<*>>(myItems)

        // Initialize the RecyclerView and attach the Adapter to it as usual
        recycler_view_example_list.adapter = adapter

        // Layout manager needs to be added to get anything to show up
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler_view_example_list.layoutManager = linearLayoutManager
    }

    private fun getDatabaseList(): List<IFlexible<*>> {
        val list = ArrayList<MyItem>()
        list.add(MyItem("1", "Hello"))
        list.add(MyItem("2", "World"))
        return list
    }
}
