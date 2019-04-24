package purdue.cnit255.shoppingapp.User;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import purdue.cnit255.shoppingapp.DataStorage;
import purdue.cnit255.shoppingapp.Helpers.Customer;
import purdue.cnit255.shoppingapp.R;

public class CustomerFragment extends Fragment {
    DataStorage storage;
    String CUSTOMER_KEY = "customers";
    ArrayList<Customer> customers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        return inflater.inflate(R.layout.customer_fragment, viewGroup, false);
    }

    // After the view is created, initialize buttons and what not here
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        storage = new DataStorage(getActivity());
        FloatingActionButton customerFab = view.findViewById(R.id.customer_fab);

        // Get the type of object to retrieve, pass in the storage key to get object
        // Then get list of customers from json and convert to type arraylist
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Customer>>(){}.getType();
        String json = storage.getObject(CUSTOMER_KEY);
        customers = gson.fromJson(json, type);

        if (customers == null) {
            customers = new ArrayList<>();
        }

        final CustomerListAdapter customerAdapter = new CustomerListAdapter(this.getContext(), customers);
        ListView customerList = view.findViewById(R.id.listCustomer);
        customerList.setAdapter(customerAdapter);

        customerFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch a new fragment by replacing the layout with the fragment
                AddCustomer addCustomerFrag = new AddCustomer();
                FragmentTransaction fTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fTransaction.replace(R.id.rootLayout, addCustomerFrag);
                fTransaction.addToBackStack(null);
                fTransaction.commit();
            }
        });

        customerList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                customers.remove(pos);
                storage.setObject(CUSTOMER_KEY, customers);
                customerAdapter.notifyDataSetChanged();
                Toast.makeText(getActivity().getApplicationContext(),
                        "Deleted a customer at index " + pos, Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }
}
