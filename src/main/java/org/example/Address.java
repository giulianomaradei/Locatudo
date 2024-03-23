package org.example;

public class Address {

    private String street, district, zipCode, complement;
    private Integer number;

    public Address (String street, String district, String zipCode, String complement, Integer number) {
        this.street = street;
        this.district = district;
        this.zipCode = zipCode;
        this.complement = complement;
        this.number = number;
    }

    public String getFullAddress() {
        return this.street + ", " + this.number + " - " + this.district + " - " + this.zipCode + " - " + this.complement;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
