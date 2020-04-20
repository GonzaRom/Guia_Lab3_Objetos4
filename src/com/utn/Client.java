package com.utn;

import java.util.ArrayList;

public class Client {
    private String name;
    private int phoneNumber;
    private String address;
    private ArrayList<Movie> rented = new ArrayList<Movie>();


    public Client() {
    }

    public Client(String name, String address, int phoneNumber) {
        this.address = address;
        this.name = name;
        this.phoneNumber = phoneNumber;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void getRented() {
        for (Movie movie : rented) {
            System.out.print(movie.toString());
        }
    }

    public void setRented(Movie rented) {
        this.rented.add(rented);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                '}';
    }
}