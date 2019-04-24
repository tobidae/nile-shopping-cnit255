package purdue.cnit255.shoppingapp.Product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import purdue.cnit255.shoppingapp.Helpers.Electronics;
import purdue.cnit255.shoppingapp.R;

public class ElectronicsListAdapter extends ArrayAdapter<Electronics> {
    private final Context context;
    private final ArrayList<Electronics> electronicsList;

    public ElectronicsListAdapter(Context context, ArrayList<Electronics> electronicsList) {
        super(context, R.layout.electronics_list, electronicsList);

        this.context=context;
        this.electronicsList = electronicsList;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context
                .LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.electronics_list, null,true);

        TextView txtNameElectronics = rowView.findViewById(R.id.txtNameElectronics);
        TextView txtManufacturerElectronics = rowView.findViewById(R.id.txtManufacturerElectronics);
        TextView txtElectronicsType = rowView.findViewById(R.id.txtElectronicsType);
        TextView txtConditionElectronics = rowView.findViewById(R.id.txtConditionElectronics);
        TextView txtQuantityElectronics = rowView.findViewById(R.id.txtQuantityElectronics);

        Electronics electronics = electronicsList.get(position);

        txtNameElectronics.setText(electronics.getItemName());
        txtManufacturerElectronics.setText(electronics.getManufacturer());
        txtElectronicsType.setText(electronics.getElectronicsType());
        txtConditionElectronics.setText("•• " + electronics.getCondition());
        txtQuantityElectronics.setText("Quantity: " + String.valueOf(electronics.getAmountAvailable()));

        return rowView;

    };
}
