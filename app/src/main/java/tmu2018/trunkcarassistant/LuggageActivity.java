package tmu2018.trunkcarassistant;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 LuggageActivity is responsible for listing a list of added luggages with basic info about them and providing a button to add a new luggage.
 */

public class LuggageActivity extends AppCompatActivity {

    private Database dbHandler = new SQLitehandler(this);
    private List<Luggage> luggagesList = new ArrayList<>();
    private Trunk chooseTrunk;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luggage);


        try {
            Intent i = getIntent();
            chooseTrunk = (Trunk) i.getSerializableExtra("entry");
            System.out.println(chooseTrunk.getName());

        } catch(IllegalArgumentException e){
            System.out.println("No trunk to packed");
        }

        //new activity for button Trunk
        Button luggage1 = findViewById(R.id.add_luggage);
        Button okButton = findViewById(R.id.luggageOKButton);

        luggage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_luggage = new Intent(LuggageActivity.this, AddLuggageActivity.class);
                startActivity(intent_luggage);
            }
        });


        // List of all already added luggages
        final ListView luggageListView = findViewById(R.id.luggageListView);
        final LuggageArrayAdapter adapter = new LuggageArrayAdapter(this, dbHandler.readAllLuggages() );
        luggageListView.setAdapter(adapter);
        luggageListView.setClickable(true);


        okButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                System.out.println("CLICKED");
                for (int i=0; i < adapter.getCount(); ++i){
                    if (adapter.getItem(i).isPicked())
                        luggagesList.add(adapter.getItem(i));
                }

                for (Luggage l  : luggagesList)
                {
                    System.out.println(l.getName());
                }
                chooseTrunk.cleanLuggages();
                System.out.println("LuggageActivity: " + chooseTrunk.getName());
                chooseTrunk.addLuggages(luggagesList);
                chooseTrunk.info();

                Intent intent_trunk = new Intent(LuggageActivity.this,StartActivity.class);
                intent_trunk.putExtra("Trunk", chooseTrunk);

                //intent_trunk.putExtra("which_activ",ActivityContants.TrunkActivity);
                startActivity(intent_trunk);
            }
        });

        luggageListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){

                if (!adapter.getItem(position).isPicked()) {
                    adapter.getItem(position).setPicked(true);
                    Toast t = Toast.makeText(LuggageActivity.this, "Luggage picked", Toast.LENGTH_LONG);
                    t.show();
                }
                else {
                    adapter.getItem(position).setPicked(false);
                    Toast t = Toast.makeText(LuggageActivity.this, "Luggage removed", Toast.LENGTH_LONG);
                    t.show();
                }
            }
        });

    }

    public void onCheckboxClicked(View view){

        boolean isChecked = ((CheckBox) view).isChecked();

        if (isChecked) {



        }
    }



    // onResume will refresh luggageList each time activity is opened (i.e. when back button is pressed)
    @Override
    protected void onResume() {
        super.onResume();
        ListView luggageListView = findViewById(R.id.luggageListView);
        LuggageArrayAdapter adapter = new LuggageArrayAdapter(this, dbHandler.readAllLuggages() );
        luggageListView.setAdapter(adapter);



    }

}
