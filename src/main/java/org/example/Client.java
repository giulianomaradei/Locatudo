package org.example;

import java.util.ArrayList;

public class Client implements IClient {

    private String name, cpf;
    private Address address;
    private ArrayList<ILease> leases;

    public Client(String name, String cpf, Address address) {
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.leases = new ArrayList<ILease>();
    }

    public void addLease(ILease lease) {
        this.leases.add(lease);
    }

    public void removeLease(ILease lease) {
        this.leases.remove(lease);
    }

    public String getName() {
        return this.name;
    }

    public String getCpf() {
        return this.cpf;
    }

    public Address getAddress() {
        return this.address;
    }

    public ArrayList<ILease> getLeases() {
        return this.leases;
    }

}
