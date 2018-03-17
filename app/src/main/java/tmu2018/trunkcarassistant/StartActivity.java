package tmu2018.trunkcarassistant;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by anorb on 07.03.2018.
 */

public class StartActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        //new activity for button Luggage
        Button luggage2 = findViewById(R.id.luggage_start);
        luggage2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent_luggage2 = new Intent(StartActivity.this,LuggageActivity.class);
                startActivity(intent_luggage2);
            }
        });
        //new activity for button Trunk
        Button trunk2 = findViewById(R.id.trunk_start);
        trunk2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent_trunk2 = new Intent(StartActivity.this,TrunkActivity.class);
                startActivity(intent_trunk2);
            }
        });

        Button pack = findViewById(R.id.PACK);
        pack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                //Example
/*
                Luggage[] luggages = new Luggage[3];
                TrunkView trunkView;
                trunkView = findViewById(R.id.trunkView);

                //Make luggages (we will be taking lugagges from "database")
                for(int i =0;i<luggages.length;i++)
                {
                    luggages[i] = new Luggage("Number "+i,5*(i+1),5*(i+1),5*(i+1),true);
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
}
