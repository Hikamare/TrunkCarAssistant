package tmu2018.trunkcarassistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anorb on 07.03.2018.
 */

public class LuggageActivity extends AppCompatActivity {

    private Database dbHandler = new SQLitehandler(this);
    private List<String> exampleList = new ArrayList<>();
    private LuggageArrayAdapter adapter;

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
        adapter = new LuggageArrayAdapter(this, dbHandler.readAllLuggages() );

        luggageListView.setAdapter(adapter);

        /*
        TODO: Doesn't work well. Need to think about it.

        luggageListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent( LuggageActivity.this, StartActivity.class);
                Luggage luggage = (Luggage) adapterView.getItemAtPosition(i);
                intent.putExtra("luggage", luggage);
                startActivity(intent);
            }
        });
    */
    }

}
