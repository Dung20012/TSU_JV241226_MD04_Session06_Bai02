package com.data.session_06.model.service;

import com.data.session_06.model.dao.MovieDAO;
import com.data.session_06.model.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieDAO movieDAO;

    public MovieService(){
        movieDAO = new MovieDAO();
    }

    public List<Movie> getAllMovies(){
        return movieDAO.findAll();
    }

    public Movie getMovieById(long id){
        return movieDAO.findById(id);
    }

    public void addMovie(Movie movie){
        movieDAO.insert(movie);
    }

    public void updateMovie(Movie movie){
        movieDAO.update(movie);
    }

    public void deleteMovie(long id){
        movieDAO.delete(id);
    }
}
