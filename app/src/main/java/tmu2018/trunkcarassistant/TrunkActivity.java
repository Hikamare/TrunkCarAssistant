package tmu2018.trunkcarassistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by anorb on 07.03.2018.
 *
 * TODO: Need to overload a adapter to show more details about the trunk.
 */

public class TrunkActivity extends AppCompatActivity {



    private Database dbHandler = new SQLitehandler(this);
    private List<String> exampleList = new ArrayList<>();
    private LuggageArrayAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trunk);

        Button trunk1 = findViewById(R.id.add_trunk);
        ListView trunkListView = findViewById(R.id.trunkListView);

        // new activity for button Trunk
        trunk1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent_trunk = new Intent(TrunkActivity.this,AddTrunkActivity.class);
                startActivity(intent_trunk);
            }
        });

        for (Trunk t : dbHandler.readAllTrunks()){
            exampleList.add(t.getName());
        }
        // List of all already added trunks
       adapter = new LuggageArrayAdapter(this, dbHandler.readAllTrunks() );
       trunkListView.setAdapter(adapter);



    }
}
