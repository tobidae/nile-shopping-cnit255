package purdue.cnit255.shoppingapp.Helpers;

public class Product {

    private String itemName;
    private String condition;
    private String manufacturer;
    private int price;

    public Product(String itemName, String condition, String manufacturer, int price) {
        this.itemName = itemName;
        this.condition = condition;
        this.manufacturer = manufacturer;
        this.price = price;

    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public String getItemName() {
        return itemName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }


}
