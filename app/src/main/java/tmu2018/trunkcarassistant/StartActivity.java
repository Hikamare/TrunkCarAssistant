package tmu2018.trunkcarassistant;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
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
    private TrunkView trunkView;
    private int p =0;

    protected void onCreate(Bundle savedInstanceState) {
        if(p == 0) {
            onConfigurationChanged(new Configuration());
        }
        p++;
        System.out.println("p: "+p);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

            try {

                Intent i = getIntent();
                chosenTrunk = (Trunk) i.getSerializableExtra("Trunk");
                System.out.println(chosenTrunk.getName());
                chosenTrunk.info();
            } catch (NullPointerException e) {
                System.out.println("No trunk was given now\n");
            }


        trunkView = findViewById(R.id.trunkView);

        /*try {
            Thread.sleep(1);

            new Handler().post(new Runnable() {
                @Override
                public void run() {

                    trunkView.invalidate();
                }
            });

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/

//        chosenTrunk = new Trunk("Trunk",50,50,50,true);
  //      List<Luggage> luggages = new ArrayList<>();

        /*Luggage l = new Luggage("Number ",10,10,10,true);
        l.setxView(10);
        l.setyView(10);
        l.setzView(20);
        luggages.add(l);

        chosenTrunk.addLuggages(luggages);*/

        try{

            Thread t = new Thread(new TrunkThread(new Handler(), chosenTrunk,trunkView));
            t.start();

        }
        catch(NullPointerException e){
            System.out.println("No trunk was given now\n");
        }



        /*Button pack = findViewById(R.id.packit_start);
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


        });*/


    }

    @Override
    protected void onStart() {
        super.onStart();
        chosenTrunk.setAcvite(true);
        System.out.println("jestem w onStart()");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("jestem w onDestroy()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("jestem w onResume()");
        chosenTrunk.setAcvite(true);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        System.out.println("jestem w onPostResume()");
   //     chosenTrunk.setAcvite(false);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        trunkView.getTrunk().cleanLuggages();

        /*try {
            Thread.sleep(1);

            new Handler().post(new Runnable() {
                @Override
                public void run() {

                    trunkView.invalidate();
                }
            });

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        Intent i = new Intent(StartActivity.this,MainActivity.class);
        startActivity(i);
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

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            chosenTrunk.setAcvite(false);
        }
        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            chosenTrunk.setAcvite(false);
        }

        }
    }



