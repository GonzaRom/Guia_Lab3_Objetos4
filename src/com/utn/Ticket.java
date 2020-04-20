package com.utn;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Ticket extends Store {
    private String currentDate;
    private String returnDate;
    private Client client;
    private Movie movie;


    public Ticket() {
    }

    public Ticket(Client client, Movie movie) {
        this.client = client;
        this.movie = movie;
        setCurrentDate();
        setReturnDate();
        movie.setStock(extractOneMovie(movie));
        client.setRented(movie);
    }

    public int extractOneMovie(Movie movie) {
        int newStock = movie.getStock();
        return --newStock;
    }

    public void setCurrentDate() {
        LocalDate localDate = LocalDate.now(); //Catch local time
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd LLLL yyyy"); // Setting the format like: DAY MONTH YEAR
        this.currentDate = localDate.format(formato); //Assign the new string with the correct format and date
    }

    public void setReturnDate() {
        LocalDate localDate = LocalDate.now(); //Catch local time
        LocalDate returnDate = localDate.plusDays(10); //Add 10 days more to the current date
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd LLLL yyyy"); // Setting the format like: DAY MONTH YEAR
        this.returnDate = returnDate.format(formato); //Assign the new string with the correct format and date
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "Today='" + currentDate + '\'' +
                ", Return Date='" + returnDate + '\'' +
                ", Client=" + client.getName() +
                ", Movie=" + movie.getTitle() +
                '}';
    }
}
