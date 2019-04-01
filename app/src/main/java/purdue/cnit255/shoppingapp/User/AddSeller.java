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
import purdue.cnit255.shoppingapp.Helpers.Customer;
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

        final EditText firstNameEdText = view.findViewById(R.id.addCustomerFirstName);
        final EditText lastNameEdText = view.findViewById(R.id.addCustomerLastName);
        final EditText phoneNoEdText = view.findViewById(R.id.addCustomerPhoneNo);
        final EditText emailEdText = view.findViewById(R.id.addCustomerEmail);
        final EditText homeAddressEdText = view.findViewById(R.id.addCustomerAddress);
        final EditText cityEdText = view.findViewById(R.id.addCustomerCity);
        final EditText stateEdText = view.findViewById(R.id.addCustomerState);
        final  EditText zipCodeEdText = view.findViewById(R.id.addCustomerZipCode);
        Button btnAddSeller = view.findViewById(R.id.btnAddCustomer);

        btnAddSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the strings and int values of the text fields
                String fName = firstNameEdText.getText().toString();
                String lName = lastNameEdText.getText().toString();
                Long phoneNo = Long.parseLong(phoneNoEdText.getText().toString());
                String email = emailEdText.getText().toString();
                String homeAddr = homeAddressEdText.getText().toString();
                String city = cityEdText.getText().toString();
                String state = stateEdText.getText().toString();
                Integer zipCode = Integer.parseInt(zipCodeEdText.getText().toString());

                // Create instances of the address and seller
                Address address = new Address(homeAddr, city, zipCode, state);
                Customer seller = new Customer(fName, lName, phoneNo, email, address);

                // Get the type of object to retrieve
                Type type = new TypeToken<ArrayList<Customer>>(){}.getType();
                // Pass in the storage key
                String json = storage.getObject(SELLER_KEY);
                Gson gson = new Gson();
                // Get list of sellers from json and convert to type list
                ArrayList<Customer> sellers = gson.fromJson(json, type);

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
