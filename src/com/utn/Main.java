package com.utn;

public class Main {

    public static void main(String[] args) {
        ///MOVIES
        Movie m1 = new Movie("Drama", "ZombieLand", "PG", "AUS", 1999, 120, "Zombie movie very cool", 10);
        Movie m3 = new Movie("Drama", "Corona What?", "PG13", "USA", 2020, 240, "Virus everywhere", 50);
        Movie m2 = new Movie("Horror", "Starwars III", "UNRATED", "ARG", 2020, 80, "A student who have to do a test", 15);

        ///CLIENTS
        Client c1 = new Client("Marito", "Utn 2020", 4751111);
        Client c2 = new Client("Gonzalo", "Colon 5354", 5994827);

        ///ROBERTO'S STORE
        Store s1 = new Store();
        ///ADDING MOVIES AND CLIENTS TO THE STORE
        s1.setMovies(m1);
        s1.setMovies(m2);
        s1.setMovies(m3);
        s1.setClients(c2);
        s1.setClients(c1);

        ///SOME RENTALS
        s1.rentMovie("ZOmBiElAnD", "gonZalo");
        s1.rentMovie("starwars iii", "gonZalo");
        s1.rentMovie("starwars iii", "gonZalo");
        System.out.println(s1.rentMovie("zombieland", "marito"));
        System.out.println(s1.rentMovie("StarWarS IiI", "marito"));
        System.out.println(s1.rentMovie("Corona what?", "marito"));

        ///MOVIES RENTED BY THE CLIENT
        System.out.println("\nMovies rented by " + c2.getName() +" "+ c2.printRented());

        ///A CLIENT RETURN A MOVIE
        System.out.println("\n" + s1.returnMovie("test day", "gonzalo"));
        System.out.println("\n" + c1.printRented());

        ///THERE IS SOME MOVIE RETURNS FOR TODAY?
        System.out.println(s1.movieReturnsForToday("31 abril 2020"));

        ///ALL PENDING RETURNS
        System.out.println(s1.movieReturnsPending());

        ///TOP TEN OF MOVIES
        System.out.println(s1.topTenMovies());

    }
}
