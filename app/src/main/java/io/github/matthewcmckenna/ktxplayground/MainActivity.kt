package io.github.matthewcmckenna.ktxplayground

import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun sharedPreferencesEditDsl() {
        val value = true
        val stringValue = "Strings"

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        prefs.edit {
            putBoolean("key", value)
            putString("stringKey", stringValue)
        }
    }
}
