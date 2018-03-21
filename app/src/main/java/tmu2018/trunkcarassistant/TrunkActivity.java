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
 *
    TODO: Refreshing view each time activity opens.
 */

public class TrunkActivity extends AppCompatActivity {



    private Database dbHandler = new SQLitehandler(this);
    private TrunkArrayAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trunk);

        Button trunk1 = findViewById(R.id.add_trunk);
        ListView trunkListView = findViewById(R.id.trunkListView);

        // new activity for button Trunkprivate List<String> exampleList = new ArrayList<>();
        trunk1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent_trunk = new Intent(TrunkActivity.this,AddTrunkActivity.class);
                startActivity(intent_trunk);
            }
        });

        // List of all already added trunks
       adapter = new TrunkArrayAdapter(this, dbHandler.readAllTrunks() );
       trunkListView.setAdapter(adapter);

       trunkListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent intent = new Intent( TrunkActivity.this, StartActivity.class);
               Trunk entry = (Trunk) adapterView.getItemAtPosition(i);
               intent.putExtra("entry", entry);
               startActivity(intent);
           }
       });


    }
}
