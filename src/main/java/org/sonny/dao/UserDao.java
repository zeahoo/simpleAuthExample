package org.sonny.dao;

import java.util.List;
import org.sonny.model.User;

public interface UserDao {

  List getListUser();

  void saveOrUpdate(User user);

  void deleteUser(String id);

  User findUserById(String id);
}
