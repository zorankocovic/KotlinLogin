package mobile.kotlinlogin.rest

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

////  BASE_URL  is your server folder where you will place all PHP scripts you need  for this app
////PHP files you can find at "PHPBackend" from yhe root of Kotlin login source code
object ApiLogin { var BASE_URL:String="URL TO YOUR SERVER"

    val getClient: LoginInterface
        get() {

            val gson = GsonBuilder()
                .setLenient()
                .create()
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            return retrofit.create(LoginInterface::class.java)

        }
}