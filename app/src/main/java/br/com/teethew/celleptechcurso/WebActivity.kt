package br.com.teethew.celleptechcurso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        // Referenciando o id do componente
        val wbvWeb : WebView = findViewById(R.id.wbvWeb)

        // Habilitando execução de Javascript
        wbvWeb.settings.javaScriptEnabled = true

        // Carregando uma página web
        wbvWeb.loadUrl("http://br.cellep.com/estacaohack")

        // Definindo o webview como client web padrão
        wbvWeb.webViewClient = WebViewClient()
    }
}