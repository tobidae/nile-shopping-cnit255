package purdue.cnit255.shoppingapp.Helpers;

public class Furniture extends Product {

private int quantityAvailable;

 public Furniture(String itemName, String condition, String itemDescription, String manufacturer, float price,int quantityAvailable) {
     super(itemName, condition, itemDescription, manufacturer, price);
     this.quantityAvailable=quantityAvailable;
 }


 @Override
 public void setPrice(float price) {
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
 public void setItemDescription(String itemDescription) {
     super.setItemDescription(itemDescription);
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
 public float getPrice() {
     return super.getPrice();
 }

 @Override
 public String getItemDescription() {
     return super.getItemDescription();
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

}
