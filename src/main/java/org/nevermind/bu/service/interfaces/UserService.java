package org.nevermind.bu.service.interfaces;

import org.nevermind.bu.entity.User;

public interface UserService extends IService<User> {
    User getByName(String name);
}
