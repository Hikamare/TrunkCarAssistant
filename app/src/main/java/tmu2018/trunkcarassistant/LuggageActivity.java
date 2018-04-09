package tmu2018.trunkcarassistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


/**
 LuggageActivity is responsible for listing a list of added luggages with basic info about them and providing a button to add a new luggage.
 */

public class LuggageActivity extends AppCompatActivity {

    private Database dbHandler = new SQLitehandler(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luggage);

        //new activity for button Trunk
        Button luggage1 = findViewById(R.id.add_luggage);

        luggage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_luggage = new Intent(LuggageActivity.this, AddLuggageActivity.class);
                startActivity(intent_luggage);
            }
        });


        // List of all already added luggages
        ListView luggageListView = findViewById(R.id.luggageListView);
        LuggageArrayAdapter adapter = new LuggageArrayAdapter(this, dbHandler.readAllLuggages() );

        luggageListView.setAdapter(adapter);

        //new activity for button luggageOKButton
        Button luggage3 = findViewById(R.id.luggageOKButton);
        luggage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_luggage3 = new Intent(LuggageActivity.this, StartActivity.class);
                startActivity(intent_luggage3);
            }
        });

    }

}
