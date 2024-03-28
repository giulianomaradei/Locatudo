package org.example;

import java.util.ArrayList;

public class Client {

    private String name, cpf;

    private Address address;

    private ArrayList<Lease> leases;

    public Client(String name, String cpf, Address address) {
        this.name = name;
        this.cpf = cpf;
        this.address = address;

        this.leases = new ArrayList<Lease>();
    }

    public void addLease(Lease lease) {
        this.leases.add(lease);
    }

    public void removeLease(Lease lease) {
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

    public ArrayList<Lease> getLeases() {
        return this.leases;
    }

}
