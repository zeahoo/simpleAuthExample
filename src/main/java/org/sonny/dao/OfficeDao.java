package org.sonny.dao;

import java.util.List;
import org.sonny.model.Office;

public interface OfficeDao {

  Office findOfficeById(String id);

  List findOfficeByParentId(String parentId);
}
