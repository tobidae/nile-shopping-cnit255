package purdue.cnit255.shoppingapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.clans.fab.FloatingActionButton;

import purdue.cnit255.shoppingapp.User.AddCustomer;

public class UserFragment extends Fragment {
    DataStorage storage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user_fragment, container, false);
    }

    // After the view is created, initialize buttons and what not here
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        storage = new DataStorage(getActivity().getApplicationContext());
        FloatingActionButton customerFab = view.findViewById(R.id.customer_fab);
        FloatingActionButton sellerFab = view.findViewById(R.id.seller_fab);

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