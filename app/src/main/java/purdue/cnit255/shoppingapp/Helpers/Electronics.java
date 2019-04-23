package purdue.cnit255.shoppingapp.Helpers;

public class Electronics extends Product {

  private int amountAvailable;

     public Electronics(String itemName, String condition, String itemDescription, String manufacturer, float price,int amountAvailable) {
         super(itemName, condition, itemDescription, manufacturer, price);
         this.amountAvailable=amountAvailable;
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
     public String getItemDescription() {
         return super.getItemDescription();
     }

     @Override
     public float getPrice() {
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
     public void setItemDescription(String itemDescription) {
         super.setItemDescription(itemDescription);
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
     public void setPrice(float price) {
         super.setPrice(price);
     }



}
