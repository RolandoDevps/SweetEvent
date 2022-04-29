package com.example.sweetevent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.sweetevent.ui.theme.SweetEventTheme
import com.example.sweetevent.view.Greeting
import com.example.sweetevent.view.LoadingView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SweetEventTheme (darkTheme = false){
                LoadingView()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SweetEventTheme {
        Greeting("Android")
    }
}