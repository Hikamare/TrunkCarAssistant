package tmu2018.trunkcarassistant;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anorb on 07.03.2018.
 */

public class StartActivity extends AppCompatActivity {

<<<<<<< HEAD
=======
<<<<<<< HEAD
    private SQLitehandler dbHandler;
>>>>>>> feb217ad8a3d7c9c76d0174488f1461c6a102606

    private SQLitehandler dbHandler;
/*
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // Initializing connection to db
        dbHandler = new SQLitehandler(this);

        //events handling for Pack It! button
        Button buttonPackIt = findViewById(R.id.packit_start);
        buttonPackIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickTrunk();
            }
        });
    }
*/

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
<<<<<<< HEAD
=======
>>>>>>> f8a6c252b3d43a26f2fe0eb37a3a63b70607f1d9
>>>>>>> feb217ad8a3d7c9c76d0174488f1461c6a102606
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

                //Example (list)
                /*List<Luggage> luggages = new ArrayList<Luggage>();
                TrunkView trunkView;
                trunkView = findViewById(R.id.trunkView);

                //Make luggages (we will be taking lugagges from "database")
                for(int i=0; i< 3;i++)
                {
                    Luggage l = new Luggage("Number "+i,5*(i+1),5*(i+1),5*(i+1),true);
                    luggages.add(l);
                }
                //Make trunk (we will be taking trunk from "database")
                Trunk trunkModel = new Trunk("Trunk",50,50,50,true);
                //Add luggages to trunk
                trunkModel.addLuggages(luggages);
                //We make new thread for trunk and luggages
                Thread t = new Thread(new TrunkThread(new Handler(),trunkModel,trunkView));
                t.start();*/
            }
        });

    }

    public List<Trunk> pickTrunk() {

        if (dbHandler.readAllTrunks().isEmpty()) {
            Intent intent_trunk2 = new Intent(StartActivity.this, TrunkActivity.class);
            startActivity(intent_trunk2);
            Toast lToast = Toast.makeText(this, "You don't have any trunk picked yet. \nAdd one!", Toast.LENGTH_SHORT);
            lToast.show();
            return Collections.emptyList();
        }

        return Collections.emptyList();

    }
}

