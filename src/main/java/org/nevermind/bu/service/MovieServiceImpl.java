package org.nevermind.bu.service;

import org.nevermind.bu.dao.MovieDao;
import org.nevermind.bu.entity.Movie;
import org.nevermind.bu.service.interfaces.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

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
    public void save(Movie movie) {
        movieDao.save(movie);
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
}

