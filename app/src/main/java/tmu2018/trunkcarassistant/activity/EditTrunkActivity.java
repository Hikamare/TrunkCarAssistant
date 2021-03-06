package tmu2018.trunkcarassistant.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tmu2018.trunkcarassistant.database.Database;
import tmu2018.trunkcarassistant.R;
import tmu2018.trunkcarassistant.database.SQLitehandler;
import tmu2018.trunkcarassistant.objects.Trunk;


public class EditTrunkActivity extends AppCompatActivity {

    private Database dbHandler;
    private String trunkName = "";
    private Trunk editTrunk;
    private Spinner spinner;
    private Spinner spinner2;
    private Button delete_Trunk;
    private EditText TrunkLengthText, TrunkWidthText, TrunkHeightText, TrunkNick;
    Context cont;
    Pattern DimPattern = Pattern.compile("\\b[1-9]{1}[0-9]{0,1}[0-9]{0,1}\\b");
    Pattern NamePattern = Pattern.compile("[\\x20a-zA-Z0-9ĄąĆćĘęŁłŃńÓóŚśŹźŻż.!-]{1,15}");


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_trunk);

        TrunkLengthText = findViewById(R.id.trunkLengthText);
        TrunkWidthText = findViewById(R.id.trunkWidthText);
        TrunkHeightText = findViewById(R.id.trunkHeightText);
        TrunkNick = findViewById(R.id.trunkNickText);


        try {
            Intent i = getIntent();
            editTrunk = (Trunk) i.getSerializableExtra("entry");
            TrunkLengthText.setText(Integer.toString((int) editTrunk.getLength()));
            TrunkWidthText.setText(Integer.toString((int) editTrunk.getWidth()));
            TrunkHeightText.setText(Integer.toString((int) editTrunk.getHeight()));
            TrunkNick.setText(editTrunk.getName());

        } catch (NullPointerException e) {
            System.out.println("No trunk to edit\n");
        }


        dbHandler = new SQLitehandler(this);

        Button buttonADD = findViewById(R.id.buttonADD);

        //spinner for the car brand
        spinner = (Spinner) findViewById(R.id.car_spinner);

        //spinner for the car model
        spinner2 = (Spinner) findViewById(R.id.model_spinner);

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
                    String lName = TrunkNick.getText().toString();

                    lTrunk.setName(lName);
                    lTrunk.setLength(lLength);
                    lTrunk.setWidth(lWidth);
                    lTrunk.setHeight(lHeight);


                    // Setting trunkName to empty string to correctly add another one.
                    trunkName = "";

                    // If a trunk is already added an exception will be caught

                    try {
                        dbHandler.updateTrunk(editTrunk, lTrunk);
                        Toast lToast = Toast.makeText(EditTrunkActivity.this, "That probably worked", Toast.LENGTH_SHORT);
                        lToast.show();
                    } catch (IllegalArgumentException e) {
                        Toast lToast = Toast.makeText(EditTrunkActivity.this, e.getMessage(), Toast.LENGTH_SHORT);
                        lToast.show();
                    }
                } else {
                    Toast lToast = Toast.makeText(EditTrunkActivity.this, "Enter correct data", Toast.LENGTH_SHORT);
                    lToast.show();
                }

                Intent intent_trunk = new Intent(EditTrunkActivity.this, TrunkActivity.class);
                int flag = 1;
                intent_trunk.putExtra("flag", flag);
                intent_trunk.putExtra("which_activ", ActivityContants.TrunkActivity);
                startActivity(intent_trunk);
            }
        });

        delete_Trunk = findViewById(R.id.buttonDEL);
        delete_Trunk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder adb = new AlertDialog.Builder(EditTrunkActivity.this);
                adb.setTitle("Remove");
                adb.setMessage("Do you want remove this trunk? ")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                try {
                                    dbHandler.deleteTrunk(editTrunk);
                                    Toast lToast = Toast.makeText(EditTrunkActivity.this, "Removed", Toast.LENGTH_SHORT);
                                    lToast.show();
                                } catch (IllegalArgumentException e) {
                                    Toast lToast = Toast.makeText(EditTrunkActivity.this, e.getMessage(), Toast.LENGTH_SHORT);
                                    lToast.show();
                                }
                                onBackPressed();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog = adb.create();
                alertDialog.show();
            }
        });

    }
}