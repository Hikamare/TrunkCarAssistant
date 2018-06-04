package tmu2018.trunkcarassistant.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import tmu2018.trunkcarassistant.objects.Luggage;
import tmu2018.trunkcarassistant.R;

/**
 * Created by hikamare on 19.03.18.
 *
 * Adapter for list of luggages. Handles layout of the list.
 */

public class LuggageArrayAdapter extends ArrayAdapter<Luggage> {


    public CheckBox cb;
    public TextView name;

    public LuggageArrayAdapter(Context context, List<Luggage> aLuggage) {

        super(context, 0, aLuggage);
        cb = new CheckBox(context);
        name = new TextView(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // Get the data item for this position
        Luggage lLuggage = getItem(position);
        System.out.println("ITEM AT POSITION "+position+" picked");
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.luggage_adapter_layout, parent, false);
        }
        // Lookup view for data population
        this.cb = convertView.findViewById(R.id.luggageCheckBox);
        TextView luggageName = convertView.findViewById(R.id.luggageName);
        // this.name = convertView.findViewById(R.id.luggageName);
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
        LuggageIconAdapterView luggageIcon = convertView.findViewById(R.id.luggageIconAdapterView2);
        luggageIcon.setCurrentColor(lLuggage.getColor());
        // Return the completed view to render on screen
        return convertView;
  }

  public void changeCheckBox(boolean state) {
      if (cb != null) {
          cb.setSelected(state);
          System.out.println(state);
      }
  }

}