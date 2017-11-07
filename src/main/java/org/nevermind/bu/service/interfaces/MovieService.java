package org.nevermind.bu.service.interfaces;

import org.nevermind.bu.entity.Movie;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface MovieService extends IService<Movie> {

    Movie getByName(String name);

    void updateMovie(int id, Map<String, String> mapWithProps);

//    Page<Movie> getAll(Integer page, Integer size, String order);
}
