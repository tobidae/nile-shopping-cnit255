package purdue.cnit255.shoppingapp.User;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import purdue.cnit255.shoppingapp.DataStorage;
import purdue.cnit255.shoppingapp.R;

public class AddCustomer extends Fragment {
    DataStorage storage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_customer, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        storage = new DataStorage(getActivity().getApplicationContext());

    }
}
