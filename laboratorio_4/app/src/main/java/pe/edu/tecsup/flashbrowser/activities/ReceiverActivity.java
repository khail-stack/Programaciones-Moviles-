package pe.edu.tecsup.flashbrowser.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import pe.edu.tecsup.flashbrowser.R;

public class ReceiverActivity extends AppCompatActivity {


    private AppCompatButton btnIntent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        btnIntent = findViewById(R.id.btnIntent);

        btnIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReceiverActivity.this, IntentsActivity.class);
                startActivity(intent);
            }
        });




        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        // Se recuperan los valores del intent
        String movie = extras.getString("movie");
        int year = extras.getInt("year");
        boolean oscar = extras.getBoolean("oscar");
        float score = extras.getFloat("score");

// Se pintan los valores en consola
        Log.d(this.getClass().getCanonicalName(), "Película: " + movie);
                Log.d(this.getClass().getCanonicalName(), "Año: " + year);
                Log.d(this.getClass().getCanonicalName(), "¿Ganó un Oscar?: " + oscar);
                Log.d(this.getClass().getCanonicalName(), "Calificación: " + score);
                }

}
