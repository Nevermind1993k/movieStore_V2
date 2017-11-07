package org.nevermind.bu.service;

import org.apache.commons.lang3.StringUtils;
import org.nevermind.bu.dao.MovieDao;
import org.nevermind.bu.entity.Genre;
import org.nevermind.bu.entity.Movie;
import org.nevermind.bu.service.interfaces.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Map;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieDao movieDao;

    @Override
    public Movie getById(int id) {
        return movieDao.findById(id);
    }

    @Override
    public Movie getByName(String name) {
        return movieDao.findByName(name);
    }

    @Override
    public Collection<Movie> getAll() {
        return movieDao.findAll();
    }

    @Override
    public Movie save(Movie movie) {
        return movieDao.save(movie);
    }

    @Override
    @Transactional
    public void delete(int id) {
        movieDao.delete(id);
    }

    @Override
    public void update(Movie movie) {
        movieDao.save(movie);
    }

    @Override
    public void updateMovie(int id, Map<String, String> mapWithProps) {
        Movie movieToUpdate = getById(id);

        for (Map.Entry<String, String> entry : mapWithProps.entrySet()) {
            if (StringUtils.isNoneEmpty(entry.getValue())) {
                switch (entry.getKey()) {
                    case "name":
                        movieToUpdate.setName(entry.getValue());
                        break;
                    case "price":
                        movieToUpdate.setPrice(Double.valueOf(entry.getValue()));
                        break;
                    case "year":
                        movieToUpdate.setYear(Integer.valueOf(entry.getValue()));
                        break;
                    case "genre":
                        movieToUpdate.setGenre(Genre.valueOf(entry.getValue()));
                        break;
                }
            }
        }
        movieDao.save(movieToUpdate);
    }
}

