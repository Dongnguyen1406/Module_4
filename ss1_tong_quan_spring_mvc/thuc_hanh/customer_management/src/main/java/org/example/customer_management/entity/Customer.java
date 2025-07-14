package org.example.customer_management.entity;

public class Customer {
    private Integer codeCus;
    private String nameCus;
    private String email;
    private String address;

    public Customer() {
    }

    public Customer(Integer codeCus, String nameCus, String email, String address) {
        this.codeCus = codeCus;
        this.nameCus = nameCus;
        this.email = email;
        this.address = address;
    }

    public Integer getCodeCus() {
        return codeCus;
    }

    public void setCodeCus(Integer codeCus) {
        this.codeCus = codeCus;
    }

    public String getNameCus() {
        return nameCus;
    }

    public void setNameCus(String nameCus) {
        this.nameCus = nameCus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
