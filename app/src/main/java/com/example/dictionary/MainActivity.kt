package com.example.dictionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.example.dictionary.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity

class MainActivity : MvpAppCompatActivity(), MainView {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val presenter = MainPresenter(RepositoryImpl())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSearchInputListener()
    }

    override fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Success -> {
                loadingLayout.visibility = View.GONE
                Toast.makeText(applicationContext, "ok ${appState.data[0].text}", Toast.LENGTH_SHORT).show()
            }
            is AppState.Error -> {
                loadingLayout.visibility = View.GONE
                Toast.makeText(applicationContext, "not ok but appstate", Toast.LENGTH_SHORT).show()
            }
            is AppState.Loading -> {
                loadingLayout.visibility = View.VISIBLE
            }
        }
    }

    override fun onError(error: Throwable) {
        Toast.makeText(applicationContext, "not ok", Toast.LENGTH_SHORT).show()
    }

    private fun setSearchInputListener() = with(binding) {
        textInputEditText.setOnEditorActionListener { _, action, _ ->
            when (action) {
                EditorInfo.IME_ACTION_SEARCH -> {
                    presenter.searchWords(
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

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}