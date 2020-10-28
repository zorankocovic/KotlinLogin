package mobile.kotlinlogin.rest
import mobile.kotlinlogin.model.LoginModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
interface LoginInterface {
    @GET("login.php")
    fun userlogin(@Query("email") em: String,@Query("password") pass: String): Call<List<LoginModel>>
}