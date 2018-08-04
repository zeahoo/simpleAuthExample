package org.sonny.service;

import java.util.List;

public interface ProductService {
  List getProducts(String userId, String officeId);
}
