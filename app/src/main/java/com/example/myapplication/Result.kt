package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        var username=intent.getStringExtra(setData.name)
        var score=intent.getStringExtra(setData.score)
        var totalQuestion=intent.getStringExtra("total size")

        result_name.text="Congratulations ${username} !!"
        result_score.text="${score}/${totalQuestion}"
        finish_button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}