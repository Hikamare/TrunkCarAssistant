package tmu2018.trunkcarassistant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hikamare on 19.03.18.
 *
 * Adapter for list of luggages. Handles layout of the list.
 */

public class LuggageArrayAdapter extends ArrayAdapter<Luggage> {

    public LuggageArrayAdapter(Context context, List<Luggage> aLuggage) {
        super(context, 0, aLuggage);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        Luggage lLuggage = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.luggage_adapter_layout, parent, false);
        }
        // Lookup view for data population
        TextView luggageName = convertView.findViewById(R.id.luggageName);
        TextView luggageH = convertView.findViewById(R.id.luggageH);
        TextView luggageW = convertView.findViewById(R.id.luggageW);
        TextView luggageL = convertView.findViewById(R.id.luggageL);
        // Populate the data into the template view using the data object
        luggageName.setText(lLuggage.getName());
        String carHString = (lLuggage.getHeight()+"");
        String carWString = (lLuggage.getWidth()+"");
        String carLString = (lLuggage.getLength()+"");
        luggageH.setText( carHString );
        luggageW.setText( carWString );
        luggageL.setText( carLString );
        // Return the completed view to render on screen
        return convertView;
  }
}