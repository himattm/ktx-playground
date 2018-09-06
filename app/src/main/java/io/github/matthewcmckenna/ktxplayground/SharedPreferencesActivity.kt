package io.github.matthewcmckenna.ktxplayground


import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferencesActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)
        prefs = PreferenceManager.getDefaultSharedPreferences(this)

        refreshView()

        var index = 0
        set_preferences_button.setOnClickListener {
            if (index % 2 == 0) {
                saveUserActivity(false, "Krusher99")
            } else {
                saveUserActivity(true, "CoolKid1217")
            }
            index++
            refreshView()
        }
    }

    private fun saveUserActivity(isActive: Boolean, userName: String) {
        prefs.edit {
            putBoolean(KEY_USER_ACTIVE, isActive)
            putString(KEY_USER_NAME, userName)
        }
    }

    private fun refreshView() {
        user_active_answer_text_view.text = prefs.getBoolean(KEY_USER_ACTIVE, false).toString()
        user_name_answer_text_view.text = prefs.getString(KEY_USER_NAME, "no user name")
    }

    companion object {
        const val KEY_USER_ACTIVE = "is_user_active"
        const val KEY_USER_NAME = "username"
    }
}
