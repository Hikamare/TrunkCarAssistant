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
    private ListView list;
    private LuggageArrayAdapter adapter2;
    private TextView trunkName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        trunkName = findViewById(R.id.carIDTextView);
            try {

                Intent i = getIntent();
                chosenTrunk = (Trunk) i.getSerializableExtra("Trunk");
                trunkName.setText(chosenTrunk.getName().toString());
            } catch (NullPointerException e) {
                System.out.println("No trunk was given now\n");
                trunkName.setText("Lack of trunk");
            }


        trunkView = findViewById(R.id.trunkView);

        try{

            Thread t = new Thread(new TrunkThread(new Handler(), chosenTrunk,trunkView));
            t.start();

        }
        catch(NullPointerException e){
            System.out.println("No trunk was given now\n");
        }

        list=findViewById(R.id.luggage_list);
        //adapter2 = new LuggageArrayAdapter(this, dbHandler.readAllLuggages() );
        adapter2 = new LuggageArrayAdapter(this,chosenTrunk.getLuggages() );
        list.setAdapter(adapter2);


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        trunkView.getTrunk().cleanLuggages();
        Intent i = new Intent(StartActivity.this,MainActivity.class);
        startActivity(i);
        finishActivity(this.hashCode());
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



