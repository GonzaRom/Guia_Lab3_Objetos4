package com.utn;

import java.util.Objects;
import java.util.UUID;

public class Movie {
    private UUID id;
    private String genre;
    private String title;
    private int releaseYear;
    private int duration;
    private String rated;
    private String country;
    private String description;
    private int stock;
    private int countPopularity;

    public Movie() {
    }

    public Movie(String genre, String title, String rated, String country, int releaseYear, int duration, String description, int stock) {
        this.id=UUID.randomUUID();
        this.country = country;
        this.description = description;
        this.duration = duration;
        this.genre = genre;
        this.rated = rated;
        this.title = title;
        this.releaseYear = releaseYear;
        this.stock = stock;
        this.countPopularity=0;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void takeOneMovie() {
        stock--;
    }

    public void returnOneMovie() {
        stock++;
    }

    public int getCountPopularity() {
        return countPopularity;
    }

    public void increaseCountPopularity() {
        this.countPopularity++;
    }


    public String toString() {
        return "Movie{" +
                "genre='" + genre + '\'' +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", duration=" + duration +
                "min, rated='" + rated + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                '}';
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id.equals(movie.id);
    }


    public int hashCode() {
        return Objects.hash(id);
    }

}
