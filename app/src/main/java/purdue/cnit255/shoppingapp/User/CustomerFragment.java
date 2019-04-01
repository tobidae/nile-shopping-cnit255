package purdue.cnit255.shoppingapp.User;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.clans.fab.FloatingActionButton;

import purdue.cnit255.shoppingapp.DataStorage;
import purdue.cnit255.shoppingapp.R;

public class CustomerFragment extends Fragment {
    DataStorage storage;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        return inflater.inflate(R.layout.customer_fragment, viewGroup, false);
    }

    // After the view is created, initialize buttons and what not here
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        storage = new DataStorage(getActivity().getApplicationContext());
        FloatingActionButton customerFab = view.findViewById(R.id.customer_fab);

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
    }
}
