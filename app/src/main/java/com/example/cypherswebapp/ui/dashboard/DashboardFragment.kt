package com.example.cypherswebapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cypherswebapp.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val webView: WebView = binding.webview
        //webView.loadUrl("http://doseh.co.kr/user/userSearch?isApp=true")
        webView.webChromeClient = WebChromeClient()
        webView.loadUrl("http://192.168.50.150:8080/user/userSearch?isApp=true")
        WebView.setWebContentsDebuggingEnabled(true)

        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true;

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}