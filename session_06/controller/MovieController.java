package com.data.session_06.controller;

import com.data.session_06.model.entity.Movie;
import com.data.session_06.model.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    // get/ movies - hiển thị danh sách phim
    @GetMapping
    public String listMovies(Model model){
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "listMovie";
    }

    // get/ movies/add - hiển thị form thêm mới
    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("movie", new Movie());
        return "formAddMovie";
    }

    // post/movies/add - xử lý thêm mới
    @PostMapping("/add")
    public String addMovie(@ModelAttribute("movie") @Validated Movie movie, BindingResult result, Model model){
        if(result.hasErrors()){
            return "formAddMovie";
        }
        movieService.addMovie(movie);
        return "redirect:/movies";
    }

    // xử lý cập nhật
    @GetMapping("/update")
    public String showUpdateForm(@RequestParam("id") Long id, Model model) {
        Movie movie = movieService.getMovieById(id);
        if (movie == null) {
            return "redirect:/movies";
        }
        model.addAttribute("movie", movie);
        return "formUpdateMovie";
    }

    // get/movies/edit/{id} - Xử lý cập nhật
    @PostMapping("/edit/{id}")
    public String updateMovie(@PathVariable("id")Long id,
                              @ModelAttribute("movie")@Validated Movie movie,
                              BindingResult result){
        if(result.hasErrors()){
            return "formUpdateMovie";
        }
        movie.setId(id);
        movieService.updateMovie(movie);
        return "redirect:/movies";
    }

    // get/movies/delete{id} - xử lý xóa phim
    @GetMapping("/delete")
    public String deleteMovie(@RequestParam("id") int id) {
        movieService.deleteMovie(id);
        return "redirect:/movies";
    }
}
