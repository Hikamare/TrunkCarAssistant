package tmu2018.trunkcarassistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import java.util.List;

/*
TODO: Define different behaviour for opening new activities (Trunk, Luggages)
TODO: Redesigning
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //new activity for button start
        Button start1 = findViewById(R.id.start);
        start1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent_start = new Intent(MainActivity.this,TrunkActivity.class);
                startActivity(intent_start);
            }
        });
        //new activity for button Luggage
        Button luggage1 = findViewById(R.id.luggage);
        luggage1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent_luggage = new Intent(MainActivity.this,LuggageToEditActivity.class);
                startActivity(intent_luggage);
            }
        });
        //new activity for button Trunk
        Button trunk1 = findViewById(R.id.trunk);
        trunk1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent_trunk = new Intent(MainActivity.this,TrunkActivity.class);
                int flag =1;
                intent_trunk.putExtra("flag",flag);
                intent_trunk.putExtra("which_activ",ActivityContants.TrunkActivity);
                startActivity(intent_trunk);
            }
        });
    }
}
