package tmu2018.trunkcarassistant;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import java.util.ArrayList;

/**
 * Created by anorb on 07.03.2018.
 TODO: Delete function buttons (PACK IT, LUGGAGE, TRUNK). Activity should only show packed trunk and list of chosen trunk and luggages.
 */

public class StartActivity extends AppCompatActivity {


    private Database dbHandler;
    private Trunk chosenTrunk;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        chosenTrunk = new Trunk();

        try{

            Intent i = getIntent();
            chosenTrunk = (Trunk) i.getSerializableExtra("entry");
            TextView pickedCar = findViewById(R.id.carIDTextView);
            pickedCar.setText(chosenTrunk.getName());

        }
        catch(NullPointerException e){
            System.out.println("No trunk was given now\n");
        }


        //new activity for button Luggage
        Button luggage2 = findViewById(R.id.luggage_start);
        luggage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_luggage2 = new Intent(StartActivity.this, LuggageActivity.class);
                startActivity(intent_luggage2);
            }
        });
        //new activity for button Trunk
        Button trunk2 = findViewById(R.id.trunk_start);
        trunk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_trunk2 = new Intent(StartActivity.this, TrunkActivity.class);
                startActivity(intent_trunk2);
            }
        });

        Button pack = findViewById(R.id.packit_start);
        pack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<Luggage> luggages = new ArrayList<>();
                TrunkView trunkView;
                trunkView = findViewById(R.id.trunkView);

                try {
                    //Example (list)

                    //Make luggages (we will be taking lugagges from "database")

                    for (int i = 0; i < 3; i++) {
                        Luggage l = new Luggage("Number "+i,5*(i+1),5*(i+1),5*(i+1),true);
                        luggages.add(l);
                    }
                    //Make trunk (we will be taking trunk from "database")
                    //Trunk trunkModel = new Trunk("Trunk",50,50,50,true);
                    //Add luggages to trunk
                    chosenTrunk.addLuggages(luggages);
                    //We make new thread for trunk and luggages
                    Thread t = new Thread(new TrunkThread(new Handler(), chosenTrunk,trunkView));
                    t.start();
                } catch (NullPointerException e) {
                    if (chosenTrunk == null) {
                        Intent intent_trunk2 = new Intent(StartActivity.this, TrunkActivity.class);
                        startActivity(intent_trunk2);
                        System.out.println("No trunk was chosen");
                    }

                }
            }


        });

    }

    public boolean pickTrunk() {

        if (dbHandler.readAllTrunks().isEmpty()) {
            Intent intent_trunk2 = new Intent(StartActivity.this, TrunkActivity.class);
            startActivity(intent_trunk2);
            Toast lToast = Toast.makeText(this, "You don't have any trunk picked yet. \nAdd one!", Toast.LENGTH_SHORT);
            lToast.show();
            return false;
        }

        return true;

    }
}

