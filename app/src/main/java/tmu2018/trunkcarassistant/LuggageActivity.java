package tmu2018.trunkcarassistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by anorb on 07.03.2018.
 */

public class LuggageActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luggage);

        //new activity for button Trunk
        Button trunk1 = findViewById(R.id.add_luggage);
        trunk1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent_trunk = new Intent(LuggageActivity.this,AddLuggageActivity.class);
                startActivity(intent_trunk);
            }
        });
    }

}
