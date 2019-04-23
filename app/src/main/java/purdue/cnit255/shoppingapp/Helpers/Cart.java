package purdue.cnit255.shoppingapp.Helpers;

import java.util.ArrayList;

public class Cart {
    ArrayList<Product> items =  new ArrayList<Product>();
    Customer user;

    public Cart(Customer user){
        this.user = user;
    }

    public void addItem(Product item){
        items.add(item);
    }

    public ArrayList getCart(){
        return this.items;
    }

    public double getTotal(){
        double total = 0;
        for (int i = 0; i < items.size(); i++){
            total += items.get(i).getPrice();
        }
        return total;
    }
}
