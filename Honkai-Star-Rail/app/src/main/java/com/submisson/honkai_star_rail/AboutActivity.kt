package com.submisson.honkai_star_rail

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.drawable.toDrawable
import com.bumptech.glide.Glide
import com.submisson.honkai_star_rail.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var photo = "https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/small/avatar/dos:77f5f912584d8366f848db42e5f2ba9920230901193047.png"
        Glide.with(this)
            .load(photo)
            .circleCrop()
            .into(binding.photo)
        
    }
}