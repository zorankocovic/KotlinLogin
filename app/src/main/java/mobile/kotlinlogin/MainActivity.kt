package mobile.kotlinlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import mobile.kotlinlogin.rest.AppPreferences

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_login = findViewById(R.id.button2) as Button
// set on-click listener
        btn_login.setOnClickListener {
            AppPreferences.isLogin = false
            val intent = Intent(this, LoginActivity::class.java)
            // start your next activity
            startActivity(intent)

            finish()

        }
    }
}
