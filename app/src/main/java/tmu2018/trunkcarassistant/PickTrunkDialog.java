package tmu2018.trunkcarassistant;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import java.util.List;

/**
 * Created by hikamare on 16.03.18.
 *
 * Shows a dialog which allows to pick a trunk from list of trunks
 */

/*
 TODO: Decide how to pass a list of trunks into that dialog
 */
/*
public class PickTrunkDialog  extends DialogFragment {

    List<Trunk> mTrunkList;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Pick a trunk")
                .setItems(R.array.colors_array, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // The 'which' argument contains the index position
                // of the selected item
            }
        });

        return builder.create();
    }
}
*/