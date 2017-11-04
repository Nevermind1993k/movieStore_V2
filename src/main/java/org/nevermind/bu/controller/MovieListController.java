package org.nevermind.bu.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.nevermind.bu.entity.Genre;
import org.nevermind.bu.service.interfaces.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieListController {
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MovieService movieService;

    /*@RequestMapping(method = RequestMethod.GET)
    public JsonNode getAllMovies(@RequestParam("genre") Optional<String> genre) {
        Genre someGenre = Genre.valueOf(genre.orElse("COMEDY"));
        return mapper.valueToTree(movieService.geA)
    }*/

    @RequestMapping(method = RequestMethod.GET)
    public JsonNode getAllMovies() {
        return mapper.valueToTree(movieService.getAll());
    }

}
