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
            val resultIntent = Intent()
            resultIntent.putExtra("institution_refactored", education_edit_text.text.toString())
            resultIntent.putExtra("home_refactored", current_city_edit_text.text.toString())
            resultIntent.putExtra("location_refactored", location_edit_text.text.toString())

            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }

    private fun getData() {
        val intent = intent
        education_edit_text.setText(intent.getStringExtra("institution"))
        current_city_edit_text.setText(intent.getStringExtra("home"))
        location_edit_text.setText(intent.getStringExtra("location"))
    }
}