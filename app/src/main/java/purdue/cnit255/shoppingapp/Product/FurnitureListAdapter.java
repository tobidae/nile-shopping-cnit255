package purdue.cnit255.shoppingapp.Product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import purdue.cnit255.shoppingapp.Helpers.Furniture;
import purdue.cnit255.shoppingapp.R;

public class FurnitureListAdapter extends ArrayAdapter<Furniture> {
    private final Context context;
    private final ArrayList<Furniture> furnitureList;

    public FurnitureListAdapter(Context context, ArrayList<Furniture> furnitureList) {
        super(context, R.layout.furniture_list, furnitureList);

        this.context=context;
        this.furnitureList = furnitureList;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context
                .LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.furniture_list, null,true);

        TextView txtNameFurniture = rowView.findViewById(R.id.txtNameFurniture);
        TextView txtManufacturerFurniture = rowView.findViewById(R.id.txtManufacturerFurniture);
        TextView txtFurnitureType = rowView.findViewById(R.id.txtFurnitureType);
        TextView txtConditionFurniture = rowView.findViewById(R.id.txtConditionFurniture);
        TextView txtQuantityFurniture = rowView.findViewById(R.id.txtQuantityFurniture);

        Furniture furniture = furnitureList.get(position);

        txtNameFurniture.setText(furniture.getItemName());
        txtManufacturerFurniture.setText(furniture.getManufacturer());
        txtFurnitureType.setText(furniture.getFurnitureType());
        txtConditionFurniture.setText("•• " + furniture.getCondition());
        txtQuantityFurniture.setText("Quantity: " + String.valueOf(furniture.getQuantityAvailable()));

        return rowView;

    };
}
