package software.project.backend.Model;

public class order implements Imodel{
    private int orderID;
    private double totalPrice;
    private int noOfItems;
    private String date;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(int numOfItems) {
        this.noOfItems = numOfItems;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
