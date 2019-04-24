package purdue.cnit255.shoppingapp.Product;

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
import purdue.cnit255.shoppingapp.Helpers.Electronics;
import purdue.cnit255.shoppingapp.R;

public class ElectronicsFragment extends Fragment {
    DataStorage storage;
    String ELECTRONICS_KEY = "electronics";
    ArrayList<Electronics> electronics;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        return inflater.inflate(R.layout.electronics_fragment, viewGroup, false);
    }

    // After the view is created, initialize buttons and what not here
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        storage = new DataStorage(getActivity());
        FloatingActionButton electronicsFab = view.findViewById(R.id.electronics_fab);

        // Get the type of object to retrieve, pass in the storage key to get object
        // Then get list of customers from json and convert to type arraylist
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Electronics>>(){}.getType();
        String json = storage.getObject(ELECTRONICS_KEY);
        electronics = gson.fromJson(json, type);

        if (electronics == null) {
            electronics = new ArrayList<>();
        }

        final ElectronicsListAdapter electronicsAdapter = new ElectronicsListAdapter(this.getContext(), electronics);
        ListView electronicsList = view.findViewById(R.id.listElectronics);
        electronicsList.setAdapter(electronicsAdapter);

        electronicsFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch a new fragment by replacing the layout with the fragment
                AddElectronics addElectronicsFrag = new AddElectronics();
                FragmentTransaction fTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fTransaction.replace(R.id.rootLayout, addElectronicsFrag);
                fTransaction.addToBackStack(null);
                fTransaction.commit();
            }
        });

        electronicsList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                electronics.remove(pos);
                storage.setObject(ELECTRONICS_KEY, electronics);
                electronicsAdapter.notifyDataSetChanged();
                Toast.makeText(getActivity().getApplicationContext(),
                        "Deleted a Electronic at index " + pos, Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }
}
