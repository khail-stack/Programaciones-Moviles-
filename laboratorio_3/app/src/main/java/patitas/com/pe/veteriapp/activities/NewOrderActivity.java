package patitas.com.pe.veteriapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import patitas.com.pe.veteriapp.R;
import patitas.com.pe.veteriapp.VeteriApp;
import patitas.com.pe.veteriapp.models.Order;
import patitas.com.pe.veteriapp.models.Pet;

public class NewOrderActivity extends AppCompatActivity {

    private EditText edtNumber;
    private AutoCompleteTextView actPet;
    private CheckBox chkShower;
    private CheckBox chkNails;
    private CheckBox chkVaccine;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);
        setTitle(getString(R.string.new_order));

        edtNumber = (EditText) findViewById(R.id.edtNumber);
        actPet = (AutoCompleteTextView) findViewById(R.id.actPet);
        chkShower = (CheckBox) findViewById(R.id.chkShower);
        chkNails = (CheckBox) findViewById(R.id.chkNails);
        chkVaccine = (CheckBox) findViewById(R.id.chkVaccine);
        btnSave = (Button) findViewById(R.id.btnSave);

        // Creamos el array de nuestro AutoCompleteTextView
        ArrayList<String> petsArray = new ArrayList<>();

        // Recuperamos la lista de mascotas que se crearon y pasaremos SOLO los nombres al array de nuestro AutoCompleteTextView
        ArrayList<Pet> petList = ((VeteriApp) getApplicationContext()).getPetList();
        for (Pet tmp : petList) {
            petsArray.add(tmp.getName());
        }

        // Creamos el adapter y le pasamos como parámetro el contexto, un molde y la data que vendría a ser el array de mascotas
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, petsArray);
        actPet.setAdapter(adapter);

        // Cantidad de caracteres mínimos para activar el autocompletar
        actPet.setThreshold(1);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<String> services = new ArrayList<String>();

                if (chkShower.isChecked()) {
                    services.add(getString(R.string.shower));
                }
                if (chkNails.isChecked()) {
                    services.add(getString(R.string.nails));
                }
                if (chkVaccine.isChecked()) {
                    services.add(getString(R.string.vaccine));
                }

                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm");
                String dateTime = sdf.format(new Date());

                Order order = new Order();
                order.setNumber(edtNumber.getText().toString());
                order.setPet(actPet.getText().toString());
                order.setServices(services);
                order.setDateTime(dateTime);

                ((VeteriApp) getApplicationContext()).addOrder(order);
                finish();
            }
        });
    }
}
