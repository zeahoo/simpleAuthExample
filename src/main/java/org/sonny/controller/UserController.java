package org.sonny.controller;

import java.util.List;
import org.sonny.model.User;
import org.sonny.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(value = "/user/", method = RequestMethod.GET, headers = "Accept=application/json")
  @ResponseBody
  public List getListUser() {
    return userService.getListUser();
  }

  @RequestMapping(value = "/add/", method = RequestMethod.POST)
  @ResponseBody
  public User add(@RequestBody User user) {
    userService.saveOrUpdate(user);
    return user;
  }

  @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
  @ResponseBody
  public User update(@PathVariable("id") String id, @RequestBody User user) {
    user.setId(id);
    userService.saveOrUpdate(user);
    return user;
  }

  @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
  @ResponseBody
  public User delete(@PathVariable("id") String id) {
    User user = userService.findUserById(id);
    userService.deleteUser(id);
    return user;
  }

}
