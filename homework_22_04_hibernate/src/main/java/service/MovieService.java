package service;

import dao.MovieDao;
import org.example.entity.Movie;

public class MovieService {
    private MovieDao usersDao = new MovieDao();

    public MovieService() {
    }

    public Movie findMovie(long id) {
        return usersDao.findById(id);
    }

    public void saveMovie(Movie movie) {
        usersDao.save(movie);
    }

    public void deleteMovie(Movie movie) {
        usersDao.delete(movie);
    }

    public void updateMovie(Movie movie) {
        usersDao.update(movie);
    }
}
