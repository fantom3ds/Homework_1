package com.example.homework_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_weekends.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_profile -> {
                startActivity(Intent(this, ProfileActivity::class.java))

            }
            R.id.btn_weekends -> {
                startActivity(Intent(this, WeekendsActivity::class.java))

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_weekends.setOnClickListener(this)
        btn_profile.setOnClickListener(this)
    }
}
