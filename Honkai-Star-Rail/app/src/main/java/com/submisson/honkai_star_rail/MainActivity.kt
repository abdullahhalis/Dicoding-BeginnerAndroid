package com.submisson.honkai_star_rail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.LinearLayoutManager
import com.submisson.honkai_star_rail.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<Chars>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvCharacters.setHasFixedSize(true)

        list.addAll(getListChars())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val about = Intent(this, AboutActivity::class.java)
        startActivity(about)
        return super.onOptionsItemSelected(item)
    }

    private fun showRecyclerList() {
        val listCharAdapter = ListCharAdapter(list)
        binding. apply {
            rvCharacters.layoutManager =LinearLayoutManager(this@MainActivity)
            rvCharacters.adapter = listCharAdapter
        }
    }

    private fun getListChars() : Collection<Chars> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray((R.array.data_description))
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val detaDetailPhoto = resources.getStringArray(R.array.detail_photo)
        val dataDetailStory = resources.getStringArray((R.array.detail_story))
        val dataLink = resources.getStringArray((R.array.link))
        val listChar = ArrayList<Chars>()
        for (i in dataName.indices) {
            val char = Chars(dataName[i], dataDescription[i], dataPhoto[i], detaDetailPhoto[i], dataDetailStory[i], dataLink[i])
            listChar.add(char)
        }
        return listChar
    }
}