package dk.scheduling.schedulingfrontend.API
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("test")
    fun test() : Call<String>
}