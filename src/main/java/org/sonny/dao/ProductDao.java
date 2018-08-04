package org.sonny.dao;

import java.util.List;

public interface ProductDao {

  List getProducts(String officeId, List<String> officeIdList);
}
