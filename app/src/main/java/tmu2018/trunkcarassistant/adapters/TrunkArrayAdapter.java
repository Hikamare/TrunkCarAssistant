package tmu2018.trunkcarassistant.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import tmu2018.trunkcarassistant.R;
import tmu2018.trunkcarassistant.objects.Trunk;

/**
 * Created by hikamare on 18.03.18.
 */

public class TrunkArrayAdapter extends ArrayAdapter<Trunk> {

    public TrunkArrayAdapter(Context context, List<Trunk> aTrunk) {
        super(context, 0, aTrunk);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        Trunk lTrunk = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.trunk_adapter_layout, parent, false);
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

