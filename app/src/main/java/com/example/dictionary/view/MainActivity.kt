package com.example.dictionary.view

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import com.example.dictionary.Adapter
import com.example.dictionary.AppState
import com.example.dictionary.databinding.ActivityMainBinding
import com.example.dictionary.viewmodel.MainActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel by viewModel()
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter by lazy { Adapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.recyclerView.adapter = adapter
        setSearchInputListener()
        viewModel.getLiveData().observe(this, { renderData(it) })
    }

    private fun renderData(appState: AppState) = with(binding)
    {
        when (appState) {
            is AppState.Success -> {
                loadingLayout.visibility = View.GONE
                adapter.setData(appState.data)
            }
            is AppState.Error -> {
                loadingLayout.visibility = View.GONE
            }
            is AppState.Loading -> {
                loadingLayout.visibility = View.VISIBLE
            }
        }
    }

    private fun setSearchInputListener() = with(binding) {
        textInputEditText.setOnEditorActionListener { _, action, _ ->
            when (action) {
                EditorInfo.IME_ACTION_SEARCH -> {
                    viewModel.searchWords(
                        textInputEditText.text.toString()
                    )
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
}