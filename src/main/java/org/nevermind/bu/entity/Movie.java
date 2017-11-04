package org.nevermind.bu.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;
    @NotNull
    private Double price;
    @NotNull
    private Integer year;
    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private Genre genre;
    private String trailerLink;
    /*@OneToMany(targetEntity = Actor.class, fetch = FetchType.EAGER)
    private List<Actor> actorList;
    @OneToMany(targetEntity = Director.class*//*, fetch = FetchType.EAGER*//*)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Director> directorList;*/
    /*@OneToMany(targetEntity = Genre.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Genre> genreList;*/

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    /*public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }*/

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    /*public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }

    public List<Director> getDirectorList() {
        return directorList;
    }

    public void setDirectorList(List<Director> directorList) {
        this.directorList = directorList;
    }*/

    public String getTrailerLink() {
        return trailerLink;
    }

    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", year=" + year +
                '}';
    }
}
