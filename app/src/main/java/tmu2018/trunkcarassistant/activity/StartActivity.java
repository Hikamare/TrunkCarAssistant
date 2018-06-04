package tmu2018.trunkcarassistant.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import tmu2018.trunkcarassistant.database.Database;
import tmu2018.trunkcarassistant.adapters.LuggageArrayAdapterNoCheckbox;
import tmu2018.trunkcarassistant.R;
import tmu2018.trunkcarassistant.database.SQLitehandler;
import tmu2018.trunkcarassistant.objects.Trunk;
import tmu2018.trunkcarassistant.rendering.TrunkThread;
import tmu2018.trunkcarassistant.rendering.TrunkView;

/**
 * Created by anorb on 07.03.2018.
 TODO: Delete function buttons (PACK IT, LUGGAGE, TRUNK). Activity should only show packed trunk and list of chosen trunk and luggages.
 */

public class StartActivity extends AppCompatActivity {


    private Database dbHandler = new SQLitehandler(this);
    private Trunk chosenTrunk;
    private TrunkView trunkView;
    private ListView list;
    private LuggageArrayAdapterNoCheckbox adapter2;
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
        adapter2 = new LuggageArrayAdapterNoCheckbox(this,chosenTrunk.getLuggages() );
        list.setAdapter(adapter2);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        trunkView.getTrunk().cleanLuggages();
        Intent i = new Intent(StartActivity.this,MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finishActivity(this.hashCode());
    }

    }



