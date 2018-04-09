package tmu2018.trunkcarassistant;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class EditLuggageArrayAdapter extends ArrayAdapter<Luggage> {

public EditLuggageArrayAdapter(Context context, List<Luggage> aTrunk) {
        super(context, 0, aTrunk);
        }

@Override
public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        Luggage lTrunk = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.edit_luggage_array_adapter_layout, parent, false);
        }
        // Lookup view for data population
        TextView carName = (TextView) convertView.findViewById(R.id.carName);
        TextView carH = (TextView) convertView.findViewById(R.id.carH);
        TextView carW = (TextView) convertView.findViewById(R.id.carW);
        TextView carL = (TextView) convertView.findViewById(R.id.carL);
        // Populate the data into the template view using the data object
        carName.setText(lTrunk.getName());
        String carHString = (lTrunk.getHeight()+"");
        String carWString = (lTrunk.getWidth()+"");
        String carLString = (lTrunk.getLength()+"");
        carH.setText( carHString );
        carW.setText( carWString );
        carL.setText( carLString );
        // Return the completed view to render on screen
        return convertView;
        }
        }
