package dk.scheduling.schedulingfrontend

import App
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import dk.scheduling.schedulingfrontend.api.ApiClient
import dk.scheduling.schedulingfrontend.ui.theme.SchedulingFrontendTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SchedulingFrontendTheme {
                //ApiButton()
                App()
            }
        }
    }
}
