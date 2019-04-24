package purdue.cnit255.shoppingapp.User;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import purdue.cnit255.shoppingapp.DataStorage;
import purdue.cnit255.shoppingapp.Helpers.Address;
import purdue.cnit255.shoppingapp.Helpers.Seller;
import purdue.cnit255.shoppingapp.R;

public class AddSeller extends Fragment {
    DataStorage storage;
    String SELLER_KEY = "sellers";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_seller, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        storage = new DataStorage(getActivity().getApplicationContext());

        final EditText businessNameEdText = view.findViewById(R.id.addSellerBusinessName);
        final EditText phoneNoEdText = view.findViewById(R.id.addSellerPhoneNo);
        final EditText emailEdText = view.findViewById(R.id.addSellerEmail);
        final EditText homeAddressEdText = view.findViewById(R.id.addSellerAddress);
        final EditText cityEdText = view.findViewById(R.id.addSellerCity);
        final EditText stateEdText = view.findViewById(R.id.addSellerState);
        final EditText zipCodeEdText = view.findViewById(R.id.addSellerZipCode);
        Button btnAddSeller = view.findViewById(R.id.btnAddSeller);

        btnAddSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the strings and int values of the text fields
                String bName = businessNameEdText.getText().toString();
                Long phoneNo = Long.parseLong(phoneNoEdText.getText().toString());
                String email = emailEdText.getText().toString();
                String homeAddr = homeAddressEdText.getText().toString();
                String city = cityEdText.getText().toString();
                String state = stateEdText.getText().toString();
                Integer zipCode = Integer.parseInt(zipCodeEdText.getText().toString());

                // Create instances of the address and seller
                Address address = new Address(homeAddr, city, zipCode, state);
                Seller seller = new Seller(bName, phoneNo, email, address);

                // Get the type of object to retrieve
                Type type = new TypeToken<ArrayList<Seller>>(){}.getType();
                // Pass in the storage key
                String json = storage.getObject(SELLER_KEY);
                Gson gson = new Gson();
                // Get list of sellers from json and convert to type list
                ArrayList<Seller> sellers = gson.fromJson(json, type);

                // Init the arraylist if it does not exist
                if (sellers == null) {
                    sellers = new ArrayList<>();
                }
                // Add new seller to seller list
                sellers.add(seller);

                // Set the sellers pref to list with new seller
                storage.setObject(SELLER_KEY, sellers);
                // Go back to previous slide
                getFragmentManager().popBackStack();
            }
        });
    }
}
