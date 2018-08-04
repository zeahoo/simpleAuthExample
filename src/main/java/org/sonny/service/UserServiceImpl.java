package org.sonny.service;

import java.util.List;
import javax.transaction.Transactional;
import org.sonny.dao.UserDao;
import org.sonny.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {

  private final UserDao userDao;

  @Autowired
  public UserServiceImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  public List getListUser() {
    return userDao.getListUser();
  }

  public void saveOrUpdate(User user) {
    userDao.saveOrUpdate(user);
  }

  public void deleteUser(String id) {
    userDao.deleteUser(id);
  }

  public User findUserById(String id) {
    return userDao.findUserById(id);
  }
}
