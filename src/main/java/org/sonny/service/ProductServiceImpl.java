package org.sonny.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.sonny.dao.OfficeDao;
import org.sonny.dao.ProductDao;
import org.sonny.dao.UserDao;
import org.sonny.model.Office;
import org.sonny.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductDao productDao;

  @Autowired
  private UserDao userDao;

  @Autowired
  private OfficeDao officeDao;

  public List getProducts(String userId, String officeId) {

    User currentUser = userDao.findUserById(userId);
    String userOfficeId = currentUser.getOfficeId();
    // 查询当前用户所在部门以及部门以下的数据
    List<Office> officeList = officeDao.findOfficeByParentId(userOfficeId);
    return productDao.getProducts(officeId,
        officeList.stream().map(Office::getId).collect(Collectors.toList()));

  }
}
