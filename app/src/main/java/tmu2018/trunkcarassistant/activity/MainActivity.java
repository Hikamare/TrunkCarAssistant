package tmu2018.trunkcarassistant.activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import tmu2018.trunkcarassistant.R;

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
                intent_start.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent_start);
                finishActivity(this.hashCode());

            }
        });
        //new activity for button Luggage
        Button luggage1 = findViewById(R.id.luggage);
        luggage1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent_luggage = new Intent(MainActivity.this,LuggageToEditActivity.class);
                intent_luggage.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent_luggage);
                finishActivity(this.hashCode());

            }
        });
        //new activity for button Trunk
        Button trunk1 = findViewById(R.id.trunk);
        trunk1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent_trunk = new Intent(MainActivity.this,TrunkActivity.class);
                int flag =1;
                intent_trunk.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent_trunk.putExtra("flag",flag);
                intent_trunk.putExtra("which_activ", ActivityContants.TrunkActivity);
                startActivity(intent_trunk);
                finishActivity(this.hashCode());

            }
        });
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
        adb.setTitle("Exit");
        adb.setMessage("Do you want to close the aplication? ")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            Toast lToast = Toast.makeText(MainActivity.this,"Pa pa!", Toast.LENGTH_SHORT);
                            lToast.show();
                            finish();
                            System.exit(0);
                            finishActivity(this.hashCode());

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = adb.create();
        alertDialog.show();

    }
}
