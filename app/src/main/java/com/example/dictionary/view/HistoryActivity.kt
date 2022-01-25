package com.example.dictionary.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.dictionary.AppState
import com.example.dictionary.HistoryAdapter
import com.example.dictionary.databinding.ActivityHistoryBinding
import com.example.dictionary.viewmodel.HistoryActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryActivity : AppCompatActivity() {
    private val viewModel: HistoryActivityViewModel by viewModel()
    private val binding by lazy { ActivityHistoryBinding.inflate(layoutInflater) }
    private val adapter by lazy { HistoryAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.historyRecyclerView.adapter = adapter
        viewModel.loadHistory().observe(this) { renderData(it) }
    }

    private fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Success -> {
                historyLoadingLayout.visibility = View.GONE
                adapter.setData(appState.data)
            }
            is AppState.Error -> {
                historyLoadingLayout.visibility = View.GONE
            }
            is AppState.Loading -> {
                historyLoadingLayout.visibility = View.VISIBLE
            }
        }
    }
}