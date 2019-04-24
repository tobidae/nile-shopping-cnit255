package purdue.cnit255.shoppingapp.Product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import purdue.cnit255.shoppingapp.DataStorage;
import purdue.cnit255.shoppingapp.Helpers.Address;
import purdue.cnit255.shoppingapp.Helpers.Customer;
import purdue.cnit255.shoppingapp.Helpers.Furniture;
import purdue.cnit255.shoppingapp.R;

public class AddFurniture extends Fragment {
    DataStorage storage;
    String FURNITURE_KEY = "furniture";
    String productCondition = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_furniture, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        storage = new DataStorage(getActivity().getApplicationContext());

        final EditText nameEdText = view.findViewById(R.id.addFurnitureName);
        final EditText manufacturerEdText = view.findViewById(R.id.addFurnitureManufacturer);
        final EditText priceEdText = view.findViewById(R.id.addFurniturePrice);
        final EditText quantityEdText = view.findViewById(R.id.addFurnitureQuantity);
        Button btnAddFurniture = view.findViewById(R.id.btnAddFurniture);

        btnAddFurniture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the strings and int values of the text fields
                String name = nameEdText.getText().toString();
                String manufacturer = manufacturerEdText.getText().toString();
                int price = Integer.parseInt(priceEdText.getText().toString());
                Integer quantity = Integer.parseInt(quantityEdText.getText().toString());

                // Create instances of the address and customer
                Furniture furniture = new Furniture(name, productCondition, manufacturer, price, quantity, "");

                // Get the type of object to retrieve
                Gson gson = new Gson();
                Type type = new TypeToken<List<Customer>>(){}.getType();
                // Pass in the storage key
                String json = storage.getObject(FURNITURE_KEY);
                // Get list of furnitures from json and convert to type list
                ArrayList<Furniture> furnitures = gson.fromJson(json, type);
                Toast.makeText(getActivity(), json, Toast.LENGTH_LONG).show();

                // Init the arraylist if it does not exist
                if (furnitures == null) {
                    furnitures = new ArrayList<>();
                }
                // Add new customer to customer list
                furnitures.add(furniture);

                // Set the furnitures pref to list with new customer
                storage.setObject(FURNITURE_KEY, furnitures);
                // Go back to previous slide
                getFragmentManager().popBackStack();
            }
        });

    }

    public void onFurnitureConditionClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioFurnitureNew:
                if (checked)
                    productCondition = "New";
                    break;
            case R.id.radioFurnitureUsed:
                if (checked)
                    productCondition = "Used";
                    break;
        }
    }
}
