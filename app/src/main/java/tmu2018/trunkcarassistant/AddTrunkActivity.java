package tmu2018.trunkcarassistant;

import android.view.View;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;





/**
 * Created by anorb on 09.03.2018.
 */

public class AddTrunkActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trunk);

        //spinner for the car brand
        final Spinner spinner = (Spinner)findViewById(R.id.car_spinner);
        String[] car_brand = {"Ford", "Fiat", "Mazda", "Honda", "etc"};
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
                        //Ford. connection to the next spinner (car model)
                        break;
                    case 1:
                        //Fiat
                        break;
                    case 2:
                        //Mazda
                        break;
                    case 3:
                        //Honda
                        break;
                    case 4:
                        //etc
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
        //spinner for the car model
        final Spinner spinner2 = (Spinner)findViewById(R.id.model_spinner);
        String[] car_model = {"Panda", "Punto", "Tipo", "500", "etc"};
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
                        //Panda.
                        break;
                    case 1:
                        //Punto
                        break;
                    case 2:
                        //Tipo
                        break;
                    case 3:
                        //500
                        break;
                    case 4:
                        //etc
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    }
}
