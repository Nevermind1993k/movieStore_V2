package org.nevermind.bu.dao;

import org.nevermind.bu.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDao extends JpaRepository<Movie, Integer> {

    Movie findById(int id);

    Movie findByName(String name);

    /*@Override
    Page<Movie> findAll(Pageable pageable);*/
}
