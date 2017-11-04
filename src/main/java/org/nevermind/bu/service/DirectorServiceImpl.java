package org.nevermind.bu.service;

import org.nevermind.bu.dao.DirectorDao;
import org.nevermind.bu.entity.Director;
import org.nevermind.bu.service.interfaces.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    DirectorDao directorDao;

    @Override
    public Director getById(int id) {
        return directorDao.findById(id);
    }

    @Override
    public Collection<Director> getAll() {
        return directorDao.findAll();
    }

    @Override
    public void save(Director director) {
        directorDao.save(director);
    }

    @Override
    @Transactional
    public void delete(int id) {
        directorDao.delete(id);
    }

    @Override
    public void update(Director director) {
        directorDao.save(director);
    }
}
