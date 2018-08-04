package org.sonny.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "office")
public class Office {

  @Id
  @GenericGenerator(name = "uuidGenerator", strategy = "org.sonny.util.UUIDGenerator")
  @GeneratedValue(generator = "uuidGenerator")
  private String id;

  @Column(name = "name")
  private String name;
  @Column(name = "parent_id")
  private String parentId;
  @Column(name = "parent_ids")
  private String parentIds;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public String getParentIds() {
    return parentIds;
  }

  public void setParentIds(String parentIds) {
    this.parentIds = parentIds;
  }
}
