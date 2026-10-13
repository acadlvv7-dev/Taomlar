package com.asadbek.taomlar.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.asadbek.taomlar.databinding.ItemScrollOvqatBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ItemScrollOvqatBinding
    private val viewModel: DetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ItemScrollOvqatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val taomId = intent.getStringExtra(EXTRA_TAOM_ID)
        if (taomId == null) {
            Toast.makeText(this, "Taom yoq ekan", Toast.LENGTH_LONG).show()
            finish()
            return
        }
        viewModel.taomDetail.observe(this) { detail ->
            binding.tvDetailName.text = detail.name
            binding.tvDetailInstructions.text = detail.instructions
            Glide.with(binding.imgDetail)
                .load(detail.imageUrl)
                .into(binding.imgDetail)
        }

        viewModel.error.observe(this) { message ->
            if (message != null) {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            }
        }
        viewModel.loadDetail(taomId)
    }

    companion object {
        const val EXTRA_TAOM_ID = "extra_taom_id"
    }
}