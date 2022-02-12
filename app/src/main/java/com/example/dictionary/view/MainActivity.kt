package com.example.dictionary.view

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.RotateAnimation
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.dictionary.*
import com.example.dictionary.databinding.ActivityMainBinding
import com.example.dictionary.viewmodel.MainActivityViewModel
import org.koin.core.component.KoinScopeComponent
import org.koin.core.component.getOrCreateScope
import org.koin.core.component.inject
import org.koin.core.scope.Scope

class MainActivity : AppCompatActivity(), KoinScopeComponent {
    override val scope: Scope by getOrCreateScope()
    private val viewModel: MainActivityViewModel by inject()
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter by lazy {
        Adapter(
            delegate = {
                Toast.makeText(this, it.text, Toast.LENGTH_SHORT).show()
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()
        setContentView(binding.root)
        splashScreen.setOnExitAnimationListener {
            val animation = it.iconView.animate().rotation(360f).setDuration(2000)
            animation.withEndAction { it.remove() }
        }
        binding.recyclerView.adapter = adapter
        setSearchInputListener()
    }

    override fun onDestroy() {
        scope.close()
        super.onDestroy()
    }

    private fun renderData(appState: AppState) = with(binding)
    {
        when (appState) {
            is AppState.Success -> {
                loadingLayout.setGone()
                adapter.setData(appState.data)
            }
            is AppState.Error -> {
                loadingLayout.setGone()
            }
            is AppState.Loading -> {
                loadingLayout.setVisible()
            }
        }
    }

    private fun setSearchInputListener() = with(binding) {
        textInputEditText.setOnEditorActionListener { _, action, _ ->
            when (action) {
                EditorInfo.IME_ACTION_SEARCH -> {
                    viewModel.searchWord(
                        textInputEditText.text.toString()
                    ).observe(this@MainActivity) { renderData(it) }
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.history_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_history -> {
                startActivity(Intent(this, HistoryActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}