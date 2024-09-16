package com.rakhim.logintask

import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var passwordEditText: EditText
    private lateinit var eyeIcon: ImageView
    private var isPasswordVisible: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Window insets uchun
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // EditText va ImageView elementlarini tanlab olish
        passwordEditText = findViewById(R.id.editTextPassword)
        eyeIcon = findViewById(R.id.eyeIcon)

        // Eye icon bosilganda parolni ko'rsatish/yashirish
        eyeIcon.setOnClickListener {
            if (isPasswordVisible) {
                // Parolni yashirish
                passwordEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                eyeIcon.setImageResource(R.drawable.ic_hide_eye) // Yashirish ikonasi
                isPasswordVisible = false
            } else {
                // Parolni ko'rsatish
                passwordEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                eyeIcon.setImageResource(R.drawable.ic_show_eye) // Ko'rsatish ikonasi
                isPasswordVisible = true
            }
            // Kursorni oxiriga ko'chirish
            passwordEditText.setSelection(passwordEditText.text.length)
        }
    }
}
