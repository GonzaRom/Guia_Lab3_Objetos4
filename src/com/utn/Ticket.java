package com.utn;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Ticket extends Store {
    private String currentDate;
    private String returnDate;
    private Client client;
    private Movie movie;
    private boolean returned;


    public Ticket() {
    }

    public Ticket(Client client, Movie movie) {
        this.client = client;
        this.movie = movie;
        setCurrentDate();
        setReturnDate();
        movie.takeOneMovie();
        movie.increaseCountPopularity();
        returned=false;
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

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public String printMovies() {
        return this.movie.toString();
    }

    public Movie getMovie (){
        return this.movie;
    }

    public Client getClient() {
        return client;
    }
    public String getReturnDate(){
        return returnDate;
    }

}
