package com.utn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Store {

    protected ArrayList<Movie> movies = new ArrayList<Movie>();
    protected ArrayList<Client> clients = new ArrayList<Client>();

    public Store() {
    }

    public Store(ArrayList<Movie> movies, ArrayList<Client> clients) {
        this.movies = movies;
        this.clients = clients;
    }

    public void setMovies(Movie movie) {
        this.movies.add(movie);
    }

    public String getMovies() {
        return movies.toString();
    }

    public void setClients(Client client) {
        this.clients.add(client);
    }

    public String getClients() {
        return clients.toString();
    }

    public boolean haveCopiesLeft(Movie movie) {
        return movie.getStock() != 0;
    }

    public Movie searchMovie(String nameMovie) {        //Search if the movie is in the store
        Movie movie = new Movie();                      //Init a empty movie
        Iterator<Movie> i = this.movies.iterator();     //Init a Iterator of Movie from the list of Movies
        boolean flag = false;                           //Flag = True Movie found
                                                        //Flag = False Movie not found

        while (i.hasNext() && !flag) {                  //Iterator to traverse the list while there is elements in the
                                                        // list and the movie wasn't found
            movie = i.next();                           //Because i couldn't use the method getTitle stray from i.next
            if (movie.getTitle() != null && movie.getTitle().equalsIgnoreCase(nameMovie)) {
                                                        //Avoid the NullPointerException with movie.getTitle != null
                                                        //and if there is a name equal (ignoring Case sensitive)
                flag = true;                            //Stop searching
            }
        }
        if (flag) return movie;                         //Flag = True Movie found
        else return null;                               //Flag = False Movie not found
    }

    public Client searchClient(String nameClient) {
        Client client = new Client();
        Iterator<Client> i = this.clients.iterator();
        boolean flag = false;

        while (i.hasNext() && !flag) {
            client = i.next();
            if (client.getName() != null && client.getName().equalsIgnoreCase(nameClient)) {
                flag = true;
            }
        }
        if (flag) return client;
        else return null;

    }

    public Client newClient() {
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre :");
        client.setName(scanner.nextLine());
        System.out.println("Address :");
        client.setAddress(scanner.nextLine());
        System.out.println("Phone Number :");
        client.setPhoneNumber(scanner.nextInt());

        return client;
    }

    public String rentMovie() {
        Scanner scanner = new Scanner(System.in);               //init Scanner
        String movieTitle = scanner.next();                     //scan name of the movie

        Movie movie = searchMovie(movieTitle);                  //Search if the movie is in the store
        if (movie != null) {                                    //If that movie exist

            if (haveCopiesLeft(movie)) {                        //search if there is copies left

                String nameClient = scanner.next();             //Ask for the name of the client
                Client client = searchClient(nameClient);       //Search if the Client is already register

                if (client != null) {                           //If the client is already register
                    Ticket ticket = new Ticket(client, movie);  //construct a ticket with the Movie and the Client
                    return ticket.toString();                   // Return current ticket
                } else {                                        //The client doesn't exist
                    clients.add(client = newClient());          //create a new Client and add it in the list of Clients

                    Ticket ticket = new Ticket(client, movie);  //construct a ticket with the Movie and the Client
                    return ticket.toString();                   // Return current ticket
                }
            } else {                                            //No more copies left? Say srry for that
                return "Sorry, we ran out of stock for this movie";
            }
        } else {                                                //The movie doesn't exist? Apologies for that
            return "Movie don't found";
        }
    }

    public String returnMovie (String movieTitle) {
        Movie movie = searchMovie(movieTitle);                  //Search if the movie is in the store
        if (movie != null) {                                    //If that movie exist
            movie.returnOneMovie();
            ////////--currentRentals
        }
        return "movie Returned";

    }
}

