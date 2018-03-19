package tmu2018.trunkcarassistant;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.app.Activity;

import android.os.Bundle;

import android.view.View;

import android.view.View.OnClickListener;

import android.widget.Button;

import android.widget.EditText;

import android.widget.TextView;

/**
 * Created by anorb on 09.03.2018.
 */
public class AddLuggageActivity extends AppCompatActivity implements OnClickListener{

    private EditText edit_length;
    private EditText edit_height;
    private EditText edit_width;


    private Button save_luggage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_luggage);

        edit_length = (EditText)findViewById(R.id.editText_length);
        edit_height = (EditText)findViewById(R.id.editText_height);
        edit_width = (EditText)findViewById(R.id.editText_width);

        save_luggage = (Button)findViewById(R.id.button_save);
        save_luggage.setOnClickListener(this);



        /*
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

        /*
        public void onRadioButtonClicked(View view) {

            boolean checked = ((RadioButton) view).isChecked();

            switch(view.getId()) {
                case R.id.radioButton_S:
                    if (checked)
                        // size S
                        break;
                case R.id.radioButton_M:
                    if (checked)
                        // size M
                        break;
                case R.id.radioButton_L:
                    if (checked)
                        // size L
                        break;
                case R.id.radioButton_O:
                    if (checked)
                        // size Other
                        break;
            }
        }

    }*/
    }

    @Override
    public void onClick(View view) {
        /*
         *TODO : if we have pressed the save button, we must get the data from: editText_length, editText_height, editText_width
         */
    }
}
