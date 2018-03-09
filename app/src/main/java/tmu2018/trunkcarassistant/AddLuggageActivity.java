package tmu2018.trunkcarassistant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

/**
 * Created by anorb on 09.03.2018.
 */

public class AddLuggageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_luggage);

        /*
         *TODO : something is wrong in this metod, Paweł can look at this? I used this code from https://developer.android.com/guide/topics/ui/controls/radiobutton.html
         *
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
            }
        }*/

    }
}
