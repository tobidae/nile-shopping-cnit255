package purdue.cnit255.shoppingapp.User;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.github.clans.fab.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import purdue.cnit255.shoppingapp.DataStorage;
import purdue.cnit255.shoppingapp.Helpers.Seller;
import purdue.cnit255.shoppingapp.R;

public class SellerFragment extends Fragment {
    DataStorage storage;
    String SELLER_KEY = "sellers";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        return inflater.inflate(R.layout.seller_fragment, viewGroup, false);
    }

    // After the view is created, initialize buttons and what not here
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        storage = new DataStorage(getActivity());
        FloatingActionButton sellerFab = view.findViewById(R.id.seller_fab);

        // Get the type of object to retrieve, pass in the storage key to get object
        // Then get list of sellers from json and convert to type arraylist
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Seller>>(){}.getType();
        String json = storage.getObject(SELLER_KEY);
        ArrayList<Seller> sellers = gson.fromJson(json, type);

        if (sellers == null) {
            sellers = new ArrayList<>();
        }

        SellerListAdapter sellerAdapter = new SellerListAdapter(this.getContext(), sellers);
        ListView sellerList = view.findViewById(R.id.listSeller);
        sellerList.setAdapter(sellerAdapter);
        
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
