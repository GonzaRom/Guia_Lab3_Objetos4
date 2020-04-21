package com.utn;

import java.util.ArrayList;

public class Client {
    private String name;
    private int phoneNumber;
    private String address;
    private ArrayList<Ticket> rentalTickets = new ArrayList<Ticket>();


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

    public String printRented() {
        StringBuilder stringRented = new StringBuilder();
        for (Ticket rentalTicket : rentalTickets) {
            stringRented.append(rentalTicket.toString());
            stringRented.append("\n");
        }
        return stringRented.toString();
    }

    public ArrayList<Ticket> getRentalTickets() {
        return rentalTickets;
    }

    public void setRentalTickets(Ticket ticket) {
        this.rentalTickets.add(ticket);
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
