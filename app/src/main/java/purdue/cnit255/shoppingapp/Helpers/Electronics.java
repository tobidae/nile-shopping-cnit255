package purdue.cnit255.shoppingapp.Helpers;

public class Electronics extends Product {

    private int amountAvailable;
    private String electronicsType;

    public Electronics(String itemName, String condition, String manufacturer, int price, int amountAvailable, String electronicsType) {
        super(itemName, condition, manufacturer, price);
        this.amountAvailable = amountAvailable;
        this.electronicsType = electronicsType;
    }

    public int getAmountAvailable() {
        return amountAvailable;
    }

    public void setAmountAvailable(int amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    @Override
    public String getCondition() {
        return super.getCondition();
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public String getItemName() {
        return super.getItemName();
    }

    @Override
    public String getManufacturer() {
        return super.getManufacturer();
    }

    @Override
    public void setCondition(String condition) {
        super.setCondition(condition);
    }

    @Override
    public void setItemName(String itemName) {
        super.setItemName(itemName);
    }

    @Override
    public void setManufacturer(String manufacturer) {
        super.setManufacturer(manufacturer);
    }

    @Override
    public void setPrice(int price) {
        super.setPrice(price);
    }

    public String getElectronicsType() {
        return electronicsType;
    }

    public void setElectronicsType(String electronicsType) {
        this.electronicsType = electronicsType;
    }
}
