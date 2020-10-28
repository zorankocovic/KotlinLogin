package mobile.kotlinlogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import mobile.kotlinlogin.model.LoginModel
import mobile.kotlinlogin.rest.ApiLogin
import kotlinx.android.synthetic.main.login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class LoginActivity : AppCompatActivity() {
    var dataList = ArrayList<LoginModel>()
    var uemail:String=""
    var upass:String=""
    var successlogin:String = "0"
    private var typeText: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val btn_login = findViewById(R.id.button2) as Button
// set on-click listener
        btn_login.setOnClickListener {

            uemail=useremail.text.toString()
            upass=  userpass.text.toString()
                val thread = Thread {
                getDat1a()
            }
            thread.start()
            thread.join();

            //getDat1a()
            // Toast.makeText(applicationContext,successlogin, Toast.LENGTH_SHORT).show()
           if(successlogin.equals("1")) {
                val intent = Intent(this, MainActivity::class.java)
                // start your next activity
                startActivity(intent)
                finish()
            }else
            {  Toast.makeText(applicationContext,"Wrong login data", Toast.LENGTH_SHORT).show()}
        }
    }
    private fun getDat1a() {

        val call: Call<List<LoginModel>> = ApiLogin.getClient.userlogin(uemail,upass)

        call.enqueue(object : Callback<List<LoginModel>> {

            override fun onResponse(call: Call<List<LoginModel>>?, response: Response<List<LoginModel>>?) {
               successlogin= response?.body()?.get(0)?.success.toString()
                // Toast.makeText(applicationContext,response?.body()?.get(0)?.success, Toast.LENGTH_SHORT).show()

            }

            override fun onFailure(call: Call<List<LoginModel>>?, t: Throwable?) {
                Toast.makeText(applicationContext,"something wrong", Toast.LENGTH_SHORT).show()

            }

        })
    }
}