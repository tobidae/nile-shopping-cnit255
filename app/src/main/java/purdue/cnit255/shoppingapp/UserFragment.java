package purdue.cnit255.shoppingapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class UserFragment extends Fragment {
    DataStorage storage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        storage = new DataStorage(getActivity().getApplicationContext());
        return inflater.inflate(R.layout.user_fragment, container, false);
    }
}