package org.nevermind.bu.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.nevermind.bu.entity.Movie;
import org.nevermind.bu.service.interfaces.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MovieService movieService;

    /*@RequestMapping(method = RequestMethod.GET)
    public String getMovieById(@RequestParam("id") int id) throws JsonProcessingException {
        Movie movieById = movieService.getById(id);
        return mapper.writeValueAsString(movieById);
    }*/

    @RequestMapping(method = RequestMethod.GET)
    public String getMovieByName(@RequestParam("name") String name) throws JsonProcessingException {
        Movie movieByName = movieService.getByName(name);
        return mapper.writeValueAsString(movieByName);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addMovie(@RequestBody JsonNode newMovie) throws JsonProcessingException {
        Movie movie = mapper.treeToValue(newMovie, Movie.class);
        if (movieService.save(movie) != null) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.OK) //always return status 200- OK
    public void deleteMovie(@PathVariable("id") int id) {
        movieService.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateMovie(@PathVariable("id") int id, @RequestBody JsonNode detailsToUpdate) throws JsonProcessingException {
        Movie updatedMovie = mapper.treeToValue(detailsToUpdate, Movie.class);
        movieService.update(updatedMovie);
    }


}
