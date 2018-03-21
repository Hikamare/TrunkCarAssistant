package tmu2018.trunkcarassistant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by anorb on 09.03.2018.
 *  /*
 *TODO : something is wrong in this metod, Paweł can look at this? I used this code from https://developer.android.com/guide/topics/ui/controls/radiobutton.html
 *
 */
        /*
         *TODO : if we chose radioButton_S, number fields must be filled: length(37) , hight(56) , width(20)
         */
        /*
         *TODO : if we chose radioButton_M, number fields must be filled: length(46) , hight(68) , width(23)
         */
        /*
         *TODO : if we chose radioButton_L, number fields must be filled: length(53) , hight(79) , width(27)
*/
public class AddLuggageActivity extends AppCompatActivity{

    private EditText edit_length;
    private EditText edit_height;
    private EditText edit_width;
    private EditText edit_name;
    private Button save_luggage;
    private Database dbHandler;

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

        // Handle the save button
        save_luggage = findViewById(R.id.button_save);
        save_luggage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lLuggage.setHeight(Integer.parseInt(edit_height.getText().toString()));
                lLuggage.setWidth(Integer.parseInt(edit_width.getText().toString()));
                lLuggage.setLength(Integer.parseInt(edit_length.getText().toString()));
                lLuggage.setName(edit_name.getText().toString());
                dbHandler.addLuggage(lLuggage);

            }
        });
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
}
