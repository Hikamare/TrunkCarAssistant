package tmu2018.trunkcarassistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by anorb on 07.03.2018.
 */

public class TrunkActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trunk);

        //new activity for button Trunk
        Button trunk1 = findViewById(R.id.add_trunk);
        trunk1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent_trunk = new Intent(TrunkActivity.this,AddTrunkActivity.class);
                startActivity(intent_trunk);
            }
        });

    }
}
