package com.example.first_homework

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        getData()
        save_btn.setOnClickListener {
            setResult(Activity.RESULT_OK, Intent().apply {
                putExtra("institution_refactored", education_edit_text.text.toString())
                putExtra("home_refactored", current_city_edit_text.text.toString())
                putExtra("location_refactored", location_edit_text.text.toString())
            })
            finish()
        }
    }

    private fun getData() {
        intent.apply {
            education_edit_text.setText(getStringExtra("institution"))
            current_city_edit_text.setText(getStringExtra("home"))
            location_edit_text.setText(getStringExtra("location"))
        }
    }
}