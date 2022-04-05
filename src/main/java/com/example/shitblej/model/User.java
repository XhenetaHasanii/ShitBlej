package com.example.shitblej.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

  @Entity
  @Table(name = "USER", schema = "SHITBLEJ")
  public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "CREATED")
    @CreationTimestamp
    private Date created;

    public Long getId() {
      return id;
    }

    public String getPassword() {
      return password;
    }

    public String getFirstName() {
      return firstName;
    }

    public String getLastName() {
      return lastName;
    }

    public String getPhone() {
      return phone;
    }

    public String getLocation() {
      return location;
    }

    public Date getCreated() {
      return created;
    }

    public User(String email, String password, String firstName, String lastName,
        String phone, String location) {
      this.email = email;
      this.password = password;
      this.firstName = firstName;
      this.lastName = lastName;
      this.phone = phone;
      this.location = location;
    }

    public String getEmail() {
      return email;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    public void setLastName(String lastName) {
      this.lastName = lastName;
    }

    public void setPhone(String phone) {
      this.phone = phone;
    }

    public void setLocation(String location) {
      this.location = location;
    }

    public void setCreated(Date created) {
      this.created = created;
    }

    public User() {

    }

  }
