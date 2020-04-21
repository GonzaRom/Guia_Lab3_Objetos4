package com.utn;

public class Main {

    public static void main(String[] args) {
        Movie m1 = new Movie("Drama", "ZombieLand", "PG", "AUS", 1999, 120, "Zombie movie very cool", 10);
        Movie m3 = new Movie("Drama", "Corona What?", "PG13", "USA", 2020, 240, "Virus everywhere", 50);
        Movie m2 = new Movie("Horror", "Starwars III", "UNRATED", "ARG", 2020, 80, "A student who have to do a test", 15);

        Client c1 = new Client("Marito", "Utn 2020", 4751111);
        Client c2 = new Client("Gonzalo", "Colon 5354", 5994827);
        Store s1 = new Store();
        s1.setMovies(m1);
        s1.setMovies(m2);
        s1.setMovies(m3);
        s1.setClients(c2);
        s1.setClients(c1);

        System.out.println(s1.rentMovie("ZOmBiElAnD", "gonZalo"));
        System.out.println(s1.rentMovie("starwars iii", "gonZalo"));
        System.out.println(s1.rentMovie("zombieland", "marito"));
        System.out.println(s1.rentMovie("StarWarS IiI", "marito"));
        System.out.println(s1.rentMovie("Corona what?", "marito"));

        System.out.println("\nMovies rented by " + c2.getName() +" "+ c2.printRented());

        System.out.println("\n" + s1.returnMovie("test day", "gonzalo"));
        System.out.println("\n" + c1.printRented());

        System.out.println(s1.movieReturnsForToday("30 abril 2020"));
        System.out.println(s1.movieReturnsPending());

    }
}
