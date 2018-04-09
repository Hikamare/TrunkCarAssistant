package tmu2018.trunkcarassistant;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;


public class EditTrunkActivity extends AppCompatActivity {

    private Database dbHandler;
    private String trunkName = "";
    private Trunk editTrunk;
    private Spinner spinner;
    private Spinner spinner2;
    private Button delete_Trunk;
    Context cont;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_trunk);

        delete_Trunk = findViewById(R.id.buttonDEL);

        try{
            Intent i = getIntent();
            editTrunk = (Trunk) i.getSerializableExtra("entry");
        }
        catch(NullPointerException e){
            System.out.println("No trunk to edit\n");
        }

        dbHandler = new SQLitehandler(this);

        final EditText TrunkLengthText = findViewById(R.id.trunkLengthText);
        final EditText TrunkWidthText = findViewById(R.id.trunkWidthText);
        final EditText TrunkHeightText = findViewById(R.id.trunkHeightText);
        final EditText TrunkNick = findViewById(R.id.trunkNickText);
        Button buttonADD = findViewById(R.id.buttonADD);

        //spinner for the car brand
        spinner = (Spinner)findViewById(R.id.car_spinner);

        //spinner for the car model
        spinner2 = (Spinner)findViewById(R.id.model_spinner);

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
        buttonADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                Trunk lTrunk = new Trunk();
                float lLength = Integer.parseInt(TrunkLengthText.getText().toString());
                float lWidth = Integer.parseInt(TrunkWidthText.getText().toString());
                float lHeight = Integer.parseInt(TrunkHeightText.getText().toString());

                lTrunk.setName(trunkName);
                lTrunk.setLength(lLength);
                lTrunk.setWidth(lWidth);
                lTrunk.setHeight(lHeight);


                // Setting trunkName to empty string to correctly add another one.
                trunkName = "";

                // If a trunk is already added an exception will be caught

                try {
                    dbHandler.updateTrunk(editTrunk,lTrunk);
                    Toast lToast = Toast.makeText(EditTrunkActivity.this,"That probably worked", Toast.LENGTH_SHORT);
                    lToast.show();
                } catch(IllegalArgumentException e){
                    Toast lToast = Toast.makeText(EditTrunkActivity.this,e.getMessage(), Toast.LENGTH_SHORT);
                    lToast.show();
                }
                Intent intent_trunk = new Intent(EditTrunkActivity.this,TrunkActivity.class);
                int flag =1;
                intent_trunk.putExtra("flag",flag);
                intent_trunk.putExtra("which_activ",ActivityContants.TrunkActivity);
                startActivity(intent_trunk);
            }
        });

}}