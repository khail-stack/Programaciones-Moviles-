package pe.edu.tecsup.flashbrowser.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import pe.edu.tecsup.flashbrowser.R;

public class IntentsActivity extends AppCompatActivity {

    private AppCompatSpinner spnIntent;
    private AppCompatButton btnTry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents);

        // Se instancian las vistas
        spnIntent = findViewById(R.id.spnIntent);
        btnTry = findViewById(R.id.btnTry);

        // Se setean los valores del spinner
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this, R.array.intents, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnIntent.setAdapter(adapter);

        // Se define la funcionalidad del botón
        btnTry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = spnIntent.getSelectedItemPosition();
                Intent intent = null;
                switch (position) {
                    case 0:
                        Intent webWiew = new Intent(IntentsActivity.this, BuscadorActivity.class);
                        startActivity(webWiew);
                        break;
                    case 1:
                        intent = new Intent(Intent.ACTION_DIAL,
                                Uri.parse("tel:(+1)3173900"));
                        break;
                    case 2:
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("geo:-12.044007,-76.952817?z=17"));
                        break;
                    case 3:
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("geo:-12.079207,-77.067464?q=Naruto"));
                        break;
                    case 4:
                        intent = new Intent("android.media.action.IMAGE_CAPTURE");
                        break;
                    case 5:
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("content://contacts/people/"));
                        break;
                }
                if (intent != null) {
                    startActivity(intent);
                }
            }
        });
    }
}

