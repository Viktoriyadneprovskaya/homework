package org.example.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "movies", schema = "hib")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="movie_name")
    private String movieName;
    @Column(name="release_year")
    private Integer releaseYear;
    private String language;

    public Movie(String movieName, Integer releaseYear,String language){
        this.movieName= movieName;
        this.releaseYear=releaseYear;
        this.language=language;
    }

}
