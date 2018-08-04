package org.sonny.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user")
public class User {

  @Id
  @GenericGenerator(name = "uuidGenerator", strategy = "org.sonny.util.UUIDGenerator")
  @GeneratedValue(generator = "uuidGenerator")
  private String id;

  @Column(name = "name")
  private String name;

  @Column(name = "office_id")
  private String officeId;

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

  public String getOfficeId() {
    return officeId;
  }

  public void setOfficeId(String officeId) {
    this.officeId = officeId;
  }

}
