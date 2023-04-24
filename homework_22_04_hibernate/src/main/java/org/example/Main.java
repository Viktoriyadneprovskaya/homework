package org.example;

import org.example.entity.Movie;
import service.MovieService;


public class Main {
    public static void main(String[] args) throws IllegalAccessException {
//        Configuration configuration=new Configuration();//path to configs file
//        configuration.configure();
//
//        try(SessionFactory sessionFactory = configuration.buildSessionFactory();
//        Session session= sessionFactory.openSession()){
//            session.beginTransaction();
//            Movie movie = new Movie("Scary movie",1990,"Eng");
//            session.save(movie);
//            System.out.println(session.get(Movie.class, 1L));
//            movie.setLanguage("UA");
//            movie.setReleaseYear(2020);
//            session.getTransaction().commit();


        MovieService movieService = new MovieService();
        Movie movie = new Movie("Comedy movie", 2020,"UA");
        movieService.saveMovie(movie);
        System.out.println(movieService.findMovie(1L));
        Movie movie1 = new Movie("Drama movie", 2022,"ENG");
        movieService.saveMovie(movie1);
        Movie movie3=new Movie("History movie",1999,"ENG");
        movieService.saveMovie(movie3);
        Movie movie4= movieService.findMovie(2L);
        System.out.println(movie4.getLanguage());
        movie4.setLanguage("FR");
        movieService.updateMovie(movie4);
        Movie movie5=movieService.findMovie(3L);
        movieService.deleteMovie(movie5);
        Movie movie6= new Movie("Comedy movie",2011,"GE");
        movieService.saveMovie(movie6);
        Movie movie7 = movieService.findMovie(4L);
        movie7.setMovieName("Scary comedy movie");
        movieService.updateMovie(movie7);
        Movie movie8 = movieService.findMovie(5L);
        movieService.deleteMovie(movie8);
        Movie movie9 = new Movie("Nature movie", 2019,"UA");
        movieService.saveMovie(movie9);

    }


    }
