package tmu2018.trunkcarassistant.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.Collections;

import tmu2018.trunkcarassistant.database.Database;
import tmu2018.trunkcarassistant.adapters.EditLuggageArrayAdapter;
import tmu2018.trunkcarassistant.objects.Luggage;
import tmu2018.trunkcarassistant.R;
import tmu2018.trunkcarassistant.database.SQLitehandler;

public class LuggageToEditActivity extends AppCompatActivity {

    private Database dbHandler = new SQLitehandler(this);
    private EditLuggageArrayAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luggage_to_edit);

        Button trunk1 = findViewById(R.id.add_trunk);
        ListView trunkListView = findViewById(R.id.trunkListView);

        // new activity for button Add Trunk. PutExtra tells AddTrunk
        trunk1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent_trunk = new Intent(LuggageToEditActivity.this,AddLuggageActivity.class);

                startActivity(intent_trunk);
            }
        });

        // List of all already added lugagges
        Collections.sort(dbHandler.readAllLuggages(), Luggage.compareByName);
        adapter = new EditLuggageArrayAdapter(this, dbHandler.readAllLuggages() );
        trunkListView.setAdapter(adapter);


            trunkListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent( LuggageToEditActivity.this, EditLuggageActivity.class);
                    System.out.println("lol?");
                    Luggage luggage = (Luggage) adapterView.getItemAtPosition(i);
                    System.out.println(luggage.getName());
                    intent.putExtra("luggage", luggage);
                    System.out.println(luggage.getName());
                    //intent.putExtra("which_activ",ActivityContant.);
                    startActivity(intent);
                }
            });


        }





    // onResume will refresh trunkList each time activity is opened (i.e. when back button is pressed)
    @Override
    protected void onResume() {
        super.onResume();
        ListView trunkListView = findViewById(R.id.trunkListView);
        adapter = new EditLuggageArrayAdapter(this, dbHandler.readAllLuggages() );
        trunkListView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(LuggageToEditActivity.this,MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finishActivity(this.hashCode());
    }
}


