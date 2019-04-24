package purdue.cnit255.shoppingapp.User;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import purdue.cnit255.shoppingapp.DataStorage;
import purdue.cnit255.shoppingapp.Helpers.Address;
import purdue.cnit255.shoppingapp.Helpers.Customer;
import purdue.cnit255.shoppingapp.Helpers.User;
import purdue.cnit255.shoppingapp.R;

public class AddCustomer extends Fragment {
    DataStorage storage;
    String CUSTOMER_KEY = "customers";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_customer, container, false);
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
        Button btnAddCustomer = view.findViewById(R.id.btnAddCustomer);

        btnAddCustomer.setOnClickListener(new View.OnClickListener() {
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

                // Create instances of the address and customer
                Address address = new Address(homeAddr, city, zipCode, state);
                Customer customer = new Customer(fName, lName, phoneNo, email, address);

                // Get the type of object to retrieve
                Gson gson = new Gson();
                Type type = new TypeToken<List<Customer>>(){}.getType();
                // Pass in the storage key
                String json = storage.getObject(CUSTOMER_KEY);
                // Get list of customers from json and convert to type list
                ArrayList<Customer> customers = gson.fromJson(json, type);

                // Init the arraylist if it does not exist
                if (customers == null) {
                    customers = new ArrayList<>();
                }
                // Add new customer to customer list
                customers.add(customer);

                // Set the customers pref to list with new customer
                storage.setObject(CUSTOMER_KEY, customers);
                // Go back to previous slide
                getFragmentManager().popBackStack();
            }
        });

    }
}
