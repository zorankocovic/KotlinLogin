package mobile.kotlinlogin.model

import com.google.gson.annotations.SerializedName
class LoginModel (
@SerializedName("success")
    val success: String,
@SerializedName("eEmployeeCodeNumber")
val eEmployeeCodeNumber: String)