package purdue.cnit255.shoppingapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import purdue.cnit255.shoppingapp.User.CustomerFragment;
import purdue.cnit255.shoppingapp.User.SellerFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        // How to navigate each tab
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_product:
                    pushFragment(new ProductFragment());
                    return true;
                case R.id.navigation_customer:
                    pushFragment(new CustomerFragment());
                    return true;
                case R.id.navigation_seller:
                    pushFragment(new SellerFragment());
                    return true;
                case R.id.navigation_cart:
                    pushFragment(new CartFragment());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // Select first menu item by default and show Fragment accordingly.
        Menu menu = navigation.getMenu();
        pushFragment(new ProductFragment());

    }

    /**
     * Method to push any fragment into given id.
     *
     * @param fragment An instance of Fragment to show into the given id.
     */
    protected void pushFragment(Fragment fragment) {
        if (fragment == null)
            return;
        FragmentTransaction fTransaction = this.getSupportFragmentManager().beginTransaction();
        fTransaction.replace(R.id.rootLayout, fragment);
        fTransaction.addToBackStack(null);
        fTransaction.commit();
    }


}
