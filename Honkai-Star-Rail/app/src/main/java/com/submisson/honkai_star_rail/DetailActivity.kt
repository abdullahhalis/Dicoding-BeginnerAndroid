package com.submisson.honkai_star_rail

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.submisson.honkai_star_rail.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    companion object {
        const val KEY_CHARS = "key_chars"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataChar = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(KEY_CHARS, Chars::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(KEY_CHARS)
        }


        if (dataChar != null) {
            binding. apply {
                Glide.with(this@DetailActivity)
                    .load(dataChar.detailPhoto)
                    .circleCrop()
                    .into(imgDetail)
                detailName.text = dataChar.name
                detailListDescription.text = dataChar.description
                detailStory.text = dataChar.story
                actionShare.setOnClickListener {
                    val share = Intent(Intent.ACTION_SEND)
                    share.putExtra(Intent.EXTRA_TEXT, "Yoo check this Honkai Star Rail Character: ${dataChar.link}")
                    share.type = "text/plain"
                    startActivity(Intent.createChooser(share, "Share To:"))
                }
            }
        }


    }


}