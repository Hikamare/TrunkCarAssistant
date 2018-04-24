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
import android.widget.ListView;
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


    private Database dbHandler = new SQLitehandler(this);
    private Trunk chosenTrunk;
    private TrunkView trunkView;
    private int p =0;
    private ListView list;
    private LuggageArrayAdapter adapter2;

    protected void onCreate(Bundle savedInstanceState) {
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

        /*chosenTrunk = new Trunk("Trunk",50,50,50,true);
        List<Luggage> luggages = new ArrayList<>();

        Luggage l = new Luggage("Number ",10,10,10,true);
        l.setxView(0);
        l.setyView(0);
        l.setzView(0);
        luggages.add(l);
        Luggage l2 = new Luggage("Number ",10,10,10,true);
        l2.setxView(0);
        l2.setyView(0);
        l2.setzView(0);
        luggages.add(l2);
        Luggage l3 = new Luggage("Number ",10,10,10,true);
        l3.setxView(0);
        l3.setyView(0);
        l3.setzView(100);
        luggages.add(l3);

        chosenTrunk.addLuggages(luggages);
*/
        try{

            Thread t = new Thread(new TrunkThread(new Handler(), chosenTrunk,trunkView));
            t.start();

        }
        catch(NullPointerException e){
            System.out.println("No trunk was given now\n");
        }

        list=findViewById(R.id.luggage_list);
        adapter2 = new LuggageArrayAdapter(this, dbHandler.readAllLuggages() );
        list.setAdapter(adapter2);


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



