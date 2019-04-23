package purdue.cnit255.shoppingapp.User;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import purdue.cnit255.shoppingapp.Helpers.Address;
import purdue.cnit255.shoppingapp.Helpers.Customer;
import purdue.cnit255.shoppingapp.R;

public class CustomerListAdapter extends ArrayAdapter<Customer> {
    private final Context context;
    private final ArrayList<Customer> customerList;

    public CustomerListAdapter(Context context, ArrayList<Customer> customerList) {
        super(context, R.layout.customer_list, customerList);

        this.context=context;
        this.customerList = customerList;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context
                .LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.customer_list, null,true);

        TextView txtNameCustomer = rowView.findViewById(R.id.txtNameCustomer);
        TextView txtPhoneCustomer = rowView.findViewById(R.id.txtPhoneCustomer);
        TextView txtEmailCustomer = rowView.findViewById(R.id.txtEmailCustomer);
        TextView txtAddressCustomer = rowView.findViewById(R.id.txtAddressCustomer);
        TextView txtIDCustomer = rowView.findViewById(R.id.txtIDCustomer);

        Customer customer = customerList.get(position);
        Address address = customer.getAddress();

        txtNameCustomer.setText(customer.getFirstName() + " " + customer.getLastName());
        txtPhoneCustomer.setText(String.valueOf(customer.getPhoneNumber()));
        txtEmailCustomer.setText("•• " + customer.getEmail());
        txtAddressCustomer.setText(address.getStreetAddress() + ", " + address.getCity() + " " +
                address.getState() + " " + address.getZipCode());
        txtIDCustomer.setText("ID: " + customer.getId());

        return rowView;

    };
}
