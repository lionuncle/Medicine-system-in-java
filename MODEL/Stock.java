/*PROJECT_NAME | ROLL_NUMBER | YOUR_NAME
This is the model class of Stock which all Stock attributes and their getter setter (also known as POJO class in java)
This class does not use any other class
*/
package MODEL;

public class Stock {
    private String productName, quantity, dateIn, unitPrice;
    private boolean isAvailable;

    public Stock() {
        productName = quantity = dateIn = unitPrice = "";
        isAvailable = false;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
