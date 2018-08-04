package org.sonny.service;

import java.util.List;
import org.sonny.model.User;

public interface UserService {

  List getListUser();

  void saveOrUpdate(User user);

  void deleteUser(String id);

  User findUserById(String id);

}
