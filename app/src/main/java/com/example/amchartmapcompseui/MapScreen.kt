package com.example.amchartmapcompseui

import android.graphics.Color
import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView

class MapScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WebViewPage(url = "file:///android_asset/world.html")
        }
    }
}

@Composable
fun WebViewPage(url : String){
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            this.settings.javaScriptEnabled = true
            this.setBackgroundColor(Color.BLACK)
            this.addJavascriptInterface(WebAppInterface(context), "Android")
            loadUrl(url)
        }
    }, update = {
        it.loadUrl(url)
    })
}
