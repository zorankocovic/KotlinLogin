package mobile.kotlinlogin.rest

import android.app.Application

class LoginApp : Application() {
    override fun onCreate() {
        super.onCreate()
        AppPreferences.init(this)
    }
}