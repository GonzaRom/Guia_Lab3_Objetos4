package com.utn;

import java.util.ArrayList;
import java.util.Iterator;

public class Store {

    protected ArrayList<Movie> movies = new ArrayList<>();                      ///ALL the movies
    protected ArrayList<Client> clients = new ArrayList<>();                    ///ALL the clients
    protected ArrayList<Ticket> tickets = new ArrayList<>();                    ///ALL the Tickets (Movie Rentals)

    public Store() {
    }

    public void setMovies(Movie movie) {
        this.movies.add(movie);
    }

    public void setClients(Client client) {
        this.clients.add(client);
    }

    public boolean haveCopiesLeft(Movie movie) {
        return movie.getStock() != 0;
    }

    ////SEARCH A MOVIE IN THE LIST OF MOVIES
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
    ////

    ////SEARCH A CLIENT IN THE LIST OF CLIENTS
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
    /////

    ////RENT A MOVIE
    public String rentMovie(String movieTitle, String nameClient) {
        Movie movie = searchMovie(movieTitle);                  //Search if the movie is in the store
        if (movie != null) {                                    //If that movie exist

            if (haveCopiesLeft(movie)) {                        //search if there is copies left
                Client client = searchClient(nameClient);       //Search if the Client is already register

                if (client != null) {                           //If the client is already register
                    Ticket ticket = new Ticket(client, movie);  //construct a ticket with the Movie and the Client
                    this.tickets.add(ticket);                   //
                    client.setRentalTickets(ticket);            //Add the ticket in the arraylist of movie rentals by the client
                    return ticket.toString();                   // Return current ticket

                } else {                                        //The client doesn't exist
                    client = new Client(nameClient, "Wash", 4751111); //create a new Client
                    clients.add(client);                         //and add it in the list of Clients
                    Ticket ticket = new Ticket(client, movie);  //construct a ticket with the Movie and the Client
                    this.tickets.add(ticket);
                    client.setRentalTickets(ticket);            //Add the ticket in the arraylist of movie rentals by the client
                    return ticket.toString();                   // Return current ticket
                }
            } else {                                            //No more copies left? Say srry for that
                return "Sorry, we ran out of stock for this movie";
            }
        } else {                                                //The movie doesn't exist? Apologies for that
            return "Movie not found";
        }
    }
    ////

    ////RETURN MOVIE
    public String returnMovie(String movieTitle, String clientName) {
        Movie movie = searchMovie(movieTitle);                                     //Search if the movie is in the store
        Client client = searchClient(clientName);
        if (movie != null && client != null) {                                    //If that movie exist adn client exist
            Iterator<Ticket> i = client.getRentalTickets().iterator();
            boolean flag = false;

            while (i.hasNext()) {
                Ticket ticketInList = i.next();
                Movie movieRented = ticketInList.getMovie();
                flag = movieRented.equals(movie);

                if (flag) {
                    movieRented.returnOneMovie();
                    ticketInList.setReturned(true);
                    return "Movie Returned";
                }
            }
        }
        return "Movie or Client is incorrect";
    }
    ////

    ////MOVIE RETURNS FOR TODAY
    public String movieReturnsForToday(String date) {
        StringBuilder nameMovieReturns = new StringBuilder();
        // for (Client client : clients) {
        for (Ticket currentTicket : tickets) {                      ///FOR optimized with just one loop
            if (!currentTicket.isReturned() && currentTicket.getReturnDate().equalsIgnoreCase(date)) {
                nameMovieReturns.append("\nClient: ");
                nameMovieReturns.append(currentTicket.getClient().getName());
                nameMovieReturns.append("\tMovie: ");
                nameMovieReturns.append(currentTicket.getMovie().getTitle());
            }
            //}
        }
        return "Movies Returns for today " + date + " :" + nameMovieReturns.toString();
    }
    ////

    ////ALQUILERES PENDIENTES
    public String movieReturnsPending() {
        StringBuilder nameMovieReturns = new StringBuilder();
        //for (Client client : clients) {
        for (Ticket currentTicket : tickets) {                      ///FOR optimized with just one loop
            if (!currentTicket.isReturned()) {
                nameMovieReturns.append("\nClient: ");
                nameMovieReturns.append(currentTicket.getClient().getName());
                nameMovieReturns.append("\tMovie: ");
                nameMovieReturns.append(currentTicket.getMovie().getTitle());
            }
            //  }
        }
        return "Movies pending for return :" + nameMovieReturns.toString();
    }
    ////

    ////SORT BY POPULARITY
    public void insertionSortByPopularity() {
        Movie[] topTenArray = new Movie[movies.size()];
        topTenArray = movies.toArray(topTenArray);

        for (int i = 1; i < topTenArray.length; ++i) {
            Movie aux = topTenArray[i];
            int j = i - 1;
            while (j >= 0 && topTenArray[j].getCountPopularity() < aux.getCountPopularity()) {
                topTenArray[j + 1] = topTenArray[j];
                j = j - 1;
            }
            topTenArray[j + 1] = aux;
        }

        movies.clear();
        for (Movie arrayMovies : topTenArray) {
            movies.add(arrayMovies);
        }
    }
    ////

    ////TOP TEN MOVIES
    public String topTenMovies() {
        StringBuilder topTen = new StringBuilder();
        insertionSortByPopularity();
        Movie[] topTenArray = new Movie[movies.size()];
        topTenArray = movies.toArray(topTenArray);

        for (int x = 0; x < 10 && x < topTenArray.length; x++) {
            topTen.append(topTenArray[x].getTitle());
            topTen.append("\n");
        }
        return "Top Ten Most Rented Movies :\n" + topTen;
    }
    ////
}

