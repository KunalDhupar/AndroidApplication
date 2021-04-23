package com.cg.androidui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_web_view.*

class WebView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        webContent.settings.javaScriptEnabled=true
        webContent.settings.allowContentAccess=true
        webContent.loadUrl("https://www.google.com")
    }
}