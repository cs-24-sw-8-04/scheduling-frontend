package dk.scheduling.schedulingfrontend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.ERROR
import android.widget.Button
import dk.scheduling.schedulingfrontend.API.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val call = ApiClient.apiService.test()

            call.enqueue(object : Callback<String>{
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    if (response.isSuccessful) {
                        //val post = response.body()
                        println("we got a response")
                        // Handle the retrieved post data
                    } else {
                        println("we did not get a successful response")
                        // Handle error
                    }
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    // Handle failure
                    Log.e("error message", "could not get a response")
                }
            })
        }
    }
}