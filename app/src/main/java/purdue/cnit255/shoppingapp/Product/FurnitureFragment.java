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
import purdue.cnit255.shoppingapp.Helpers.Furniture;
import purdue.cnit255.shoppingapp.R;

public class FurnitureFragment extends Fragment {
    DataStorage storage;
    String FURNITURE_KEY = "furniture";
    ArrayList<Furniture> furniture;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        return inflater.inflate(R.layout.furniture_fragment, viewGroup, false);
    }

    // After the view is created, initialize buttons and what not here
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        storage = new DataStorage(getActivity());
        FloatingActionButton furnitureFab = view.findViewById(R.id.furniture_fab);

        // Get the type of object to retrieve, pass in the storage key to get object
        // Then get list of furniture from json and convert to type arraylist
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Furniture>>(){}.getType();
        String json = storage.getObject(FURNITURE_KEY);
        furniture = gson.fromJson(json, type);

        if (furniture == null) {
            furniture = new ArrayList<>();
        }

        final FurnitureListAdapter furnitureAdapter = new FurnitureListAdapter(this.getContext(), furniture);
        ListView furnitureList = view.findViewById(R.id.listFurniture);
        furnitureList.setAdapter(furnitureAdapter);
        
        furnitureFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch a new fragment by replacing the layout with the fragment
                AddFurniture addFurnitureFrag = new AddFurniture();
                FragmentTransaction fTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fTransaction.replace(R.id.rootLayout, addFurnitureFrag);
                fTransaction.addToBackStack(null);
                fTransaction.commit();
            }
        });

        furnitureList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                furniture.remove(pos);
                storage.setObject(FURNITURE_KEY, furniture);
                furnitureAdapter.notifyDataSetChanged();
                Toast.makeText(getActivity().getApplicationContext(),
                        "Deleted a furniture at index " + pos, Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }
}
