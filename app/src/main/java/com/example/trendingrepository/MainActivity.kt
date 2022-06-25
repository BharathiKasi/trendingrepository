package com.example.trendingrepository

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.example.trendingrepository.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mMainActivityBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       mMainActivityBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setSupportActionBar(mMainActivityBinding.myToolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        val lMenuItem:MenuItem = menu!!.findItem(R.id.action_search) as MenuItem
        val lSearchView = lMenuItem.actionView as androidx.appcompat.widget.SearchView
                lSearchView.queryHint = "type your repositoy name"
        lSearchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
        })
        return true
    }
}