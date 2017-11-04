package org.nevermind.bu.dao;

import org.nevermind.bu.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorDao extends JpaRepository<Actor, Integer> {

    Actor findById(int id);

    Actor findByName(String name);
}
