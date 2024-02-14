package com.example.cypherswebapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.cypherswebapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        webView = binding.webview
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                request?.let {
                    // 모든 링크를 WebView 내에서 처리하도록 기본적으로 설정합니다.
                    val url = it.url.toString()

                    if (it.isForMainFrame) {
                        // target="_self"인 링크 또는 기본 링크는 WebView 내에서 로드합니다.
                        view?.loadUrl(url)
                        return true
                    } else {
//                        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//                        startActivity(browserIntent)
                        return false
                    }
                }
                return super.shouldOverrideUrlLoading(view, request)
            }
        }
//        webView.loadUrl("http://192.168.50.150:8080/user/userSearch?isApp=true")
        webView.loadUrl("http://doseh.co.kr/user/userSearch?isApp=true")
        WebView.setWebContentsDebuggingEnabled(true)

        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true;
    }

    // 뒤로가기 버튼 동작을 오버라이드하여 웹뷰의 뒤로가기를 구현합니다.
    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack() // 이전 페이지로 돌아갑니다.
        } else {
            super.onBackPressed() // 기본 뒤로가기 동작을 수행합니다.
        }
    }

}