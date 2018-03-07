package tmu2018.trunkcarassistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

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
                Intent intent_start = new Intent(MainActivity.this,StartActivity.class);
                startActivity(intent_start);
            }
        });
        //new activity for button Luggage
        Button luggage1 = findViewById(R.id.luggage);
        luggage1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent_luggage = new Intent(MainActivity.this,LuggageActivity.class);
                startActivity(intent_luggage);
            }
        });
        //new activity for button Trunk
        Button trunk1 = findViewById(R.id.trunk);
        trunk1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent_trunk = new Intent(MainActivity.this,TrunkActivity.class);
                startActivity(intent_trunk);
            }
        });


        //dopisał Piotrek
        //dopisał Wojtek
        //dopisała Alicja 2
    }
}
