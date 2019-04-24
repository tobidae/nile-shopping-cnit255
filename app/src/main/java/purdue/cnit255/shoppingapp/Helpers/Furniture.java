package purdue.cnit255.shoppingapp.Helpers;

public class Furniture extends Product {

    private int quantityAvailable;
    private String furnitureType;

    public Furniture(String itemName, String condition, String manufacturer, int price,int quantityAvailable, String furnitureType) {
        super(itemName, condition, manufacturer, price);
        this.quantityAvailable=quantityAvailable;
        this.furnitureType = furnitureType;
    }

    @Override
    public void setPrice(int price) {
        super.setPrice(price);
    }

    @Override
    public void setManufacturer(String manufacturer) {
        super.setManufacturer(manufacturer);
    }

    @Override
    public void setItemName(String itemName) {
        super.setItemName(itemName);
    }

    @Override
    public void setCondition(String condition) {
        super.setCondition(condition);
    }

    @Override
    public String getManufacturer() {
        return super.getManufacturer();
    }

    @Override
    public String getItemName() {
        return super.getItemName();
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public String getCondition() {
        return super.getCondition();
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public String getFurnitureType() {
        return furnitureType;
    }

    public void setFurnitureType(String furnitureType) {
        this.furnitureType = furnitureType;
    }
}
