package org.example;

import java.util.ArrayList;

public interface ILease {
    
    public void removeLeasedItem(Leaseable product);

    public String getLeaseNumber();

    public String getLeaseDate();

    public String getReturnDate();

    public IClient getClient();

    public Double getTotalValue();

    public ArrayList<Leaseable> getLeasedItems();
}
