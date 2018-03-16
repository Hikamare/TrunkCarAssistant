package tmu2018.trunkcarassistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

/**
 * Created by anorb on 07.03.2018.
 */

public class StartActivity extends AppCompatActivity {

    private SQLitehandler dbHandler;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // Initializing connection to db
        dbHandler = new SQLitehandler(this);

        //events handling for Pack It! button
        Button buttonPackIt = findViewById(R.id.packit_start);
        buttonPackIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             pickTrunk();
            }
        });

        //new activity for button Luggage
        Button luggage2 = findViewById(R.id.luggage_start);
        luggage2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent_luggage2 = new Intent(StartActivity.this,LuggageActivity.class);
                startActivity(intent_luggage2);
            }
        });
        //new activity for button Trunk
        Button trunk2 = findViewById(R.id.trunk_start);
        trunk2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent_trunk2 = new Intent(StartActivity.this,TrunkActivity.class);
                startActivity(intent_trunk2);
            }
        });



    }

    public List<Trunk> pickTrunk(){

        if (dbHandler.readAllTrunks().isEmpty()) {
            Intent intent_trunk2 = new Intent(StartActivity.this,TrunkActivity.class);
            startActivity(intent_trunk2);
            Toast lToast = Toast.makeText(this,"You don't have any trunk picked yet. \nAdd one!",Toast.LENGTH_SHORT);
            lToast.show();
            return Collections.emptyList();
        }

        return Collections.emptyList();

    }
}
