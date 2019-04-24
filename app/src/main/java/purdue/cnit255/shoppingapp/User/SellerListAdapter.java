package purdue.cnit255.shoppingapp.User;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import purdue.cnit255.shoppingapp.Helpers.Address;
import purdue.cnit255.shoppingapp.Helpers.Seller;
import purdue.cnit255.shoppingapp.R;

public class SellerListAdapter extends ArrayAdapter<Seller> {
    private final Context context;
    private final ArrayList<Seller> sellerList;

    public SellerListAdapter(Context context, ArrayList<Seller> sellerList) {
        super(context, R.layout.seller_list, sellerList);

        this.context=context;
        this.sellerList = sellerList;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context
                .LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.seller_list, null,true);

        TextView txtNameSeller = rowView.findViewById(R.id.txtNameSeller);
        TextView txtPhoneSeller = rowView.findViewById(R.id.txtPhoneSeller);
        TextView txtEmailSeller = rowView.findViewById(R.id.txtEmailSeller);
        TextView txtAddressSeller = rowView.findViewById(R.id.txtAddressSeller);
        TextView txtIDSeller = rowView.findViewById(R.id.txtIDSeller);

        Seller seller = sellerList.get(position);
        Address address = seller.getAddress();

        txtNameSeller.setText(seller.getBusinessName());
        txtPhoneSeller.setText("Phone: " + String.valueOf(seller.getPhoneNumber()));
        txtEmailSeller.setText("•• Email: " + seller.getEmail());
        txtAddressSeller.setText("Address" + address.getStreetAddress() + ", " + address.getCity() + " " +
                address.getState() + " " + address.getZipCode());
        txtIDSeller.setText("ID: " + seller.getId());

        return rowView;

    };
}
