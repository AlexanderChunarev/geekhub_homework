package com.example.first_homework

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edit_btn.setOnClickListener {
            startActivityForResult(Intent(this, EditActivity::class.java).apply {
                putExtra("institution", institution_name.text)
                putExtra("home", home_name.text)
                putExtra("location", location_name.text)
            }, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1) {
            if (resultCode == RESULT_OK && data != null) {
                institution_name.text = data.getStringExtra("institution_refactored")
                home_name.text = data.getStringExtra("home_refactored")
                location_name.text = data.getStringExtra("location_refactored")
            }
        }
    }
}
