package purdue.cnit255.shoppingapp.Helpers;

public class Product {

  private String itemName;
     private String condition;
     private String itemDescription;
     private String manufacturer;
     private float price;

     public Product(String itemName,String condition,String itemDescription, String manufacturer, float price){
         this.itemName=itemName;
         this.condition=condition;
         this.itemDescription=itemDescription;
         this.manufacturer=manufacturer;
         this.price=price;

     }

     public void setCondition(String condition) {
         this.condition = condition;
     }

     public String getCondition() {
         return condition;
     }

     public String getItemDescription() {
         return itemDescription;
     }

     public String getItemName() {
         return itemName;
     }

     public String getManufacturer() {
         return manufacturer;
     }

     public void setItemDescription(String itemDescription) {
         this.itemDescription = itemDescription;
     }

     public void setItemName(String itemName) {
         this.itemName = itemName;
     }

     public void setManufacturer(String manufacturer) {
         this.manufacturer = manufacturer;
     }

     public void setPrice(float price) {
         this.price = price;
     }

     public float getPrice() {
         return price;
     }


}
