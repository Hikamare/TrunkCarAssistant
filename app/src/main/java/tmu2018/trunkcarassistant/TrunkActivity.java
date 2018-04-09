package tmu2018.trunkcarassistant;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


/**
    TrunkActivity is responsible for listing a list of added trunks with basic info about them and providing a button to add a new trunk.
 */
public class TrunkActivity extends AppCompatActivity {


    private Database dbHandler = new SQLitehandler(this);
    private TrunkArrayAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trunk);

        Button trunk1 = findViewById(R.id.add_trunk);
        ListView trunkListView = findViewById(R.id.trunkListView);

        // new activity for button Add Trunk. PutExtra tells AddTrunk
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

       int flag =0;

        try{

            Intent i = getIntent();
            flag = (int) i.getSerializableExtra("flag");
        }
        catch(NullPointerException e){
            System.out.println("No flag \n");
        }

        System.out.println(flag);

        if(flag == 0) {
            // When a trunk is selected a new activity is opened with a trunk passed to it.
            trunkListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(TrunkActivity.this, LuggageActivity.class);
                    Trunk entry = (Trunk) adapterView.getItemAtPosition(i);
                    intent.putExtra("entry", entry);
                    //intent.putExtra("which_activ", ActivityContants.TrunkActivity);
                    startActivity(intent);
                }
            });
        }
        if(flag == 1)
        {
            trunkListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent( TrunkActivity.this, EditTrunkActivity.class);
                    Trunk entry = (Trunk) adapterView.getItemAtPosition(i);
                    intent.putExtra("entry", entry);
                    intent.putExtra("which_activ",ActivityContants.TrunkActivity);
                    startActivity(intent);
                }
            });
        }
        if(flag == 1) {
            trunkListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, long id) {
                            Trunk entry = (Trunk) parent.getItemAtPosition(position);
                            try {
                                dbHandler.deleteTrunk(entry);
                                Toast lToast = Toast.makeText(TrunkActivity.this,"That probably worked", Toast.LENGTH_SHORT);
                                lToast.show();
                            } catch(IllegalArgumentException e){
                                Toast lToast = Toast.makeText(TrunkActivity.this,e.getMessage(), Toast.LENGTH_SHORT);
                                lToast.show();
                            }

                    onResume();

                    return false;
                }
            });
        }



    }

    // onResume will refresh trunkList each time activity is opened (i.e. when back button is pressed)
    @Override
    protected void onResume() {
        super.onResume();
        ListView trunkListView = findViewById(R.id.trunkListView);
        adapter = new TrunkArrayAdapter(this, dbHandler.readAllTrunks() );
        trunkListView.setAdapter(adapter);
    }
}
