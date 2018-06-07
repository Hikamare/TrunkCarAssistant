package tmu2018.trunkcarassistant.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import petrov.kristiyan.colorpicker.ColorPicker;
import tmu2018.trunkcarassistant.database.Database;
import tmu2018.trunkcarassistant.objects.Luggage;
import tmu2018.trunkcarassistant.R;
import tmu2018.trunkcarassistant.database.SQLitehandler;


public class EditLuggageActivity extends AppCompatActivity {

    private EditText edit_length;
    private EditText edit_height;
    private EditText edit_width;
    private EditText edit_name;
    private Button save_luggage;
    private Button delete_luggage;
    private Database dbHandler;
    private Luggage editLuggage;
    private Button colorpickerbtn;
    private int color2;
    Pattern DimPattern = Pattern.compile("\\b[1-9]{1}[0-9]{0,1}[0-9]{0,1}\\b");
    Pattern NamePattern = Pattern.compile("[\\x20a-zA-Z0-9ĄąĆćĘęŁłŃńÓóŚśŹźŻż.!-]{1,15}");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_luggage);

        edit_length = findViewById(R.id.editText_length);
        edit_height = findViewById(R.id.editText_height);
        edit_width = findViewById(R.id.editText_width);
        edit_name = findViewById(R.id.editText_name);
        colorpickerbtn = findViewById(R.id.colorpickerbtn);
        dbHandler = new SQLitehandler(this);

        try {
            Intent i = getIntent();
            editLuggage = (Luggage) i.getSerializableExtra("luggage");
            edit_length.setText((int) editLuggage.getLength() + "");
            edit_width.setText((int) editLuggage.getWidth() + "");
            edit_height.setText((int) editLuggage.getHeight() + "");
            edit_name.setText((String) editLuggage.getName());


        } catch (NullPointerException e) {
            System.out.println("No luggage to edit\n");
        }


        final Luggage lLuggage = new Luggage();

        // Handle the save button
        save_luggage = findViewById(R.id.button_save);
        save_luggage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Matcher h = DimPattern.matcher(edit_height.getText().toString());
                Matcher w = DimPattern.matcher(edit_width.getText().toString());
                Matcher l = DimPattern.matcher(edit_length.getText().toString());
                Matcher n = NamePattern.matcher(edit_name.getText().toString());

                if (h.find() && w.find() && l.find() && n.matches()) {
                    lLuggage.setHeight(Integer.parseInt(edit_height.getText().toString()));
                    lLuggage.setWidth(Integer.parseInt(edit_width.getText().toString()));
                    lLuggage.setLength(Integer.parseInt(edit_length.getText().toString()));
                    lLuggage.setName(edit_name.getText().toString());
                    lLuggage.setColor(color2);


                    try {
                        dbHandler.updateLuggage(editLuggage, lLuggage);
                        Toast lToast = Toast.makeText(EditLuggageActivity.this, "That probably worked", Toast.LENGTH_SHORT);
                        lToast.show();
                        onBackPressed();
                    } catch (IllegalArgumentException e) {
                        Toast lToast = Toast.makeText(EditLuggageActivity.this, e.getMessage(), Toast.LENGTH_SHORT);
                        lToast.show();
                    }

                } else {
                    Toast lToast = Toast.makeText(EditLuggageActivity.this, "Enter correct data", Toast.LENGTH_SHORT);
                    lToast.show();
                }


            }
        });

        colorpickerbtn.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View view) {
                                                  opencolorpicker();


                                              }
                                          }
        );


        delete_luggage = findViewById(R.id.delete);
        delete_luggage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                AlertDialog.Builder adb = new AlertDialog.Builder(EditLuggageActivity.this);
                adb.setTitle("Remove");
                adb.setMessage("Do you want remove this luggage? ")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                try {
                                    System.out.println(editLuggage.getName());
                                    dbHandler.deleteLuggage(editLuggage);
                                    Toast lToast = Toast.makeText(EditLuggageActivity.this, "Remove", Toast.LENGTH_SHORT);
                                    lToast.show();
                                } catch (IllegalArgumentException e) {
                                    Toast lToast = Toast.makeText(EditLuggageActivity.this, e.getMessage(), Toast.LENGTH_SHORT);
                                    lToast.show();
                                }
                                onBackPressed();
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


                //
            }
        });

    }


    public void onRadioButtonClicked(View v) {

        //is the current radio button now checked?
        boolean checked = ((RadioButton) v).isChecked();

        //now check which radio button is selected
        //android switch statement
        switch (v.getId()) {

            case R.id.radioButton_S:
                if (checked) {
                    // Set textView of all dimensions to inactive for all radioButtons
                    edit_length.setText("37");
                    edit_width.setText("20");
                    edit_height.setText("56");
                }
                break;

            case R.id.radioButton_M:
                if (checked) {
                    edit_length.setText("46");
                    edit_width.setText("23");
                    edit_height.setText("68");
                }
                break;

            case R.id.radioButton_L:
                if (checked) {
                    edit_length.setText("53");
                    edit_width.setText("27");
                    edit_height.setText("79");
                }
                break;

            case R.id.radioButton_O:
                if (checked) {
                    edit_length.setText("");
                    edit_width.setText("");
                    edit_height.setText("");
                }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(EditLuggageActivity.this, LuggageToEditActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finishActivity(this.hashCode());
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

                    }

                    @Override
                    public void onCancel() {

                    }
                }).show();
    }
}

