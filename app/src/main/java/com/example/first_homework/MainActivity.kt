package com.example.first_homework

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edit_btn.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            intent.putExtra("institution", institution_name.text)
            intent.putExtra("home", home_name.text)
            intent.putExtra("location", location_name.text)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1) {
            if (resultCode == RESULT_OK && data != null) {
                println(data)
                Toast.makeText(this, data.getStringExtra("institution_refactored"), Toast.LENGTH_LONG).show()
                institution_name.text = data.getStringExtra("institution_refactored")
                home_name.text = data.getStringExtra("home_refactored")
                location_name.text = data.getStringExtra("location_refactored")
            }
        }
    }
}
