package io.github.matthewcmckenna.ktxplayground

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        go_to_shared_prefs_button.setOnClickListener {
            startActivity(Intent(this, SharedPreferencesActivity::class.java))
        }

        go_to_animation_button.setOnClickListener {
            startActivity(Intent(this, AnimationActivity::class.java))
        }
    }
}
