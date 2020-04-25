package patitas.com.pe.veteriapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import patitas.com.pe.veteriapp.R;
import patitas.com.pe.veteriapp.VeteriApp;
import patitas.com.pe.veteriapp.models.Pet;

public class NewPetActivity extends AppCompatActivity {

    private EditText edtName;
    private Spinner spnRaces;
    private TextView txtAge;
    private SeekBar skbAge;
    private RadioGroup rdgSex;
    private RadioButton rdbMale;
    private RadioButton rdbFemale;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_pet);
        setTitle(getString(R.string.new_pet));

        edtName = (EditText) findViewById(R.id.edtName);
        spnRaces = (Spinner) findViewById(R.id.spnRaces);
        txtAge = (TextView) findViewById(R.id.txtAge);
        skbAge = (SeekBar) findViewById(R.id.skbAge);
        rdgSex = (RadioGroup) findViewById(R.id.rdgSex);
        rdbMale = (RadioButton) findViewById(R.id.rdbMale);
        rdbFemale = (RadioButton) findViewById(R.id.rdbFemale);
        btnSave = (Button) findViewById(R.id.btnSave);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.races_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spnRaces.setAdapter(adapter);

        txtAge.setText(
                String.format("%s %s", String.valueOf(0), getString(R.string.anios)));

        skbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                if (progresValue == 1) {
                    txtAge.setText(
                            String.format(
                                    "%s %s", String.valueOf(progresValue), getString(R.string.anio)));
                } else {
                    txtAge.setText(
                            String.format(
                                    "%s %s", String.valueOf(progresValue), getString(R.string.anios)));
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sex = new String();
                if (rdgSex.getCheckedRadioButtonId() == rdbMale.getId()) {
                    sex = getString(R.string.male);
                } else if (rdgSex.getCheckedRadioButtonId() == rdbFemale.getId()) {
                    sex = getString(R.string.female);
                }

                Pet pet = new Pet();
                pet.setName(edtName.getText().toString());
                pet.setRace(spnRaces.getSelectedItem().toString());
                pet.setAge(skbAge.getProgress());
                pet.setSex(sex);

                ((VeteriApp) getApplicationContext()).addPet(pet);
                finish();


            }
        });
    }
}

