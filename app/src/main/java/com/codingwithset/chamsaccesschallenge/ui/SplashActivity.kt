package com.codingwithset.chamsaccesschallenge.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.codingwithset.chamsaccesschallenge.R


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

    }

    override fun onStart() {
        super.onStart()
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)

            startActivity(intent)
            finish()
            overridePendingTransition(
                R.anim.left_to_right,
                R.anim.right_to_left
            )

        }, 1000)


    }


}
