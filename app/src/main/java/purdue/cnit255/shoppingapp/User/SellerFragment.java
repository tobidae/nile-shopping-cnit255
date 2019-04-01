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

public class SellerFragment extends Fragment {
    DataStorage storage;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        return inflater.inflate(R.layout.seller_fragment, viewGroup, false);
    }

    // After the view is created, initialize buttons and what not here
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        storage = new DataStorage(getActivity().getApplicationContext());
        FloatingActionButton sellerFab = view.findViewById(R.id.seller_fab);

        sellerFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch a new fragment by replacing the layout with the fragment
                AddSeller addSellerFrag = new AddSeller();
                FragmentTransaction fTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fTransaction.replace(R.id.rootLayout, addSellerFrag);
                fTransaction.addToBackStack(null);
                fTransaction.commit();
            }
        });
    }
}
