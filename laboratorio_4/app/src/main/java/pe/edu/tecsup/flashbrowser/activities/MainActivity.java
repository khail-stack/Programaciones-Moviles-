package pe.edu.tecsup.flashbrowser.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatToggleButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pe.edu.tecsup.flashbrowser.R;

public class MainActivity extends AppCompatActivity {


    private AppCompatEditText edtMovie;
    private AppCompatEditText edtYear;
    private AppCompatToggleButton tgbOscar;
    private AppCompatRatingBar rtbScore;
    private AppCompatButton btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Se instancian las vistas
        edtMovie = findViewById(R.id.edtMovie);
        edtYear = findViewById(R.id.edtYear);
        tgbOscar = findViewById(R.id.tgbOscar);
        rtbScore = findViewById(R.id.rtbScore);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Se recuperan los valores ingresados
                String movie = edtMovie.getText().toString();
                int year = Integer.parseInt(edtYear.getText().toString());
                boolean oscar = tgbOscar.isActivated();
                float score = rtbScore.getRating();

                // Se crea el objeto intent
                Intent intent = new Intent(MainActivity.this, ReceiverActivity.class);

                // Se agregan los parámetros
                intent.putExtra("movie", movie);
                intent.putExtra("year", year);
                intent.putExtra("oscar", oscar);
                intent.putExtra("score", score);

                // Se dispara el intent explícito
                startActivity(intent);
            }
        });
    }
}


