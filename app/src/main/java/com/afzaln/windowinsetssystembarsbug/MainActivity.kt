package com.afzaln.windowinsetssystembarsbug

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.core.graphics.Insets
import androidx.core.view.MarginLayoutParamsCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.core.view.updatePadding

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var bottomInsetView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        editText = findViewById(R.id.editText)
        bottomInsetView = findViewById(R.id.bottom_inset)
        val useViewCompat = findViewById<SwitchCompat>(R.id.use_viewcompat)

        setupPlatformListener()

        useViewCompat.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                setupViewCompatListener()
            } else {
                setupPlatformListener()
            }
        }
    }

    private fun setupPlatformListener() {
        bottomInsetView.setOnApplyWindowInsetsListener { v, insets ->
            val insetsCompat = WindowInsetsCompat.toWindowInsetsCompat(insets)
            updateText(insetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()))
            insets
        }
    }

    private fun setupViewCompatListener() {
        ViewCompat.setOnApplyWindowInsetsListener(bottomInsetView) { v, insets ->
            updateText(insets.getInsets(WindowInsetsCompat.Type.systemBars()))
            insets
        }
    }

    private fun updateText(inset: Insets) {
        editText.updateLayoutParams<ViewGroup.MarginLayoutParams> {
            this.topMargin = inset.top
        }
        val bottomInset = inset.bottom
        bottomInsetView.text = "Bottom inset: $bottomInset"
    }
}
