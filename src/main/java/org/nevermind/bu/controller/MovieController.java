package org.nevermind.bu.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.nevermind.bu.entity.Movie;
import org.nevermind.bu.service.interfaces.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.GET)
    public String getMovieById(@RequestParam("id") int id) throws JsonProcessingException {
        Movie movieById = movieService.getById(id);
        return mapper.writeValueAsString(movieById);
    }

    /*@RequestMapping(method = RequestMethod.GET)
    public String getMovieByName(@RequestParam("name") String name) throws JsonProcessingException {
        Movie movieByName = movieService.getByName(name);
        return mapper.writeValueAsString(movieByName);
    }*/
}
