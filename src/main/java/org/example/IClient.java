package org.example;

import java.util.ArrayList;

public interface IClient {
    
    public String getName();

    public String getCpf();

    public Address getAddress();

    public ArrayList<ILease> getLeases();

    public void addLease(ILease lease);

    public void removeLease(ILease lease);
}
