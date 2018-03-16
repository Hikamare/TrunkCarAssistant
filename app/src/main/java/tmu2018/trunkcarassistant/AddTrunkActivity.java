package tmu2018.trunkcarassistant;

import android.view.View;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Toast;


/**
 * Created by anorb on 09.03.2018.
 */

/*
TODO: That switch case has to be changed: we may not assume that we know the amount of cars in db. What it changes? Will be rewrite that thing all the time ;) ?
 */

public class AddTrunkActivity extends AppCompatActivity {

    private SQLitehandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trunk);

        dbHandler = new SQLitehandler(this);
        dbHandler.
        final Trunk lTrunk = new Trunk();

        final EditText TrunkLengthText = findViewById(R.id.trunkLengthText);
        final EditText TrunkWidthText = findViewById(R.id.trunkWidthText);
        Button buttonADD = findViewById(R.id.buttonADD);

        final String trunkName = "";

        //spinner for the car brand
        Spinner spinner = (Spinner)findViewById(R.id.car_spinner);
        final String[] car_brand = {"Ford", "Fiat", "Mazda", "Honda", "etc"};
        /*
         *TODO : connection to the car brands database
         *
         */
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, car_brand);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long choice) {


                switch((int)choice)
                {
                    case 0:
                        trunkName.concat(car_brand[0]);
                        break;
                    case 1:
                        trunkName.concat(car_brand[1]);
                        break;
                    case 2:
                        trunkName.concat(car_brand[2]);
                        break;
                    case 3:
                        trunkName.concat(car_brand[3]);
                        break;
                    case 4:
                        //trunkName.concat(car_brand[4]);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
        //spinner for the car model
        final Spinner spinner2 = (Spinner)findViewById(R.id.model_spinner);
        final String[] car_model = {"Panda", "Punto", "Tipo", "500", "etc"};
        /*
         *TODO : connection to the car models database
         *
         */
        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, car_model);

        spinner2.setAdapter(adapter2);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long choice) {

                switch((int)choice)
                {
                    case 0:
                        trunkName.concat(car_model[0]);

                        break;
                    case 1:
                        trunkName.concat(car_model[1]);
                        break;
                    case 2:
                        trunkName.concat(car_model[2]);
                        break;
                    case 3:
                        trunkName.concat(car_model[3]);
                        break;
                    case 4:
                        //trunkName.concat(car_model[4]);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        buttonADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float lLength = Integer.parseInt(TrunkLengthText.getText().toString());
                float lWidth = Integer.parseInt(TrunkWidthText.getText().toString());
                lTrunk.setName(trunkName);
                lTrunk.setLength(lLength);
                lTrunk.setWidth(lWidth);
                dbHandler.addTrunk(lTrunk);
                Toast lToast = Toast.makeText(AddTrunkActivity.this,"That probably worked", Toast.LENGTH_SHORT);
                lToast.show();
            }
        });



    }
}
