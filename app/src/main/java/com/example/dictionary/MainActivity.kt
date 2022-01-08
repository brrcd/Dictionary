package com.example.dictionary

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import com.example.dictionary.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: MainActivityViewModel
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter by lazy { Adapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        AndroidInjection.inject(this)
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