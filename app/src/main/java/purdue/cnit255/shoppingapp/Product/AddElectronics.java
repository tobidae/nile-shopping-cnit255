package purdue.cnit255.shoppingapp.Product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import purdue.cnit255.shoppingapp.DataStorage;
import purdue.cnit255.shoppingapp.Helpers.Customer;
import purdue.cnit255.shoppingapp.Helpers.Electronics;
import purdue.cnit255.shoppingapp.Helpers.Seller;
import purdue.cnit255.shoppingapp.R;

public class AddElectronics extends Fragment implements AdapterView.OnItemSelectedListener {
    DataStorage storage;
    String ELECTRONICS_KEY = "electronics";
    String SELLER_KEY = "sellers";
    String productCondition = "";
    String manufacturer = "";
    String productType = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_electronics, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        storage = new DataStorage(getActivity().getApplicationContext());

        final EditText nameEdText = view.findViewById(R.id.addElectronicsName);
        final Spinner manufacturerSpinner = view.findViewById(R.id.addElectronicsManufacturer);
        final Spinner typeSpinner = view.findViewById(R.id.addElectronicsType);
        final RadioButton radioBtnNew = view.findViewById(R.id.radioElectronicsNew);
        final RadioButton radioBtnUsed = view.findViewById(R.id.radioElectronicsUsed);
        final EditText priceEdText = view.findViewById(R.id.addElectronicsPrice);
        final EditText quantityEdText = view.findViewById(R.id.addElectronicsQuantity);
        Button btnAddElectronics = view.findViewById(R.id.btnAddElectronics);

        // Get the type of object to retrieve, pass in the storage key to get object
        // Then get list of sellers from json and convert to type arraylist
        final Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Seller>>(){}.getType();
        String json = storage.getObject(SELLER_KEY);
        ArrayList<Seller> sellers = gson.fromJson(json, type);
        if (sellers == null) {
            sellers = new ArrayList<>();
        }
        String[] sellerNames = new String[sellers.size()];

        for (int i = 0; i < sellers.size(); i++) {
            sellerNames[i] = sellers.get(i).getBusinessName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity().getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, sellerNames);
        manufacturerSpinner.setAdapter(adapter);
        manufacturerSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.electronics_type, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);
        typeSpinner.setOnItemSelectedListener(this);

        radioBtnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productCondition = "New";
            }
        });
        radioBtnUsed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productCondition = "Used";
            }
        });

        btnAddElectronics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the strings and int values of the text fields
                String name = nameEdText.getText().toString();
                Integer price = Integer.parseInt(priceEdText.getText().toString());
                Integer quantity = Integer.parseInt(quantityEdText.getText().toString());

                // Create instances of the address and customer
                Electronics electronics = new Electronics(name, productCondition, manufacturer, price, quantity, productType);

                // Get the type of object to retrieve
                Type electronicsType = new TypeToken<List<Electronics>>(){}.getType();
                // Pass in the storage key
                String json = storage.getObject(ELECTRONICS_KEY);
                // Get list of electronicss from json and convert to type list
                ArrayList<Electronics> electronicss = gson.fromJson(json, electronicsType);

                // Init the arraylist if it does not exist
                if (electronicss == null) {
                    electronicss = new ArrayList<>();
                }
                // Add new customer to customer list
                electronicss.add(electronics);

                // Set the electronicss pref to list with new customer
                storage.setObject(ELECTRONICS_KEY, electronicss);
                // Go back to previous slide
                getFragmentManager().popBackStack();
            }
        });

    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        switch(parent.getId()) {
            case R.id.addElectronicsManufacturer:
                manufacturer = (String) parent.getItemAtPosition(pos);
                break;
            case R.id.addElectronicsType:
                productType = (String) parent.getItemAtPosition(pos);
                break;
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

}
