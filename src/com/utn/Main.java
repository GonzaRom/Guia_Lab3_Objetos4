package com.utn;

public class Main {

    public static void main(String[] args) {
        Movie m1 = new Movie("Drama", "ZombieLand", "PG", "AUS", 1999, 120, "Zombie movie very cool", 10);
        Movie m3 = new Movie();
        Movie m2 = new Movie("Horror", "Test Day", "UNRATED", "ARG", 2020, 80, "A student who have to do a test", 15);

        Client c1 = new Client();
        Client c2 = new Client("Gonzalo", "Colon 5354", 5994827);
        Store s1 = new Store();
        s1.setMovies(m1);
        s1.setMovies(m2);
        s1.setMovies(m3);
        s1.setClients(c2);
        s1.setClients(c1);

        System.out.println(s1.getClients());
        System.out.println(s1.getMovies());

        System.out.println(s1.rentMovie());

        System.out.println(m1.toString());
        System.out.println("\nMovies rented by " + c2.getName());
        c2.getRented();

    }
}
