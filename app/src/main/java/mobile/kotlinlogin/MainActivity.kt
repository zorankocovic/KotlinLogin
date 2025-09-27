package mobile.kotlinlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.app.R
import com.example.app.databinding.ActivityMainBinding
import com.example.app.databinding.LoginBinding
import mobile.kotlinlogin.rest.AppPreferences

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val btn_login = binding.button2
     //   val btn_login = findViewById(R.id.button2) as Button
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
