package org.sonny.controller;

import java.util.List;
import org.sonny.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  @Autowired
  private ProductService productService;

  @RequestMapping(value = "/product/{userId}", method = RequestMethod.GET)
  public List getProducts(@PathVariable String userId, @RequestParam(name = "office_id", required = false) String officeId){
    return productService.getProducts(userId, officeId);
  }

}
