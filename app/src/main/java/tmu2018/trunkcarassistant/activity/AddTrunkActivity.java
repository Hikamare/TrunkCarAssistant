package tmu2018.trunkcarassistant.activity;

import android.content.Context;
import android.view.View;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Toast;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tmu2018.trunkcarassistant.database.Database;
import tmu2018.trunkcarassistant.R;
import tmu2018.trunkcarassistant.database.SQLitehandler;
import tmu2018.trunkcarassistant.objects.Trunk;


/**
 * Created by anorb on 09.03.2018.
 */

/*
TODO: That switch case has to be changed: we may not assume that we know the amount of cars in db. What it changes? Will be rewrite that thing all the time ;) ?
TODO: What is more: if you do not change both model and brand you won't be able to correctly add your car to db.
TODO: Handle invalid or empty input event. Prevent SQLInjection (REGEX)
 */

public class AddTrunkActivity extends AppCompatActivity {

    Spinner spinner;
    Spinner spinner2;
    private Database dbHandler;
    Context cont;
    Pattern DimPattern = Pattern.compile("\\b[1-9]{1}[0-9]{0,1}[0-9]{0,1}\\b");
    Pattern NamePattern = Pattern.compile("[\\x20a-zA-Z0-9ĄąĆćĘęŁłŃńÓóŚśŹźŻż.!-]{1,15}");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trunk);

        dbHandler = new SQLitehandler(this);

        final EditText TrunkLengthText = findViewById(R.id.trunkLengthText);
        final EditText TrunkWidthText = findViewById(R.id.trunkWidthText);
        final EditText TrunkHeightText = findViewById(R.id.trunkHeightText);
        final EditText TrunkNick = findViewById(R.id.trunkNickText);
        Button buttonADD = findViewById(R.id.buttonADD);


        //spinner for the car brand
        spinner = findViewById(R.id.car_spinner);

        //spinner for the car model
        spinner2 = findViewById(R.id.model_spinner);

        cont = this;

        ArrayAdapter adapter = null;
        try {
            adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, dbHandler.readAllCarBrands());
        } catch (IOException e) {
            e.printStackTrace();
        }

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                ArrayAdapter adapter2 = null;
                try {
                    adapter2 = new ArrayAdapter(cont, android.R.layout.simple_spinner_item, dbHandler.readAllModels(spinner.getSelectedItem().toString()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                spinner2.setAdapter(adapter2);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                TrunkNick.setText(spinner.getSelectedItem().toString() + " " + spinner2.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        buttonADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Matcher h = DimPattern.matcher(TrunkHeightText.getText().toString());
                Matcher w = DimPattern.matcher(TrunkWidthText.getText().toString());
                Matcher l = DimPattern.matcher(TrunkLengthText.getText().toString());
                Matcher n = NamePattern.matcher(TrunkNick.getText().toString());

                if (h.find() && w.find() && l.find() && n.matches()) {
                    Trunk lTrunk = new Trunk();
                    float lLength = Integer.parseInt(TrunkLengthText.getText().toString());
                    float lWidth = Integer.parseInt(TrunkWidthText.getText().toString());
                    float lHeight = Integer.parseInt(TrunkHeightText.getText().toString());
                    lTrunk.setName(spinner.getSelectedItem().toString() + " " + spinner2.getSelectedItem().toString() + " " + TrunkNick.getText());
                    lTrunk.setLength(lLength);
                    lTrunk.setWidth(lWidth);
                    lTrunk.setHeight(lHeight);


                    // If a trunk is already added an exception will be caught
                    try {
                        dbHandler.addTrunk(lTrunk);
                        Toast lToast = Toast.makeText(AddTrunkActivity.this, "That probably worked", Toast.LENGTH_SHORT);
                        lToast.show();
                        onBackPressed();
                    } catch (IllegalArgumentException e) {
                        Toast lToast = Toast.makeText(AddTrunkActivity.this, e.getMessage(), Toast.LENGTH_SHORT);
                        lToast.show();
                    }

                } else {
                    Toast lToast = Toast.makeText(AddTrunkActivity.this, "Enter correct data", Toast.LENGTH_SHORT);
                    lToast.show();
                }

            }
        });


    }
}