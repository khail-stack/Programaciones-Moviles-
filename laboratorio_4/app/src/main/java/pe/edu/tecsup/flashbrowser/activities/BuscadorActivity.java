package pe.edu.tecsup.flashbrowser.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import pe.edu.tecsup.flashbrowser.R;

public class BuscadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscador);

        WebView miNavegador = new WebView(BuscadorActivity.this);

        miNavegador.setWebViewClient(new WebViewClient());

        // Habilitando Javascript
        WebSettings webSettings = miNavegador.getSettings();
        webSettings.setJavaScriptEnabled(true);

        setContentView(miNavegador);
        miNavegador.loadUrl("https://www.tecsup.edu.pe");
    }
}
