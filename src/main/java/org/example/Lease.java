package org.example;

import java.util.ArrayList;

public class Lease {

    private String leaseNumber;
    private String leaseDate;
    private String returnDate;
    private Client client;
    private ArrayList<Product> leasedItems;
    private Double totalValue = 0.;

    public Lease(String leaseNumber, String leaseDate, String returnDate, Client client, ArrayList<Product> leasedItems) {
        this.leaseNumber = leaseNumber;
        this.leaseDate = leaseDate;
        this.returnDate = returnDate;
        this.client = client;
        this.leasedItems = leasedItems;
        for (Product product : leasedItems) {
            totalValue += product.getPrice();
        }
    }

    public void removeLeasedItem(Product product) {
        totalValue -= product.getPrice();
        this.leasedItems.remove(product);
    }

    public String getLeaseNumber() {
        return this.leaseNumber;
    }

    public String getLeaseDate() {
        return this.leaseDate;
    }

    public String getReturnDate() {
        return this.returnDate;
    }

    public Client getClient() {
        return this.client;
    }

    public Double getTotalValue() {
        return this.totalValue;
    }

    public ArrayList<Product> getLeasedItems() {
        return this.leasedItems;
    }

}
