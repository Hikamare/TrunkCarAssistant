package tmu2018.trunkcarassistant.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import petrov.kristiyan.colorpicker.ColorPicker;
import tmu2018.trunkcarassistant.database.Database;
import tmu2018.trunkcarassistant.objects.Luggage;
import tmu2018.trunkcarassistant.R;
import tmu2018.trunkcarassistant.database.SQLitehandler;


/**
 * Created by anorb on 09.03.2018.
 * TODO: Handle empty input or incorrect data. Luggage sizes shall be moved to string.xml
*/
public class AddLuggageActivity extends AppCompatActivity{

    private EditText edit_length;
    private EditText edit_height;
    private EditText edit_width;
    private EditText edit_name;
    private Button save_luggage;
    private Database dbHandler;
    private Button colorpickerbtn;
    private int color2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_luggage);

        dbHandler = new SQLitehandler(this);
        final Luggage lLuggage = new Luggage();

        edit_length = findViewById(R.id.editText_length);
        edit_height = findViewById(R.id.editText_height);
        edit_width =  findViewById(R.id.editText_width);
        edit_name = findViewById(R.id.editText_name);
        colorpickerbtn = findViewById(R.id.colorpickerbtn);



        // Handle the save button
        save_luggage = findViewById(R.id.button_save);
        save_luggage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lLuggage.setHeight(Integer.parseInt(edit_height.getText().toString()));
                lLuggage.setWidth(Integer.parseInt(edit_width.getText().toString()));
                lLuggage.setLength(Integer.parseInt(edit_length.getText().toString()));
                lLuggage.setName(edit_name.getText().toString());
                lLuggage.setColor(color2);
                System.out.println("INSIDE ONCLICK");
                System.out.println(String.format("Current color: 0x%08x", lLuggage.getColor()));


                    try {
                        dbHandler.addLuggage(lLuggage);
                        Toast lToast = Toast.makeText(AddLuggageActivity.this,"That probably worked", Toast.LENGTH_SHORT);
                        lToast.show();
                    } catch(IllegalArgumentException e){
                        Toast lToast = Toast.makeText(AddLuggageActivity.this,e.getMessage(), Toast.LENGTH_SHORT);
                        lToast.show();
                    }
                    onBackPressed();



            }
        });

        colorpickerbtn.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View view) {
                                                  opencolorpicker();


                                              }
                                          }
        );


    }


    public void onRadioButtonClicked(View v)
    {

        //is the current radio button now checked?
        boolean  checked = ((RadioButton) v).isChecked();

        //now check which radio button is selected
        //android switch statement
        switch(v.getId()){

            case R.id.radioButton_S:
                if(checked){
                    // Set textView of all dimensions to inactive for all radioButtons
                    edit_length.setText("37");
                    edit_width.setText("20");
                    edit_height.setText("56");
                }
                break;

            case R.id.radioButton_M:
                if(checked){
                    edit_length.setText("46");
                    edit_width.setText("23");
                    edit_height.setText("68");
                }
                break;

            case R.id.radioButton_L:
                if(checked){
                    edit_length.setText("53");
                    edit_width.setText("27");
                    edit_height.setText("79");
                }
                break;

            case R.id.radioButton_O:
                if(checked){
                    edit_length.setText("");
                    edit_width.setText("");
                    edit_height.setText("");
                }
        }
    }

    public void opencolorpicker() {
        final ColorPicker colorpicker = new ColorPicker(this);
        ArrayList<String> colors = new ArrayList<>();
        colors.add("#82B926");
        colors.add("#a276eb");
        colors.add("#6a3ab2");
        colors.add("#666666");
        colors.add("#FFFF00");
        colors.add("#3C8D2F");
        colors.add("#FA9F00");
        colors.add("#FF0000");

        colorpicker.setColors(colors)
                .setColumns(5)
                .setRoundColorButton(true)
                .setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                    @Override
                    public void onChooseColor(int position, int color) {
                        color2 = color;
                        System.out.println(String.format("Current color: 0x%08x", color));

                    }

                    @Override
                    public void onCancel() {

                    }
                }).show();
    }
}
